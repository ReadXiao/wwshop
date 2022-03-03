package com.pojo;

import javafx.scene.chart.PieChart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/3/21 - 17:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsUserInfo {
    private int id;
    private int addressId;
    private String username;
    private String name;
    private String sex;
    private Date birthday;
    private String telPhone;
    private String password;
    private int vip;
    private String pic;
    private Date createTime;
    private Date deleteTime;
    private int state;
    private List<UmsAddress> addresses;
    private List<UmsComment> umsComments;
    private List<UmsCoupon> umsCoupons;
}
