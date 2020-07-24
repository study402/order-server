package com.example.orderserver.dao.userManage;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.orderserver.entity.userManage.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author by czf
 * @date 2020/7/23.
 */
@Repository
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

    /**
     * 用户列表查询 (分页版)
     * @param  page
     * @param  param
     */
    IPage<UserEntity> findPage(IPage<UserEntity> page, @Param("param") Map<String, Object> param);

    /**
     * 根据ID查询用户列表
     * @param  id
     */
    List<UserEntity> findUsersById(@Param("id") Integer id);

}
