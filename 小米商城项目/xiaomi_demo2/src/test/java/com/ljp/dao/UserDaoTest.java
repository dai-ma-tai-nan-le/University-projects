package com.ljp.dao;


import com.ljp.util.MyBatisUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Test;


public class UserDaoTest {


    @Test
    public void selectByUsernameAndPassword() {
//        UserDao userDao =MyBatisUtils.getMapper(UserDao.class);
//       // User user= userDao.selectByUsernameAndPassword("zhangsan","e10adc3949ba59abbe56e057f20f883e");
//        System.out.println(user);
//        MyBatisUtils.closeSession();
//        Assert.assertNotNull(user);
    }

    @Test
    public void insertUser() {
        UserDao userDao =MyBatisUtils.getMapper(UserDao.class);
        System.out.println(userDao.selectByUsername("ljp"));

        // User user = new User(0,"sunzi","123456","123@qq.com","男",1,1,"");
       // int count= userDao.insertUser(user);
        MyBatisUtils.commit();
        //System.out.println(count);
        //Assert.assertEquals(1,count);
    }


}