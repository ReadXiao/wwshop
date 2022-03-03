package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 肖宏武
 * @date 2020/3/21 - 18:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OmsOrderInfo {
    private String id;
    private int userId;
    private int addressId;
    private int goodsAmount;
    private Date createTime;
    private Date payTime;
    private int state;//0为未付款，1为已付款，2为已发货，3已收货
    private float totalPrice;
    private String expressWay;//快递方式
    private String expressNum;//快递单号
    private List<OmsOrderDetail> omsOrderDetails;
    private String username;
}
