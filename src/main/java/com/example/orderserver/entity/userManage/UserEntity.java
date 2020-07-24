package com.example.orderserver.entity.userManage;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.example.orderserver.group.Create;
import com.example.orderserver.group.Update;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


/**
 * 用户类
 * @author by czf
 * @date 2020/7/23.
 */
@Data
@TableName("tb_user")
public class UserEntity {

    /**
     * 用户ID
     */
    @TableId
    private Integer id;

    /**
     * 用户名
     */
    @NotBlank(message = "登录名不能为空", groups = {Create.class, Update.class, UserLogin.class})
    @Length(message = "登录名不能超过100字符", max = 100, groups = {Create.class, Update.class, UserLogin.class})
    private String loginName;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空", groups = {Create.class,Update.class, UserLogin.class})
    private String password;

    /**
     * 联系电话
     */
    @NotBlank(message = "手机号不能为空", groups = {Create.class, Update.class, Captcha.class})
    @Pattern(regexp = "^1[345789]\\d{9}$", message = "手机号码格式错误", groups = {Create.class, Update.class, Captcha.class})
    private String phone;

    //定义不同的validation规则
    public interface UserLogin {
    }

    public interface Captcha {
    }

}
