package com.zxl.repository;

import com.zxl.entity.Course;
import com.zxl.entity.Score;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository {
    public List<Score> findbysno(String sno,Integer start,Integer limit);
    public Integer countbysno(String sno);
    public void insertnoscore(String sno,Integer cno);
    public void update(String sno,Integer cno,Integer score);
    public List<Score> findbycno(Integer cno,Integer start,Integer limit);
    public Integer countbycno(Integer cno);
}
