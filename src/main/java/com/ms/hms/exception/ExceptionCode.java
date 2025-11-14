package com.ms.hms.exception;

import com.ms.hms.common.result.BaseR;
import lombok.AllArgsConstructor;
import lombok.Getter;

/*
 *
 * http返回Code码
 * */
@Getter
@AllArgsConstructor
public enum ExceptionCode implements BaseR {

    TOKEN_IS_INVALID("10004", "no token", ""),
    PARAMTER_ERROR("10006", "param error", ""),
    ROLE_NOT_EXIST("10007","not exist","角色不存在"),
    ACCOUNT_OR_PASSWORD_ERROR("10005", "pwd error", "密码错误"),
    USER_NOT_BIND_ROLE("10008", "not bind", "用户未绑定角色"),
    PART_UPLOAD_FAIL("10009", "part upload failed", "上传文件分片失败"),
    FILE_UPLOAD_FAIL("10010", "upload file failed", "上传文件失败"),
    MERGE_FILE_FAIL("10011", "merge file failed", "合并文件失败"),
    GET_FILE_LIST_FAIL("10012", "get file list failed", "获取文件列表失败"),
    FILE_DELETE_ERROR("10013", "file delete fail", "删除文件失败"),
    BATCH_FILE_FORMAT_FAIL("20000", "batch file  format error", "文件格式错误"),
    DELETE_MENU_FAIL("30000", "delete menu failed", "删除菜单失败"),
    GET_MENU_INFO_FAIL("30001", "get menu info failed", "获取菜单信息失败");

    private final String code;
    private final String msg;
    private final String desc;


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
