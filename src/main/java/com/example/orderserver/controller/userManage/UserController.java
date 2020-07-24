package com.example.orderserver.controller.userManage;

import com.example.orderserver.annotation.CurrentUser;
import com.example.orderserver.annotation.SystemLog;
import com.example.orderserver.bean.PageResult;
import com.example.orderserver.bean.QueryParam;
import com.example.orderserver.entity.userManage.UserEntity;
import com.example.orderserver.service.userManage.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author by czf
 * @date 2020/7/23.
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @SystemLog(module = "用户管理", operation = "查询列表")
    @PostMapping(value = "queryPretend", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResult<UserEntity> queryPretend(@RequestBody QueryParam queryParam,@CurrentUser UserEntity user) {
        PageResult<UserEntity> pageResult = userService.findPage(queryParam, user);
        return pageResult;
    }

    @SystemLog(module = "用户管理", operation = "根据用户ID查询列表")
    @PostMapping(value = "findUsersById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<UserEntity> findUsersById(@RequestBody QueryParam queryParam, @CurrentUser UserEntity user) {
        //测试数据
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1);
        List<UserEntity> userEntities = userService.findUsersById(userEntity.getId());
        return userEntities;
    }
}
