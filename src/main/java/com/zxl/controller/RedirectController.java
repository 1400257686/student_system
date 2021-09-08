package com.zxl.controller;
import com.zxl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RedirectController {
    @Autowired
    private UserService userService;

    /**
     * 页面跳转
     * @param url
     * @return
     */

    @RequestMapping("/redirect")
    public String redirect(String url){
        return url;
    }

    /**
     * 登录
     * @param id
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public String login(String id, String password, HttpServletRequest req){
        HttpSession session=req.getSession();
        String type=userService.findtype(id,password);
        if(type!=null){
            session.setAttribute("id",id);
            return type;
        }else {
            return "null";
        }
    }

    /**
     * 修改密码
     * @param id
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public String updatepassword(String id, String password){
        if(userService.findbyid(id)!=null){
            userService.updatepassword(password,id);
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 成绩单页面跳转并向前端发送sno
     * @param sno
     * @return
     */
    @RequestMapping("/toscorelist")
    public ModelAndView toScoreList(String sno){
        ModelAndView modelAndView=new ModelAndView("score");
        modelAndView.addObject("sno",sno);
        return modelAndView;
    }

    /**
     * 教师打分页面跳转并向前端发送cno
     * @param cno
     * @return
     */
    @RequestMapping("/tot_score")
    public ModelAndView toT_score(Integer cno){
        ModelAndView modelAndView=new ModelAndView("teacher/score");
        modelAndView.addObject("cno",cno);
        return modelAndView;
    }

    @RequestMapping("/onload")
    public ModelAndView onload(Integer fno){
        ModelAndView modelAndView=new ModelAndView("teacher/file");
        modelAndView.addObject("fno",fno);
        return modelAndView;
    }

    @RequestMapping("/download")
    public ModelAndView download(Integer fno){
        ModelAndView modelAndView=new ModelAndView("student/file");
        modelAndView.addObject("fno",fno);
        return modelAndView;
    }
}
