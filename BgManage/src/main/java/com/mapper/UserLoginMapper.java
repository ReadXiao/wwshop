package com.mapper;

import com.pojo.GmsCatalog;
import com.pojo.UmsUserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/4/21 - 21:35
 */
public interface UserLoginMapper {

    UmsUserInfo userLoginByPass(@Param("username") String username, @Param("password") String password);

    UmsUserInfo userFindUserByPhone(String telPhone);

    List<GmsCatalog> findAllCatalog();
}
