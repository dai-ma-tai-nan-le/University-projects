package com.ljp.demo.service;

import com.ljp.demo.entity.Upload;
import com.ljp.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Upload)表服务接口
 *
 * @author makejava
 * @since 2023-03-14 20:38:20
 */
public interface UploadService {


    //更新头像
    void updateAvatar(User user);


    //保存文件到数据库
    void insertFile(Upload upload);
    //下载次数+1
    void updateDownNum(Upload upload);
}
