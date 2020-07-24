package com.example.orderserver.service.userManage;

import com.example.orderserver.bean.PageResult;
import com.example.orderserver.bean.QueryParam;
import com.example.orderserver.entity.userManage.UserEntity;

import java.util.List;

/**
 * @author by XXX
 * @date 2020/7/23.
 */

public interface UserService {

    /**
     * 用户列表查询 (分页版)
     * @param  queryParam
     * @param  currentUser
     */
    PageResult<UserEntity> findPage(QueryParam queryParam, UserEntity currentUser);

    /**
     * 根据ID查询用户列表
     * @param  id
     */
    List<UserEntity> findUsersById(Integer id);
}
