package cn.river.service;

import java.util.List;

import cn.river.dao.CollectionSpotsDao;
import cn.river.dto.AjaxResult;
import cn.river.dto.DataTables;
import cn.river.dto.DataTablesResult;
import cn.river.dto.GetByPage;
import cn.river.entity.CollectionSpotsEntity;
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
public class CollectionSpotsService {
    @Resource
    CollectionSpotsDao collectionSpotsDao;
    
  //insert
    public AjaxResult insert(CollectionSpotsEntity spontsEntity){
        if (checkInsert(spontsEntity)) {
            System.out.println(spontsEntity.toString());
            return new AjaxResult(400, "提交的数据无效");
        }
        //添加查重
        CollectionSpotsEntity entity = collectionSpotsDao.queryExist(spontsEntity);
        if (entity!=null){
            return new AjaxResult(400, "名称已存在");
        }
        //开始添加
        try {
        	spontsEntity.setAddTime(UtilDate.DateTime());
            int insert = collectionSpotsDao.insert(spontsEntity);
            if (insert<=0){
                throw  new RiverException("FAIL");
            }else{
                return new AjaxResult(200, "数据采集点添加成功");
            }
        }catch (RiverException e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new AjaxResult(400, "添加失败");
        }

    }

    //update
    public AjaxResult update(CollectionSpotsEntity spotsEntity){
        if (checkInsert(spotsEntity) || spotsEntity.getSpotId()==null) {
            System.out.println(spotsEntity.toString());
            return new AjaxResult(400, "提交的数据无效");
        }
        //查重
        CollectionSpotsEntity entity = collectionSpotsDao.queryExist(spotsEntity);//queryExist在这里有一定的问题
        if (entity!=null && !entity.getSpotId().equals(spotsEntity.getSpotId())){
            return new AjaxResult(400, "名称已存在");
        }
        //开始
        try {
        	spotsEntity.setUpdateTime(UtilDate.DateTime());
            int update = collectionSpotsDao.update(spotsEntity);
            if (update<=0){
                throw new RiverException("FAIL");
            }else{
                return new AjaxResult(200, "数据采集点更新成功");
            }
        }catch (RiverException e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new AjaxResult(400, "更新失败");
        }

    }

    //queryid
    public CollectionSpotsEntity queryId(Integer spotId){
        return collectionSpotsDao.queryId(spotId);
    }
    
    //querylist search 后台可排序、查询列表
    public DataTablesResult queryList(DataTables data){
        DataTablesResult<CollectionSpotsEntity> result = new DataTablesResult<CollectionSpotsEntity>();
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

        List<CollectionSpotsEntity> list = collectionSpotsDao.queryPage(params);
        result.setDraw(data.getDraw());
        result.setRecordsTotal(collectionSpotsDao.getAllNum());
        if (list!=null){
            result.setRecordsFiltered(collectionSpotsDao.getPageNum(params));
            result.setData(list);
            result.setError("");
        }else {
            result.setError("获取数据失败");
        }
        return result;
    }

    //queryAll
    public List<CollectionSpotsEntity> queryAll(){
        return collectionSpotsDao.queryAll();
    }

    //deleteid
    public AjaxResult delete(Integer spotId){
        int delete = collectionSpotsDao.delete(spotId);
        if (delete<=0){
            return new AjaxResult(400, "数据采集点删除失败");
        }else{
            return new AjaxResult(200, "数据采集点删除成功");
        }
    }

    //deleteList
    public AjaxResult deleteList(String idStr){
        Integer[] ids = UtilCols.StringToIntArr(idStr);
        if (ids==null){
            System.out.println(idStr);
            return new AjaxResult(400,"提交的数据无效");
        }
        int delete  = collectionSpotsDao.deleteList(ids);
        if (delete<=0){
            return new AjaxResult(400, ""+delete+" 个数据采集点删除失败");
        }else{
            return new AjaxResult(200, ""+delete+" 个数据采集点删除成功");
        }
    }

    private boolean checkInsert(CollectionSpotsEntity spotsEntity){
        if (spotsEntity==null){
            return true;
        }
        if (spotsEntity.getSpotName()==null){
            return true;
        }
        return false;
    }
   
}
