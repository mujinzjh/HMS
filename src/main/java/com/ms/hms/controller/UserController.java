package com.ms.hms.controller;

import com.aliyun.oss.model.PutObjectResult;
import com.ms.hms.Interceptor.TokenInterceptor;
import com.ms.hms.aop.Log;
import com.ms.hms.common.Constants;
import com.ms.hms.common.result.R;
import com.ms.hms.common.utils.FileUtils;
import com.ms.hms.entity.Param.BindParam;
import com.ms.hms.entity.Param.UserParam;
import com.ms.hms.entity.SysUser;
import com.ms.hms.entity.SysUserResult;
import com.ms.hms.exception.ExceptionCode;
import com.ms.hms.exception.ServiceException;
import com.ms.hms.service.OSSService;
import com.ms.hms.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author zhaojianhua
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private OSSService ossService;

    @Value("${aliyun.bucketName}")
    private String bucketName;

    @Log(value = "获取用户信息")
    @GetMapping("/findUser")
    public R findById(Long id) {
        return R.ok().data(userService.findById(id));
    }

    @Log(value = "添加用户")
    @PostMapping(value = "/add")
    public R createUser(@RequestBody UserParam userParam) {
        return userService.createUser(userParam, Constants.DEFAULT_PASSWORD);
    }

    @Log(value = "用户列表")
    @GetMapping(value = "/list")
    public R getListInfo(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, @RequestParam("search") String search){
        if (pageNo == null || pageSize == null || StringUtils.isBlank(search)) {
            throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
        }
        return userService.getUserListInfo(pageNo, pageSize, search);
    }

    @Log(value = "用户列表")
    @GetMapping(value = "/allData")
    public R getAllUserData(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, @RequestParam("search") String search){
        if (pageNo == null || pageSize == null || StringUtils.isBlank(search)) {
            throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
        }
        Map<String, Object> map = userService.getUserData(pageNo, pageSize, search);
        List<SysUserResult> resultList = (List<SysUserResult>) map.get("list");
        for (SysUserResult user : resultList) {
            if (user.getAvatar() != null) {
                user.setAvatar(String.valueOf(ossService.getFileUrl(user.getAvatar(), bucketName)));
            }
        }
        return R.ok().ext(map.get("ext")).data(resultList);
    }
    @Log(value = "删除用户")
    @DeleteMapping(value = "/del")
    public R delUser(Long id){
        if (id == null ){
            throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
        }
        return userService.delUser(id);
    }

    @Log(value = "绑定角色")
    @PostMapping(value = "/bind")
    public R userBindRole(@RequestBody BindParam bindParam){
        if (bindParam.getUserId() == null || bindParam.getRoleId() == null){
            throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
        }
        return userService.userBindRole(bindParam);
    }

    @Log(value = "解绑角色")
    @PostMapping(value = "/unbind")
    public R userUnBindRole(Long userRoleId){
        if (userRoleId == null){
            throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
        }
        return userService.userUnbindRole(userRoleId);
    }

    @Log(value = "上传头像")
    @PostMapping(value = "/uploadAvatar")
    public R uploadAvatar(MultipartFile file) throws IOException {
        if (file == null){
            throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
        }
        SysUser user = TokenInterceptor.THREAD_LOCAL.get();
        InputStream inputStream = file.getInputStream();
        String fileName = file.getOriginalFilename();
        String filePath = FileUtils.getFullPath(fileName);
        PutObjectResult result = ossService.uploadFile(inputStream, filePath, bucketName);
        if (result.getETag() == null) {
            throw new ServiceException(ExceptionCode.FILE_UPLOAD_FAIL);
        } else {
            user.setAvatar(filePath);
            int updateCount = userService.updateAvatar(user);
            if (updateCount <= 0) {
                throw new ServiceException(ExceptionCode.FILE_UPLOAD_FAIL);
            }
            return R.ok();
        }
    }

    @Log(value = "批量导入用户")
    @PostMapping(value = "/batchImport")
    public R updateUserInfo(MultipartFile file){
        if (file == null){
            throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
        }
        String fileName = file.getOriginalFilename();
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        String[] fileType = {"xlsx", "xls", "csv"};
        List<String> fileTypeList = Arrays.asList(fileType);
        if (!fileTypeList.contains(fileExtension)) {
            throw new ServiceException(ExceptionCode.BATCH_FILE_FORMAT_FAIL);
        } else {
            userService.batchImport(file);
            return R.ok();
        }

    }
}
