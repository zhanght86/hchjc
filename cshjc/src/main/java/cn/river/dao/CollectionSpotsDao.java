package cn.river.dao;

import java.util.List;

import cn.river.dto.GetByPage;
import cn.river.entity.CollectionSpotsEntity;

/**
 * Created by Guide on 2017/2/6.
 */
public interface CollectionSpotsDao { 
    int insert(CollectionSpotsEntity collectionSpotsEntity);
    int update(CollectionSpotsEntity collectionSpotsEntity);
    int delete(Integer spotId);
    int deleteList(Integer[] ids);
    int getAllNum();
    int getPageNum(GetByPage getByPage);
    CollectionSpotsEntity queryId(Integer spotId);
    CollectionSpotsEntity queryExist(CollectionSpotsEntity collectionSpotsEntity);
    List<CollectionSpotsEntity> queryAll();
    List<CollectionSpotsEntity> queryPage(GetByPage getByPage);
}
