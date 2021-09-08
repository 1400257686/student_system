package com.zxl.service.impl;

import com.zxl.entity.Course;
import com.zxl.repository.CourseRepository;
import com.zxl.repository.SelectRepository;
import com.zxl.service.CourseService;
import com.zxl.vo.CourseVo;
import com.zxl.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseServiceimpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private SelectRepository selectRepository;

    @Override
    public List<Course> findAll(Integer start, Integer limit) {
        return courseRepository.findAll(start,limit);
    }

    @Override
    public Integer count() {
        return courseRepository.count();
    }

    @Override
    public List<Course> findByAcademy(String academy, Integer start, Integer limit) {
        return courseRepository.findByAcademy(academy, start, limit);
    }

    @Override
    public Integer countByAcademy(String academy) {
        return courseRepository.countByAcademy(academy);
    }

    @Override
    public DataVo<CourseVo> toDataVo(List<Course> list,Integer count) {
        List<CourseVo> courseVoList=new ArrayList<>();
        for (Course course:list){
            courseVoList.add(new CourseVo(course.getCNo(),course.getCName(),course.getCCredit(),course.getCTime(),course.getCTeacher().getTName(),course.getCTeacher().getTNo(),course.getCTeacher().getAcademy()));
        }
        return new DataVo<CourseVo>(0,"",count,courseVoList);
    }

    @Override
    public void deletebycno(String cno) {
        courseRepository.deletebycno(cno);
    }

    @Override
    public void updatebycno(Course course) {
        courseRepository.updatebycno(course);
    }

    @Override
    public void insert(Course course) {
        courseRepository.insert(course);
    }

    @Override
    public DataVo<CourseVo> findbyselect(String sno, Integer start, Integer limit) {
        List<Integer> listcno=selectRepository.findbyselect(sno,start,limit);
        List<CourseVo> courseVoList=new ArrayList<>();
        for(Integer cno:listcno){
            Course course=courseRepository.findbycno(cno);
            courseVoList.add(new CourseVo(course.getCNo(),course.getCName(),course.getCCredit(),course.getCTime(),course.getCTeacher().getTName(),course.getCTeacher().getTNo(),course.getCTeacher().getAcademy()));
        }
        return new DataVo<CourseVo>(0,"",selectRepository.countbyselect(sno),courseVoList);
    }

    public DataVo<CourseVo> findnotselect(String sno, Integer start, Integer limit) {
        List<CourseVo> courseVoList=new ArrayList<>();
        List<Course> list=courseRepository.findnotselcet(sno,start,limit);
        for (Course course:list){
            courseVoList.add(new CourseVo(course.getCNo(),course.getCName(),course.getCCredit(),course.getCTime(),course.getCTeacher().getTName(),course.getCTeacher().getTNo(),course.getCTeacher().getAcademy()));
        }
        return new DataVo<CourseVo>(0,"",courseRepository.countnotselcet(sno),courseVoList);
    }

    @Override
    public boolean time(String sno, String cno) {
        List<String> list=selectRepository.findtimebysno(sno);
        return (list.contains(courseRepository.findtimebycno(cno)));
    }

    @Override
    public DataVo<CourseVo> findbytno(String tno, Integer start, Integer limit) {
        List<CourseVo> courseVoList=new ArrayList<>();
        List<Course> list=courseRepository.findbytno(tno,start,limit);
        for (Course course:list){
            courseVoList.add(new CourseVo(course.getCNo(),course.getCName(),course.getCCredit(),course.getCTime(),course.getCTeacher().getTName(),course.getCTeacher().getTNo(),course.getCTeacher().getAcademy()));
        }
        return new DataVo<CourseVo>(0,"",courseRepository.countbytno(tno),courseVoList);
    }

}
