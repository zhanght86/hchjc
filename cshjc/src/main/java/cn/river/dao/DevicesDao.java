package cn.river.dao;

import java.util.List;

import cn.river.dto.GetByPage;
import cn.river.entity.DevicesEntity;

/**
 * Created by Guide on 2017/2/6.
 */
public interface DevicesDao { 
    int insert(DevicesEntity devicesEntity);
    int update(DevicesEntity devicesEntity);
    int delete(int id);
    int deleteList(Integer[] ids);
    int getAllNum();
    int getPageNum(GetByPage getByPage);
    DevicesEntity queryId(int id);
    DevicesEntity queryExist(DevicesEntity devicesEntity);
    List<DevicesEntity> queryAll();
    List<DevicesEntity> queryPage(GetByPage getByPage);
}
