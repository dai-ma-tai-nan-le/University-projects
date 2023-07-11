package com.ljp.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ClassUtils;
import com.ljp.demo.entity.Upload;
import com.ljp.demo.entity.User;
import com.ljp.demo.service.StudyRoomService;
import com.ljp.demo.service.UploadService;
import com.ljp.demo.utils.Result;
import com.ljp.demo.utils.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * 文件上传
 *
 * @author makejava
 * @since 2023-03-14 20:38:20
 */
@RestController
@RequestMapping("/upload")
public class UploadController {
    /**
     * 服务对象
     */
    @Resource
    private UploadService uploadService;
    @Autowired
    private StudyRoomService studyRoomService;


    String username;
    String userGroup;
    int id;
    //获取用户名
    @PostMapping("/avatar1")
    public Result avatar1(@RequestBody Map<String, String> data){
        username=data.get("username");
        userGroup=data.get("userGroup");
        id= Integer.parseInt(data.get("id"));
        return Result.suc();
    }
    //上传头像
    @PostMapping("/avatar")
    public Result upload(@RequestParam MultipartFile file){
        //获取文件名称
        String originalFilename = file.getOriginalFilename();
//        System.out.println(username);
//        //获取文件类型
//        String type = FileUtil.extName(originalFilename);
        if ( file != null) {
            //获得项目的类路径
            String path = "C:\\Users\\31329\\Desktop\\学生自我管理系统\\xszlglxthd\\src\\main\\resources\\";
            File uploadDir = new File(path+"/static/img");
            if (!uploadDir.exists()) {
//                System.out.println("上传头像路径不存在，正在创建...");
                uploadDir.mkdir();
            }
            //我的文件保存在static目录下的avatar/user
            String uuid = IdUtil.fastSimpleUUID();
            File avatar = new File(path+"/static/img/" , uuid+"==="+originalFilename);
            try {
                //保存图片
                file.transferTo(avatar);
                String avatar1="/img/"+uuid+"==="+originalFilename;
//                System.out.println(avatar1);
                User user=new User(userGroup,username,avatar1);
                uploadService.updateAvatar(user);
                return  Result.suc();
            }catch (IOException e) {
                e.printStackTrace();
                return  Result.fail();
            }
        }else{
            return Result.fail8();
        }
    }


    //上传文件
    @PostMapping("/document")
    public Result upload1(@RequestParam MultipartFile file){
        //获取文件名称
        String originalFilename = file.getOriginalFilename();
        //获取文件类型
        String type = FileUtil.extName(originalFilename);
        //文件大小
        long size = file.getSize();
        if ( file != null) {
            //获得项目的类路径
            String path = "C:\\Users\\31329\\Desktop\\学生自我管理系统\\xszlglxthd\\src\\main\\resources\\";
            File uploadDir = new File(path+"/static/document");
            if (!uploadDir.exists()) {
//                System.out.println("上传头像路径不存在，正在创建...");
                uploadDir.mkdir();
            }
            // 定义唯一标识码
//            String code;
//          //获取文件的md5
//            code = SecureUtil.md5(files);
//            String fileUUID = uuid + StrUtil.DOT +  type;
            String uuid = IdUtil.fastSimpleUUID();
            //我的文件保存在static目录下的avatar/document
            File files = new File(path+"/static/document/" , uuid+"==="+originalFilename);
            try {
                //保存图片
                file.transferTo(files);
                // 存储到数据库
                Upload upload=new Upload(0,originalFilename,id,username,uuid,type,size,0);
                uploadService.insertFile(upload);
                return  Result.suc();
            }catch (IOException e) {
                e.printStackTrace();
                return  Result.fail();
            }
        }else{
            return Result.fail();
        }
    }

    /**
     * 文件下载路径
     *
     */
    @GetMapping("/{uploadId}")
    public void download(@PathVariable int uploadId, HttpServletResponse response) throws IOException {
        String path = "C:\\Users\\31329\\Desktop\\学生自我管理系统\\xszlglxthd\\src\\main\\resources\\static\\document\\";
        List<Upload> list=studyRoomService.selectDocId(uploadId);
        String uuid=list.get(0).getCode();
        String name=list.get(0).getName();
        File uploadFile = new File(path + uuid+"==="+name);
        //下载次数+1
        int num=list.get(0).getDownloadNum()+1;
        Upload upload=new Upload(name,uuid,num);
        uploadService.updateDownNum(upload);
        // 设置输出流的格式
        ServletOutputStream os = response.getOutputStream();
        response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(name, "UTF-8"));
        response.setContentType("application/octet-stream");

        // 读取文件的字节流
        os.write(FileUtil.readBytes(uploadFile));
        os.flush();
        os.close();
    }




    //上传音乐
    @PostMapping("/music")
    public Result upload2(@RequestParam MultipartFile file){
        //获取文件名称
        String originalFilename = file.getOriginalFilename();
        //获取文件类型
        String type = FileUtil.extName(originalFilename);
        //文件大小
        long size = file.getSize();
        if ( file != null) {
            //获得项目的类路径
            String path = "C:\\Users\\31329\\Desktop\\学生自我管理系统\\xszlglxthd\\src\\main\\resources\\";
            File uploadDir = new File(path+"/static/music");
            if (!uploadDir.exists()) {
//                System.out.println("上传头像路径不存在，正在创建...");
                uploadDir.mkdir();
            }
            // 定义唯一标识码
            String uuid = IdUtil.fastSimpleUUID();
            //我的文件保存在static目录下的avatar/document
            File files = new File(path+"/static/music/" , uuid+"==="+originalFilename);
            try {
                //保存图片
                file.transferTo(files);
                String code="/music/"+uuid+"==="+originalFilename;
                // 存储到数据库
                Upload upload=new Upload(0,originalFilename,-1,username,code,type,size,0);
                uploadService.insertFile(upload);
                return  Result.suc();
            }catch (IOException e) {
                e.printStackTrace();
                return  Result.fail();
            }
        }else{
            return Result.fail();
        }
    }
    //返回音乐流
    @PostMapping("/audio")
    public byte[] videoPreview(@RequestBody Map<String, String> data) throws Exception {
        String code=data.get("code");
        String path = "C:/Users/31329/Desktop/学生自我管理系统/xszlglxthd/src/main/resources/static";
        String realPath = path +code;
        System.out.println(realPath+"=================aaaaa==========");
//        File uploadFile = new File(realPath);
//        // 设置输出流的格式
//        ServletOutputStream os = response.getOutputStream();
//        response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(name, "UTF-8"));
//        response.setContentType("application/octet-stream");
//
//        // 读取文件的字节流
//        os.write(FileUtil.readBytes(uploadFile));
//        os.flush();
//        os.close();
        byte[] bytes = Files.readAllBytes(Paths.get(realPath));
        System.out.println(bytes.length);
        return bytes;
    }

}

