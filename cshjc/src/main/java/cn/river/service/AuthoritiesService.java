package cn.river.service;

import cn.river.dao.AuthoritiesDao;
import cn.river.dto.AjaxResult;
import cn.river.dto.DataTables;
import cn.river.dto.DataTablesResult;
import cn.river.dto.GetByPage;
import cn.river.entity.AuthoritiesEntity;
import cn.river.utils.UtilCols;
import cn.river.utils.UtilDate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Guide on 2017/2/6.
 */
@Service
public class AuthoritiesService {
    @Resource
    AuthoritiesDao authoritiesDao;

    //insert
    public AjaxResult insert(AuthoritiesEntity authoritiesEntity){
        if (checkInsert(authoritiesEntity)) {
            System.out.println(authoritiesEntity.toString());
            return new AjaxResult(400, "提交的数据无效");
        }
        //添加查重
        AuthoritiesEntity entity = authoritiesDao.queryExist(authoritiesEntity);
        if (entity!=null){
            return new AjaxResult(400, "名称已存在");
        }
        //开始添加
        authoritiesEntity.setSetDate(UtilDate.yyyymmdd());
        int insert = authoritiesDao.insert(authoritiesEntity);
        if (insert<=0){
            return new AjaxResult(400, "添加失败");
        }else{
            return new AjaxResult(200, "权限添加成功");
        }
    }

    //update
    public AjaxResult update(AuthoritiesEntity authoritiesEntity){
        if (checkInsert(authoritiesEntity) || authoritiesEntity.getId()==null) {
            System.out.println(authoritiesEntity.toString());
            return new AjaxResult(400, "提交的数据无效");
        }
        //查重
        AuthoritiesEntity entity = authoritiesDao.queryExist(authoritiesEntity);
        if (entity!=null && !entity.getId().equals(authoritiesEntity.getId())){
            return new AjaxResult(400, "名称已存在");
        }
        //开始
        authoritiesEntity.setUpdateDate(UtilDate.yyyymmdd());
        int update = authoritiesDao.update(authoritiesEntity);
        if (update<=0){
            return new AjaxResult(400, "权限更新失败");
        }else{
            return new AjaxResult(200, "权限更新成功");
        }
    }

    //queryid
    public AuthoritiesEntity queryId(int id){
        return authoritiesDao.queryId(id);
    }

    //querylist search 后台可排序、查询列表
    public DataTablesResult queryList(DataTables data){
        DataTablesResult<AuthoritiesEntity> result = new DataTablesResult<AuthoritiesEntity>();
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

        List<AuthoritiesEntity> list = authoritiesDao.queryPage(params);
        result.setDraw(data.getDraw());
        result.setRecordsTotal(authoritiesDao.getAllNum());
        if (list!=null){
            result.setRecordsFiltered(authoritiesDao.getPageNum(params));
            result.setData(list);
            result.setError("");
        }else {
            result.setError("获取权限数据失败");
        }
        return result;
    }

    //queryAll
    public List<AuthoritiesEntity> queryAll(){
        return authoritiesDao.queryAll();
    }

    //deleteid
    public AjaxResult delete(int id){
        int delete = authoritiesDao.delete(id);
        if (delete<=0){
            return new AjaxResult(400, "权限删除失败");
        }else{
            return new AjaxResult(200, "权限删除成功");
        }
    }

    //deleteList
    public AjaxResult deleteList(String idStr){
        Integer[] ids = UtilCols.StringToIntArr(idStr);
        if (ids==null){
            System.out.println(idStr);
            return new AjaxResult(400,"提交的数据无效");
        }
        int delete  = authoritiesDao.deleteList(ids);
        if (delete<=0){
            return new AjaxResult(400, ""+delete+" 个权限删除失败");
        }else{
            return new AjaxResult(200, ""+delete+" 个权限删除成功");
        }
    }

    private boolean checkInsert(AuthoritiesEntity authoritiesEntity){
        if (authoritiesEntity==null){
            return true;
        }
        if (authoritiesEntity.getTitle()==null){
            return true;
        }
        return false;
    }
}
