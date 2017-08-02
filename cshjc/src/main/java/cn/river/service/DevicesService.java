package cn.river.service;

import java.util.ArrayList;
import java.util.List;

import cn.river.dao.DevicesDao;
import cn.river.dto.AjaxResult;
import cn.river.dto.DataTables;
import cn.river.dto.DataTablesResult;
import cn.river.dto.GetByPage;
import cn.river.entity.DevicesEntity;
import cn.river.execptions.RiverException;
import cn.river.utils.UtilCols;
import cn.river.utils.UtilDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

/**
 * Created by Guide on 2017/2/6.
 */
@Service
public class DevicesService {
    @Resource
    DevicesDao devicesDao;
    
  //insert
    public AjaxResult insert(DevicesEntity devicesEntity){
        if (checkInsert(devicesEntity)) {
            System.out.println(devicesEntity.toString());
            return new AjaxResult(400, "提交的数据无效");
        }
        //添加查重
        DevicesEntity entity = devicesDao.queryExist(devicesEntity);
        if (entity!=null){
            return new AjaxResult(400, "名称已存在");
        }
        //开始添加
//        moviesEntity.setSetDate(UtilDate.yyyymmdd());
        try {
            devicesEntity.setAddTime(UtilDate.DateTime());
            int insert = devicesDao.insert(devicesEntity);
            if (insert<=0){
                throw  new RiverException("FAIL");
            }else{
                return new AjaxResult(200, "设备添加成功");
            }
        }catch (RiverException e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new AjaxResult(400, "添加失败");
        }

    }

    //update
    public AjaxResult update(DevicesEntity devicesEntity){
        if (checkInsert(devicesEntity) || devicesEntity.getId()==null) {
            System.out.println(devicesEntity.toString());
            return new AjaxResult(400, "提交的数据无效");
        }
        //查重
        DevicesEntity entity = devicesDao.queryExist(devicesEntity);//queryExist在这里有一定的问题
        if (entity!=null && !entity.getId().equals(devicesEntity.getId())){
            return new AjaxResult(400, "名称已存在");
        }
        //开始
        try {
        	devicesEntity.setUpdateTime(UtilDate.DateTime());
            int update = devicesDao.update(devicesEntity);
            if (update<=0){
                throw new RiverException("FAIL");
            }else{
                return new AjaxResult(200, "设备更新成功");
            }
        }catch (RiverException e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new AjaxResult(400, "更新失败");
        }

    }

    //queryid
    public DevicesEntity queryId(int id){
        return devicesDao.queryId(id);
    }
    
    //querylist search 后台可排序、查询列表
    public DataTablesResult queryList(DataTables data){
        DataTablesResult<DevicesEntity> result = new DataTablesResult<DevicesEntity>();
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

        if (data.getSinstallTime() != null && !data.getSinstallTime().equals(""))
            params.setSinstallTime(data.getSinstallTime());
      
        if (data.getSearchWord()!=null && !data.getSearchWord().equals("") && data.getSearchWord().length()>0){
            params.setSearchWord("%"+data.getSearchWord()+"%");
        }else{
            params.setSearchWord(null);
        }

        List<DevicesEntity> list = devicesDao.queryPage(params);
        result.setDraw(data.getDraw());
        result.setRecordsTotal(devicesDao.getAllNum());
        if (list!=null){
            result.setRecordsFiltered(devicesDao.getPageNum(params));
            result.setData(list);
            result.setError("");
        }else {
            result.setError("获取数据失败");
        }
        return result;
    }

    //queryAll
    public List<DevicesEntity> queryAll(){
        return devicesDao.queryAll();
    }

    //deleteid
    public AjaxResult delete(int id){
        int delete = devicesDao.delete(id);
        if (delete<=0){
            return new AjaxResult(400, "设备删除失败");
        }else{
            return new AjaxResult(200, "设备删除成功");
        }
    }

    //deleteList
    public AjaxResult deleteList(String idStr){
        Integer[] ids = UtilCols.StringToIntArr(idStr);
        if (ids==null){
            System.out.println(idStr);
            return new AjaxResult(400,"提交的数据无效");
        }
        int delete  = devicesDao.deleteList(ids);
        if (delete<=0){
            return new AjaxResult(400, ""+delete+" 个设备删除失败");
        }else{
            return new AjaxResult(200, ""+delete+" 个设备删除成功");
        }
    }

    private boolean checkInsert(DevicesEntity devicesEntity){
        if (devicesEntity==null){
            return true;
        }
        if (devicesEntity.getDeviceId()==null){
            return true;
        }
        if (devicesEntity.getDeviceName()==null){
            return true;
        }
        if (devicesEntity.getSpotId()==null){
            return true;
        }
        return false;
    }
   
}
