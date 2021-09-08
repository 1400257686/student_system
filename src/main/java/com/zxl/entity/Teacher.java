package com.zxl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Serializable {
    private String tNo;
    private String tName;
    private String tSex;
    private String academy;

    public Teacher(String tNo){
        this.tNo=tNo;
    }
}
