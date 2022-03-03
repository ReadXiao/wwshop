package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 肖宏武
 * @date 2020/3/21 - 17:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GmsSku {
    private int id;
    private String spuId;
    private String attrValues;
    private String skuPic;
    private BigDecimal skuPrice;
    private BigDecimal discountPrice;
    private int amount;
    private Date createTime;
    private Date deleteTime;
    private int state;
    private GmsSpu gmsSpu;
}
