package com.zxl.service.impl;

import com.zxl.entity.File;
import com.zxl.entity.Teacher;
import com.zxl.repository.FileRepository;
import com.zxl.repository.TeacherRepository;
import com.zxl.service.TeacherService;
import com.zxl.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceimpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private FileRepository fileRepository;

    @Override
    public List<Teacher> findAll(Integer start, Integer limit) {
        return teacherRepository.findAll(start, limit);
    }

    @Override
    public Integer count() {
        return teacherRepository.count();
    }

    @Override
    public List<Teacher> findByAcademy(String academy, Integer start, Integer limit) {
        return teacherRepository.findByAcademy(academy, start, limit);
    }

    @Override
    public Integer countByAcademy(String academy) {
        return teacherRepository.countByAcademy(academy);
    }

    @Override
    public void deletebytno(String tno) {
        teacherRepository.deletebytno(tno);
    }

    @Override
    public void updatebytno(Teacher teacher) {
        teacherRepository.updatebytno(teacher);
    }

    @Override
    public Teacher getAcademy(Teacher teacher) {
        String number=teacher.getAcademy();
        if(number.equals("0")){
            teacher.setAcademy("文法学院");
        }else if(number.equals("1")){
            teacher.setAcademy("理学院");
        }else if(number.equals("2")){
            teacher.setAcademy("信息学院");
        }else if(number.equals("3")){
            teacher.setAcademy("建筑学院");
        }
        return teacher;
    }

    @Override
    public void insert(Teacher teacher) {
        teacherRepository.insert(teacher);
    }

    @Override
    public Teacher findbytno(String tno) {
        return teacherRepository.findbytno(tno);
    }

    @Override
    public String insert(Integer fno, String fname) {
        String newfname="";
        String oldfname=fname;
        int t=2;
        while (true){
            newfname=fileRepository.findbyname(fname);
            if(newfname==null){
                break;
            }
            else if(newfname.equals(fname)) {
                fname = oldfname + "(" + t + ")";
            }
            t++;
        }
        fileRepository.insert(fno,fname);
        return fname;
    }

    @Override
    public DataVo<File> findbyfno(Integer fno, Integer start, Integer limit) {
        List<File> list=fileRepository.findbyfno(fno, start, limit);
        return new DataVo<File>(0,"",fileRepository.countbyfno(fno),list);
    }
}
