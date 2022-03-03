package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 肖宏武
 * @date 2020/3/21 - 17:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GmsDetailPics {
    private int id;
    private String spuId;
    private String picUrl;
}
