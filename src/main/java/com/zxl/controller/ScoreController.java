package com.zxl.controller;

import com.zxl.service.ScoreService;
import com.zxl.vo.DataVo;
import com.zxl.vo.ScoreVO;
import com.zxl.vo.T_scorevo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    /**
     * 按学号查找成绩
     * @param sno
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/findbysno")
    public DataVo<ScoreVO> findBysno(String sno,Integer page,Integer limit){
        return scoreService.findbysno(sno, (page-1)*limit, limit);
    }

    /**
     * 按课号查找成绩
     * @param cno
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/findbycno")
    public DataVo<T_scorevo> findBycno(Integer cno, Integer page, Integer limit){
        return scoreService.findbycno(cno, (page-1)*limit, limit);
    }

    /**
     * 更新课程
     * @param sno
     * @param cno
     * @param score
     * @return
     */
    @RequestMapping("/update")
    public String update(String sno,Integer cno,Integer score){
        scoreService.update(sno, cno, score);
        return "redirect:/tot_score?cno="+cno;
    }
}
