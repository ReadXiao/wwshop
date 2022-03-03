package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 肖宏武
 * @date 2020/3/21 - 18:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsCoupon {
    private int id;
    private int catalogId;
    private String couponsId;//用于判定该优惠卷是否已经领取过
    private int userId;
    private String couponName;
    private BigDecimal minPrice;    //最低限额
    private BigDecimal discountPrice;   //折扣金额
    private Date deadline;
    private int state;  //判断优惠卷是否已失效
    private String value;
}
