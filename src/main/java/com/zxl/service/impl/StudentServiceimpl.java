package com.zxl.service.impl;

import com.zxl.entity.File;
import com.zxl.entity.Student;
import com.zxl.repository.*;
import com.zxl.service.StudentService;
import com.zxl.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SelectRepository selectRepository;
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private FileRepository fileRepository;

    @Override
    public List<Student> findAll(Integer start, Integer limit) {
        return studentRepository.findAll(start,limit);
    }
    @Override
    public Integer count(){
        return studentRepository.count();
    }

    @Override
    public List<Student> findByAcademy(String academy, Integer start, Integer limit) {
        return studentRepository.findByAcademy(academy, start, limit);
    }

    @Override
    public Integer countByAcademy(String academy) {
        return studentRepository.countByAcademy(academy);
    }

    @Override
    public void deletebysno(String sno) {
        studentRepository.deletebysno(sno);
    }

    @Override
    public void updatebysno(Student student) {
        studentRepository.updatebysno(student);
    }

    @Override
    public Student getAcademy(Student student) {
        String number=student.getAcademy();
        if(number.equals("0")){
            student.setAcademy("文法学院");
        }else if(number.equals("1")){
            student.setAcademy("理学院");
        }else if(number.equals("2")){
            student.setAcademy("信息学院");
        }else if(number.equals("3")){
            student.setAcademy("建筑学院");
        }
        return student;
    }

    @Override
    public void insert(Student student) {
        studentRepository.insert(student);
    }

    @Override
    public Student findbysno(String sno) {
        return studentRepository.findbysno(sno);
    }

    @Override
    public void select(String sno, Integer cno) {
        selectRepository.select(sno, cno);
        scoreRepository.insertnoscore(sno,cno);
    }

    @Override
    public DataVo<File> findbyfno(Integer fno, Integer start, Integer limit) {
        List<File> list=fileRepository.findbyfno(fno, start, limit);
        return new DataVo<File>(0,"",fileRepository.countbyfno(fno),list);
    }
}
