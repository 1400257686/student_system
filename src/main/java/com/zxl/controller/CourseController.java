package com.zxl.controller;

import com.zxl.entity.Course;
import com.zxl.entity.Teacher;
import com.zxl.service.CourseService;
import com.zxl.vo.CourseVo;
import com.zxl.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 查询学生数据
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/findAll")
    public DataVo<CourseVo> findcourse(Integer page, Integer limit){
        List<Course> list= courseService.findAll((page-1)*limit, limit);
        int count=courseService.count();
        return courseService.toDataVo(list,count);
    }

    /**
     * 按学院查询课程数据
     * @param academy
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/findbyacademy")
    public DataVo<CourseVo> findcourseByAcademy(String academy,Integer page, Integer limit){
        List<Course> list= courseService.findByAcademy(academy, (page-1)*limit, limit);
        int count=courseService.countByAcademy(academy);
        return courseService.toDataVo(list,count);
    }

    /**
     * 按课号删除课程
     * @param cno
     */
    @ResponseBody
    @RequestMapping("/delete")
    public void deleteBycno(String cno){
        courseService.deletebycno(cno);
    }

    /**
     * 按课号更新课程
     * @param course
     * @param cTno
     * @param root
     * @return
     */
    @RequestMapping("/update")
    public String updateBytno(Course course, String cTno,String root){
        course.setCTeacher(new Teacher(cTno));
        courseService.updatebycno(course);
        return "redirect:/redirect?url="+root+"/course";
    }

    /**
     * 添加课程
     * @param course
     * @param cTno
     * @param root
     * @return
     */
    @RequestMapping("/insert")
    public String insert(Course course,String cTno,String root){
        course.setCTeacher(new Teacher(cTno));
        courseService.insert(course);
        return "redirect:/redirect?url="+root+"/course";
    }

    /**
     * 选择学生已选课程
     * @param sno
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/findbyselect")
    public DataVo<CourseVo> findByselect(String sno,Integer page,Integer limit){
        return courseService.findbyselect(sno,(page-1)*limit,limit);
    }

    /**
     * 选择学生未选课程
     * @param sno
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/findnotselect")
    public DataVo<CourseVo> findNotselect(String sno,Integer page,Integer limit){
        return courseService.findnotselect(sno,(page-1)*limit,limit);
    }

    /**
     * 查询课程时间冲突
     * @param sno
     * @param cno
     * @return
     */
    @ResponseBody
    @RequestMapping("/time")
    public boolean Time(String sno,String cno){
        return courseService.time(sno, cno);
    }

    @ResponseBody
    @RequestMapping("/findbytno")
    public DataVo<CourseVo> findBytno(String tno,Integer page,Integer limit){
        return courseService.findbytno(tno,(page-1)*limit,limit);
    }
}
