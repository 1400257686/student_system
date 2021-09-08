package com.zxl.repository;

import com.zxl.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseRepository {
    public List<Course> findAll(Integer start, Integer limit);
    public Integer count();
    public List<Course> findByAcademy(String academy,Integer start,Integer limit);
    public Integer countByAcademy(String academy);
    public void deletebycno(String cno);
    public void updatebycno(Course course);
    public void insert(Course course);
    public String findnamebycno(Integer cno);
    public Course findbycno(Integer cno);
    public List<Course> findnotselcet(String sno,Integer start,Integer limit);
    public Integer countnotselcet(String sno);
    public String findtimebycno(String cno);
    public List<Course> findbytno(String tno,Integer start,Integer limit);
    public Integer countbytno(String tno);

}
