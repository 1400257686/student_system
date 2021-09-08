package com.zxl.repository;

import com.zxl.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {
    public List<Student> findAll(Integer start,Integer limit);
    public Integer count();
    public List<Student> findByAcademy(String academy,Integer start,Integer limit);
    public Integer countByAcademy(String academy);
    public void deletebysno(String sno);
    public void updatebysno(Student student);
    public void insert(Student student);
    public Student findbysno(String sno);
    public String selectsname(String sno);
}
