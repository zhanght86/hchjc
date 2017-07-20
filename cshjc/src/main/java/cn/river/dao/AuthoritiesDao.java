package cn.river.dao;

import cn.river.dto.GetByPage;
import cn.river.entity.AuthoritiesEntity;

import java.util.List;

/**
 * Created by Guide on 2017/2/6.
 */
public interface AuthoritiesDao {
    int insert(AuthoritiesEntity authoritiesEntity);
    int update(AuthoritiesEntity authoritiesEntity);
    int delete(int id);
    int deleteList(Integer[] ids);
    int getAllNum();
    int getPageNum(GetByPage getByPage);
    AuthoritiesEntity queryId(int id);
    AuthoritiesEntity queryExist(AuthoritiesEntity authoritiesEntity);
    List<AuthoritiesEntity> queryAll();
    List<AuthoritiesEntity> queryPage(GetByPage getByPage);
}
