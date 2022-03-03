package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 肖宏武
 * @date 2020/3/21 - 18:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MmsAdminInfo {
    private int id;
    private String name;
    private String telPhone;
    private String password;
    private Date lastVisitTime;
    private Date lastEndTime;
}
