package com.zxl.service.impl;

import com.zxl.entity.Score;
import com.zxl.repository.CourseRepository;
import com.zxl.repository.ScoreRepository;
import com.zxl.repository.StudentRepository;
import com.zxl.service.ScoreService;
import com.zxl.vo.ScoreVO;
import com.zxl.vo.DataVo;
import com.zxl.vo.T_scorevo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceimpl implements ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DataVo<ScoreVO> findbysno(String sno,Integer start,Integer limit) {
        List<Score> list=scoreRepository.findbysno(sno, start, limit);
        List<ScoreVO> scoreVoList=new ArrayList<>();
        for (Score score:list){
            scoreVoList.add(new ScoreVO(courseRepository.findnamebycno(score.getCNo()),score.getScore()));
        }
        return new DataVo<ScoreVO>(0,"",scoreRepository.countbysno(sno),scoreVoList);
    }

    @Override
    public DataVo<T_scorevo> findbycno(Integer cno, Integer start, Integer limit) {
        List<Score> list=scoreRepository.findbycno(cno, start, limit);
        List<T_scorevo> t_scorevoList=new ArrayList<>();
        for (Score score:list){
            t_scorevoList.add(new T_scorevo(score.getCNo(),score.getSNo(),studentRepository.selectsname(score.getSNo()),score.getScore()));
        }
        return new DataVo<T_scorevo>(0,"",scoreRepository.countbycno(cno),t_scorevoList);
    }

    @Override
    public void update(String sno, Integer cno, Integer score) {
        scoreRepository.update(sno, cno, score);
    }
}
