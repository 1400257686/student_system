package com.zxl.service;

import com.zxl.entity.Course;
import com.zxl.entity.Teacher;
import com.zxl.vo.CourseVo;
import com.zxl.vo.DataVo;

import java.util.List;

public interface CourseService {
    public List<Course> findAll(Integer start, Integer limit);
    public Integer count();
    public List<Course> findByAcademy(String academy,Integer start,Integer limit);
    public Integer countByAcademy(String academy);
    public DataVo<CourseVo> toDataVo(List<Course> list,Integer count);
    public void deletebycno(String cno);
    public void updatebycno(Course course);
    public void insert(Course course);
    public DataVo<CourseVo> findbyselect(String sno,Integer start,Integer limit);
    public DataVo<CourseVo> findnotselect(String sno,Integer start,Integer limit);
    public boolean time(String sno,String cno);
    public DataVo<CourseVo> findbytno(String tno,Integer start,Integer limit);
}
