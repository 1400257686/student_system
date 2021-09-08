package com.zxl.repository;

import com.zxl.entity.File;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository {
    public void insert(Integer fno,String fname);
    public List<File> findbyfno(Integer fno,Integer start,Integer limit);
    public Integer countbyfno(Integer fno);
    public String findbyname(String fname);
}
