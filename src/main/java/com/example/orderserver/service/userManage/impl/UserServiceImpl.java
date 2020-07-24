package com.example.orderserver.service.userManage.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.orderserver.bean.PageResult;
import com.example.orderserver.bean.QueryParam;
import com.example.orderserver.dao.userManage.UserDao;
import com.example.orderserver.entity.userManage.UserEntity;
import com.example.orderserver.service.userManage.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author by czf
 * @date 2020/7/23.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    protected UserDao userDao;

    @Override
    public PageResult<UserEntity> findPage(QueryParam queryParam, UserEntity currentUser) {
        Map<String, Object> param = queryParam.toMap();
        IPage<UserEntity> page = userDao.findPage(queryParam.toPage(), param);
        return new PageResult<>(page);
    }

    @Override
    public List<UserEntity> findUsersById(Integer id) {
        return userDao.findUsersById(id);
    }

}
