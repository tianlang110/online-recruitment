package com.longlong.controller;

import com.longlong.entity.Candidate;
import com.longlong.entity.Seeker;
import com.longlong.entity.User;
import com.longlong.service.SeekerService;
import com.longlong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/file")
public class FileController {
    @Autowired
    UserService userService;
    @Autowired
    SeekerService seekerService;
    @Value("${filepath}")
    private String filepath;
    @PostMapping(value = "/upload")
    public Object uploading(@RequestParam("file") MultipartFile file, Principal principal) {
        String username = principal.getName();
        User user = userService.queryUserByUsername(username);
        System.out.println(user.getUsername());
        Seeker seeker = seekerService.querySeekerByUserid(user.getUserid());
        File targetFile = new File(filepath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try (FileOutputStream out = new FileOutputStream(filepath + file.getOriginalFilename());){
            out.write(file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
        seeker.setResume(file.getOriginalFilename());
        System.out.println(file.getOriginalFilename());
        seekerService.updateSeeker(seeker);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("data",file.getOriginalFilename());
        return map;
    }

    @RequestMapping("/download/{seekerid}")
    public void downLoad(HttpServletResponse response, @PathVariable("seekerid") int seekerid) throws UnsupportedEncodingException {
        Seeker seeker = seekerService.querySeekerByUserid(seekerid);
        String filename=seeker.getResume();
        String filePath = filepath ;
        File file = new File(filePath + "/" + filename);
        if(file.exists()){
            response.setContentType("application/octet-stream");
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filename,"utf8"));
            byte[] buffer = new byte[1024];
            //输出流
            OutputStream os = null;
            try(FileInputStream fis= new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);) {
                os = response.getOutputStream();
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
