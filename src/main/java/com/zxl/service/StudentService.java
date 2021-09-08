package com.zxl.service;

import com.zxl.entity.File;
import com.zxl.entity.Student;
import com.zxl.vo.DataVo;

import javax.xml.crypto.Data;
import java.util.List;

public interface StudentService {
    public List<Student> findAll(Integer start,Integer limit);
    public Integer count();
    public List<Student> findByAcademy(String academy,Integer start,Integer limit);
    public Integer countByAcademy(String academy);
    public void deletebysno(String sno);
    public void updatebysno(Student student);
    public Student getAcademy(Student student);
    public void insert(Student student);
    public Student findbysno(String sno);
    public void select(String sno,Integer cno);
    public DataVo<File> findbyfno(Integer fno, Integer start, Integer limit);
}
