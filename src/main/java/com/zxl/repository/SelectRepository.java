package com.zxl.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectRepository {
    public List<Integer> findbyselect(String sno,Integer start,Integer limit);
    public Integer countbyselect(String sno);
    public List<String> findtimebysno(String sno);
    public void select(String sno,Integer cno);
}
