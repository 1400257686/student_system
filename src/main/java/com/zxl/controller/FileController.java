package com.zxl.controller;

import com.zxl.service.TeacherService;
import com.zxl.vo.DataVo;
import com.zxl.vo.FileVo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    private TeacherService teacherService;

    /**
     * 上传文件并更新数据库
     * @param fno
     * @param file
     * @return
     */
    @ResponseBody
    @PostMapping("/onload")
    public FileVo onload(Integer fno, MultipartFile file){
        String filename=file.getOriginalFilename();//文件名
        try {
            filename=teacherService.insert(fno,filename);
            File myfile=new File(filename);
            file.transferTo(myfile);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("上传失败");
        }finally {
            Map<String,String> map=new HashMap<String, String>();
            map.put("src",file.getOriginalFilename());
            return new FileVo(0,"",map);
        }
    }

    @RequestMapping("/download")
    public void download(String fname, HttpServletRequest req, HttpServletResponse resp) {
        if(fname != null){
            String fileName="";
            String path="d:/student_system_file";
            try {
                fileName = new String(fname.getBytes("UTF-8"),"iso-8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            File file = new File(path,fname);
            OutputStream outputStream = null;
            if(file.exists()){
                resp.setContentType("application/forc-download");
                resp.setHeader("Content-Disposition","attachment;filename="+fileName);
                try {
                    outputStream = resp.getOutputStream();
                    outputStream.write(FileUtils.readFileToByteArray(file));
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if(outputStream != null){
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
