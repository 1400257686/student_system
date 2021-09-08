package com.zxl.service;

import com.zxl.entity.File;
import com.zxl.entity.Teacher;
import com.zxl.vo.DataVo;

import java.util.List;

public interface TeacherService {
    public List<Teacher> findAll(Integer start, Integer limit);
    public Integer count();
    public List<Teacher> findByAcademy(String academy, Integer start, Integer limit);
    public Integer countByAcademy(String academy);
    public void deletebytno(String tno);
    public void updatebytno(Teacher teacher);
    public Teacher getAcademy(Teacher teacher);
    public void insert(Teacher teacher);
    public Teacher findbytno(String tno);
    public String insert(Integer fno,String fname);
    public DataVo<File> findbyfno(Integer fno, Integer start, Integer limit);
}
