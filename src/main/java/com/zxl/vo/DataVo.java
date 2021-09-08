package com.zxl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 将数据封装json
 * @param <T>
 */

@Data
@AllArgsConstructor
public class DataVo<T> {
    private Integer code;
    private String msg;
    private Integer count;
    private List<T> data;
}
