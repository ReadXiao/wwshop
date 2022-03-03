package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author 肖宏武
 * @date 2020/3/21 - 18:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OmsOrderDetail {
    private int id;
    private String orderId;
    private int catalogId; //可用于后台统计该类别销售量
    private String goodsName;
    private String goodsAttrs;
    private int goodsAmount;
    private float goodsPrice;
    private float totalPrice;
    private String goodsPic;
    private int state;
    private String spuId;
}
