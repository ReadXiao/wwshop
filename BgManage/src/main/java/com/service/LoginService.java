package com.service;

import com.pojo.MmsAdminInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author 肖宏武
 * @date 2020/3/27 - 22:41
 */
public interface LoginService {
    MmsAdminInfo adminLoginByPass(String username, String password);

    MmsAdminInfo adminFindUserByPhone(String telPhone);

    int updateLoginTime(String date, int id);

    int updateUnLoginDate(String date, int id);
}
