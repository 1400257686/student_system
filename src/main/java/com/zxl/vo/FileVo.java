package com.zxl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class FileVo {
    private Integer code;
    private String msg;
    private Map<String,String> data;
}
