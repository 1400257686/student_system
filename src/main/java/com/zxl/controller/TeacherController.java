package com.zxl.controller;

import com.zxl.entity.File;
import com.zxl.entity.Student;
import com.zxl.entity.Teacher;
import com.zxl.entity.User;
import com.zxl.service.TeacherService;
import com.zxl.service.UserService;
import com.zxl.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private UserService userService;
    /**
     * 查询学生数据
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/findAll")
    public DataVo<Teacher> findteacher(Integer page, Integer limit){
        List<Teacher> list= teacherService.findAll((page-1)*limit,limit);
        int count=teacherService.count();
        return new DataVo<Teacher>(0,"",count,list);
    }

    /**
     * 按学院查询教师数据
     * @param academy
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/findbyacademy")
    public DataVo<Teacher> findteacherByAcademy(String academy, Integer page, Integer limit){
        List<Teacher> list=teacherService.findByAcademy(academy, (page-1)*limit, limit);
        int count=teacherService.countByAcademy(academy);
        return new DataVo<Teacher>(0,"",count,list);
    }

    /**
     * 按工号删除教师
     * @param tno
     */
    @ResponseBody
    @RequestMapping("/delete")
    public void deleteBytno(String tno){
        teacherService.deletebytno(tno);
        userService.delete(tno);
    }

    /**
     * 按工号更新教师
     * @param teacher
     * @param root
     */
    @RequestMapping("/update")
    public String updateBytno(Teacher teacher,String root){
        if(teacher.getTSex()==null){
            teacher.setTSex("男");
        }
        teacherService.updatebytno(teacherService.getAcademy(teacher));
        return "redirect:/redirect?url="+root+"/teacher";
    }

    /**
     * 添加教师
     * @param teacher
     * @param root
     * @return
     */
    @RequestMapping("/insert")
    public String insert(Teacher teacher,String root){
        if(teacher.getTSex()==null){
            teacher.setTSex("男");
        }
        teacherService.insert(teacherService.getAcademy(teacher));
        userService.insert(new User(teacher.getTNo(),"123456","t"));
        return "redirect:/redirect?url="+root+"/teacher";
    }

    /**
     * 按学号返回学生
     * @param tno
     * @return
     */
    @ResponseBody
    @RequestMapping("/findbytno")
    public boolean findBytno(String tno){
        Teacher teacher=teacherService.findbytno(tno);
        if(teacher==null){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 按号码返回文件
     * @param fno
     * @return
     */
    @ResponseBody
    @RequestMapping("/findbyfno")
    public DataVo<File> findByfno(Integer fno,Integer page,Integer limit){
        return teacherService.findbyfno(fno,(page-1)*limit,limit);
    }
}
