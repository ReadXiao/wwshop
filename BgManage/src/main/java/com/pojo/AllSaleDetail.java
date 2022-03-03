package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author 肖宏武
 * @date 2020/4/18 - 21:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllSaleDetail {
    private String spuId;
    private String goodsName;
    private String goodsPic;
    private String goodsAttrs;
    private int count;
    private float saleSum;
}
