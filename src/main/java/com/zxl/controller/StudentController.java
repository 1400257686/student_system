package com.zxl.controller;

import com.zxl.entity.File;
import com.zxl.entity.Student;
import com.zxl.entity.User;
import com.zxl.service.StudentService;
import com.zxl.service.UserService;
import com.zxl.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;
    /**
     * 查询学生数据
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/findAll")
    public DataVo<Student> findstudent(Integer page, Integer limit){
        List<Student> list= studentService.findAll((page-1)*limit,limit);
        int count=studentService.count();
        return new DataVo<Student>(0,"",count,list);
    }

    /**
     * 按学院查询学生数据
     * @param academy
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/findbyacademy")
    public DataVo<Student> findstudentByAcademy(String academy,Integer page,Integer limit){
        List<Student> list=studentService.findByAcademy(academy, (page-1)*limit, limit);
        int count=studentService.countByAcademy(academy);
        return new DataVo<Student>(0,"",count,list);
    }

    /**
     * 按学号删除学生
     * @param sno
     */
    @ResponseBody
    @RequestMapping("/delete")
    public void deleteBysno(String sno){
        studentService.deletebysno(sno);
        userService.delete(sno);
    }

    /**
     * 按学号更新学生
     * @param student
     * @param root
     * @return
     */
    @RequestMapping("/update")
    public String updateBysno(Student student,String root){
        if(student.getSSex()==null){
            student.setSSex("男");
        }
        studentService.updatebysno(studentService.getAcademy(student));
        return "redirect:/redirect?url="+root+"/student";
    }

    /**
     * 添加学生
     * @param student
     * @param root
     * @return
     */
    @RequestMapping("/insert")
    public String insert(Student student,String root){
        if(student.getSSex()==null){
            student.setSSex("男");
        }
        studentService.insert(studentService.getAcademy(student));
        userService.insert(new User(student.getSNo(),"123456","s"));
        return "redirect:/redirect?url="+root+"/student";
    }

    /**
     * 按学号查询学生
     * @param sno
     * @return
     */
    @ResponseBody
    @RequestMapping("/findbysno")
    public Boolean findBysno(String sno){
        Student student=studentService.findbysno(sno);
        if(student==null){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 选课
     * @param sno
     * @param cno
     * @return
     */
    @RequestMapping("/select")
    public String select(String sno,Integer cno){
        studentService.select(sno, cno);
        return "redirect:/redirect?url=student/select";
    }

    /**
     * 按号码返回文件
     * @param fno
     * @return
     */
    @ResponseBody
    @RequestMapping("/findbyfno")
    public DataVo<File> findByfno(Integer fno, Integer page, Integer limit){
        return studentService.findbyfno(fno,(page-1)*limit,limit);
    }
}
