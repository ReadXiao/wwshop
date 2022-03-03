package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 肖宏武
 * @date 2020/3/21 - 18:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsAddress {
    private int id;
    private int userId;
    private String addressValue;
    private String telPhone;
    private String consignee;
}
