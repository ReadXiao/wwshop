package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author 肖宏武
 * @date 2020/3/21 - 18:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Addcar {
    private int id;
    private String spuId;
    private int skuId;
    private int userId;
    private String goodsName;
    private BigDecimal skuPrice;
    private BigDecimal discountPrice;
    private String goodsAttrs;
    private String skuPic;
    private int goodsAmount;
    private int catalogId;

}
