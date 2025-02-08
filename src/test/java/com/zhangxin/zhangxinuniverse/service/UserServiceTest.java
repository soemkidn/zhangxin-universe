package com.zhangxin.zhangxinuniverse.service;


import com.zhangxin.zhangxinuniverse.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 用户服务测试
 */
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    /**
     * 测试 MyBatis-Plus添加用户功能
     */
    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("Ken");
        user.setUserAccount("123");
        user.setAvatarUrl("https://636f-codenav-8grj8px727565176-1256524210.tcb.qcloud.la/img/logo.png");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");
        boolean result = userService.save(user);
        System.out.println(user.getId()); //插入后得到id为2
        Assertions.assertTrue(result);
    }


    /**
     * 测试更新用户
     */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("Kennith");
        user.setUserAccount("123");
        user.setAvatarUrl("https://636f-codenav-8grj8px727565176-1256524210.tcb.qcloud.la/img/logo.png");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");
        boolean result = userService.updateById(user);// 断言不报错代表更新成功
        Assertions.assertTrue(result);
    }

    /**
     * 测试删除用户
     */
    @Test
    public void testDeleteUser() {
        boolean result = userService.removeById(1L);
        Assertions.assertTrue(result); // 断言不报错代表删除成功
    }


    /**
     * 测试获取用户
     */
    @Test
    public void testGetUser() {
        User user = userService.getById(3L);
        System.out.println(user);
        Assertions.assertNotNull(user); //user不为空则代表测试成功
    }

    /**
     * 测试用户注册
     */
    @Test
    void userRegister() {
        //测试非空
        String userAccount = "Lord_Kennith";
        String userPassword = "";
        String checkPassword = "123456";
        String planetCode = "1";
        long result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        //测试账户长度不小于4
        userAccount = "ken";
        userPassword = "1";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        //密码长度不小于8
        userAccount = "Lord_Kennith";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        //账户名不包含特殊字符
        userAccount = "k@en";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        //密码和校验密码一致
        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        //账户名字不能相同
        userAccount = "123";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        userAccount = "Lord_Kennith";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
    }
}