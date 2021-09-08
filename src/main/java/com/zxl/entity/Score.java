package com.zxl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score implements Serializable {
    private String sNo;
    private Integer cNo;
    private Integer score;
}
