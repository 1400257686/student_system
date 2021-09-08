package com.zxl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {
    private Integer cNo;
    private String cName;
    private Integer cCredit;
    private String cTime;
    private Teacher cTeacher;
}
