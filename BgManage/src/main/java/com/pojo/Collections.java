package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author 肖宏武
 * @date 2020/3/21 - 18:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collections {
    private int id;
    private int spuId;
    private int userId;
    private BigDecimal spuPrice;
    private String pic;
    private String goodsName;
    private String goodsDesc;
}
