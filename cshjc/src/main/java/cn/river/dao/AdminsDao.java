package cn.river.dao;

import cn.river.dto.GetByPage;
import cn.river.entity.AdminsEntity;

import java.util.List;

/**
 * Created by Guide on 2017/2/6.
 */
public interface AdminsDao {
    int insert(AdminsEntity adminsEntity);
    int update(AdminsEntity adminsEntity);
    int delete(int id);
    int deleteList(Integer[] ids);
    int getAllNum();
    int getPageNum(GetByPage getByPage);
    AdminsEntity queryId(int id);
    AdminsEntity queryExist(AdminsEntity adminsEntity);
    List<AdminsEntity> queryAll();
    List<AdminsEntity> queryPage(GetByPage getByPage);
}
