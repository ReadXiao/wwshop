package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 肖宏武
 * @date 2020/3/20 - 13:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GmsCatalog {
    private int id;
    private String value;
    private String color;
}
