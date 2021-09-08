package com.zxl.service;

import com.zxl.vo.ScoreVO;
import com.zxl.vo.DataVo;
import com.zxl.vo.T_scorevo;

public interface ScoreService {
    public DataVo<ScoreVO> findbysno(String sno,Integer start,Integer limit);
    public DataVo<T_scorevo> findbycno(Integer cno, Integer start, Integer limit);
    public void update(String sno,Integer cno,Integer score);
}
