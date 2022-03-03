package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 肖宏武
 * @date 2020/4/18 - 18:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleSum {
    private String catalogValue;
    private float totalSale;
    private String color;
}
