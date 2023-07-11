package com.ljp.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {

    //1.创建sqlSessionFactory
    private  static SqlSessionFactory factory;
    //线程本地变量
    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();
    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            factory=new SqlSessionFactoryBuilder().build(is);
            is.close();
            System.out.println("SqlSessionFactory创建成功");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //2.创建返回sqlsession的方法
    public static SqlSession openSession(){
        SqlSession sqlSession=threadLocal.get();
        if (sqlSession==null){
            sqlSession = factory.openSession();
            threadLocal.set(sqlSession); //绑定到线程
        }
        return  sqlSession;
    }

    //3.关闭sqlsession
    public static void closeSession(){
        SqlSession sqlSession=openSession();
        if (sqlSession!=null){
            MyBatisUtils.clearCache();
            sqlSession.close();
            threadLocal.remove(); //解除绑定
        }
    }

    //4.提交事务
    public static void commit() {
        SqlSession sqlSession = openSession();
        if (sqlSession != null) {
            sqlSession.commit();
            closeSession();
        }
    }

    //5.回滚事务
    public static void rollback() {
        SqlSession sqlSession = openSession();
        if (sqlSession != null) {
            sqlSession.rollback();
            closeSession();
        }
    }

    //6.返回Dao接口的实现类对象
    public static <T> T getMapper(Class<T> clazz){
        SqlSession sqlSession=openSession();
        if (sqlSession!=null){
            return sqlSession.getMapper(clazz);
        }
        return null;
    }
    //7.清除缓存的方法
    public static void clearCache(){
        SqlSession sqlSession=openSession();
        if (sqlSession!=null){
            sqlSession.clearCache();//清除一级缓存
        }
    }
}
