package com.ljp.demo.dao;

import com.ljp.demo.entity.Upload;
import com.ljp.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Upload)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-14 20:38:20
 */
@Mapper
public interface UploadDao {


    //更新头像
    @Update("update user set avatar=#{avatar} where username=#{username} and user_group=#{userGroup}")
    void updateAvatar(User user);


    //保存文件到数据库
    @Insert("insert into upload values(null,#{name},#{id},#{username},#{code},#{type},#{docSize},#{downloadNum},#{createTime},#{updateTime})")
    void insertFile(Upload upload);
    ///下载次数+1
    @Update("update upload set downloadNum=#{downloadNum} where name=#{name} and code=#{code}")
    void updateDownNum(Upload upload);
}

