package com.ljp.demo.service.impl;

import com.ljp.demo.entity.Upload;
import com.ljp.demo.dao.UploadDao;
import com.ljp.demo.entity.User;
import com.ljp.demo.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.Date;

/**
 * (Upload)表服务实现类
 *
 * @author makejava
 * @since 2023-03-14 20:38:20
 */
@Service
public class UploadServiceImpl implements UploadService {
    @Resource
    private UploadDao uploadDao;

    //更新头像
    @Override
    public void updateAvatar(User user) {
        uploadDao.updateAvatar(user);
    }


    //保存文件到数据库
    @Override
    public void insertFile(Upload upload) {
        upload.setCreateTime(new Date());
        upload.setUpdateTime(new Date());
        uploadDao.insertFile(upload);
    }
    ///下载次数+1
    @Override
    public void updateDownNum(Upload upload) {
        uploadDao.updateDownNum(upload);
    }
}
