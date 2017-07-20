package cn.river.service;

import cn.river.dao.AdminsDao;
import cn.river.dto.AjaxResult;
import cn.river.dto.DataTables;
import cn.river.dto.DataTablesResult;
import cn.river.dto.GetByPage;
import cn.river.entity.AdminsEntity;
import cn.river.utils.UtilCols;
import cn.river.utils.UtilDate;
import cn.river.utils.UtilMD5;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Guide on 2017/2/6.
 */
@Service
public class AdminsService {
    @Resource
    AdminsDao adminsDao;

    //validate
    public AjaxResult validate(String username, String password, HttpServletRequest request,String authorCode){
        if (request.getSession().getAttribute("strCode") == null || authorCode == null || !request.getSession().getAttribute("strCode").equals(authorCode)){
            return new AjaxResult(400,"验证码错误");
        }
        AdminsEntity a1 = new AdminsEntity(username,password);//UtilMD5.getMD5Code(password));
        AdminsEntity a2 = adminsDao.queryExist(a1);
        System.out.println("a2:name->"+a2.getUsername()+",pass->"+a2.getPassword()+";a1:name->"+a1.getUsername()+",pass->"+a1.getPassword());
        if (a2!=null && a2.getPassword()!=null && !a2.getPassword().equals(a1.getPassword())){
            return new AjaxResult(400,"用户名或密码错误");
        }
        if (a2!=null && a2.getPassword()!=null && a2.getPassword().equals(a1.getPassword())){
            request.getSession().setAttribute("adminInfo",a2);
            return new AjaxResult(200,"登录成功");
        }
        return new AjaxResult(400,"账号不存在");
    }


    //insert
    public AjaxResult insert(AdminsEntity adminsEntity){
        if (checkInsert(adminsEntity) || adminsEntity.getPassword()==null || adminsEntity.getPassword().trim().equals("")) {
            System.out.println(adminsEntity.toString());
            return new AjaxResult(400, "提交的数据无效");
        }
        //添加查重
        AdminsEntity entity = adminsDao.queryExist(adminsEntity);
        if (entity!=null){
            return new AjaxResult(400, "名称已存在");
        }
        //开始添加
        adminsEntity.setSetDate(UtilDate.yyyymmdd());
        adminsEntity.setPassword(UtilMD5.getMD5Code(adminsEntity.getPassword()));
        int insert = adminsDao.insert(adminsEntity);
        if (insert<=0){
            return new AjaxResult(400, "添加失败");
        }else{
            return new AjaxResult(200, "管理员添加成功");
        }
    }

    //update
    public AjaxResult update(AdminsEntity adminsEntity){
        if (checkInsert(adminsEntity) || adminsEntity.getId()==null) {
            System.out.println(adminsEntity.toString());
            return new AjaxResult(400, "提交的数据无效");
        }
        //查重
        AdminsEntity entity = adminsDao.queryExist(adminsEntity);
        if (entity!=null && !entity.getId().equals(adminsEntity.getId())){
            return new AjaxResult(400, "名称已存在");
        }
        //开始
        adminsEntity.setUpdateDate(UtilDate.yyyymmdd());
        int update = adminsDao.update(adminsEntity);
        if (update<=0){
            return new AjaxResult(400, "管理员更新失败");
        }else{
            return new AjaxResult(200, "管理员更新成功");
        }
    }

    //updatepwd
    public AjaxResult updatepwd(AdminsEntity adminsEntity){
        if (adminsEntity.getId()==null || adminsEntity.getPassword()==null || adminsEntity.getPassword().trim().equals("")) {
            System.out.println(adminsEntity.toString());
            return new AjaxResult(400, "提交的数据无效");
        }

        //开始
        adminsEntity.setUpdateDate(UtilDate.yyyymmdd());
        adminsEntity.setPassword(UtilMD5.getMD5Code(adminsEntity.getPassword()));
        int update = adminsDao.update(adminsEntity);
        if (update<=0){
            return new AjaxResult(400, "密码更新失败");
        }else{
            return new AjaxResult(200, "密码更新成功");
        }
    }


    //queryid
    public AdminsEntity queryId(int id){
        return adminsDao.queryId(id);
    }

    //querylist search 后台可排序、查询列表
    public DataTablesResult queryList(DataTables data){
        DataTablesResult<AdminsEntity> result = new DataTablesResult<AdminsEntity>();
        result.setError("缺少参数");
        if (data.getColums()==null || data.getColums().length==0){
            return result;
        }
        if (data.getDraw()==null){
            return result;
        }
        if (data.getLength()==null || data.getLength() <=0){
            return result;
        }
        if (data.getStart()==null || data.getStart()<0){
            return result;
        }
        GetByPage params = new GetByPage();
        params.setOrderCol(data.getColums()[data.getSortingCol()]);
        params.setSearchCols(UtilCols.Modify(data.getColums()));
        params.setLength(data.getLength());
        params.setOrder(data.getOrder());
        params.setStart(data.getStart());
        if (data.getSearchWord()!=null && !data.getSearchWord().equals("") && data.getSearchWord().length()>0){
            params.setSearchWord("%"+data.getSearchWord()+"%");
        }else{
            params.setSearchWord(null);
        }

        List<AdminsEntity> list = adminsDao.queryPage(params);
        result.setDraw(data.getDraw());
        result.setRecordsTotal(adminsDao.getAllNum());
        if (list!=null){
            result.setRecordsFiltered(adminsDao.getPageNum(params));
            result.setData(list);
            result.setError("");
        }else {
            result.setError("获取数据失败");
        }
        return result;
    }

    //queryAll
    public List<AdminsEntity> queryAll(){
        return adminsDao.queryAll();
    }

    //deleteid
    public AjaxResult delete(int id){
        int delete = adminsDao.delete(id);
        if (delete<=0){
            return new AjaxResult(400, "管理员删除失败");
        }else{
            return new AjaxResult(200, "管理员删除成功");
        }
    }

    //deleteList
    public AjaxResult deleteList(String idStr){
        Integer[] ids = UtilCols.StringToIntArr(idStr);
        if (ids==null){
            System.out.println(idStr);
            return new AjaxResult(400,"提交的数据无效");
        }
        int delete  = adminsDao.deleteList(ids);
        if (delete<=0){
            return new AjaxResult(400, ""+delete+" 个管理员删除失败");
        }else{
            return new AjaxResult(200, ""+delete+" 个管理员删除成功");
        }
    }

    private boolean checkInsert(AdminsEntity adminsEntity){
        if (adminsEntity==null){
            return true;
        }
        if (adminsEntity.getUsername()==null || adminsEntity.getUsername().trim().equals("")){
            System.out.println("getUsername");
            return true;
        }
        if (adminsEntity.getHeadImg()==null || adminsEntity.getHeadImg().trim().equals("")){
            System.out.println("getHeadImg");
            return true;
        }
        if (adminsEntity.getEmail()==null || adminsEntity.getEmail().trim().equals("") || adminsEntity.getEmail().trim().length()<7){
            System.out.println("getEmail");
            return true;
        }
        if (adminsEntity.getAuthorityId()==null){
            return true;
        }
        return false;
    }
}
