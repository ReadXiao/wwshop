package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 肖宏武
 * @date 2020/3/21 - 18:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MmsCoupons {
    private int id;
    private String name;
    private BigDecimal minPrice;
    private BigDecimal discountPrice;
    private Date deadline;
    private int count;
    private int catalogId;
    private String value;
}
