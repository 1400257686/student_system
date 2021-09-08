package com.zxl.repository;
import com.zxl.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeacherRepository {
    public List<Teacher> findAll(Integer start,Integer limit);
    public Integer count();
    public List<Teacher> findByAcademy(String academy, Integer start, Integer limit);
    public Integer countByAcademy(String academy);
    public void deletebytno(String tno);
    public void updatebytno(Teacher teacher);
    public void insert(Teacher teacher);
    public Teacher findbytno(String tno);
}
