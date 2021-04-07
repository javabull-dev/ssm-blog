package com.javabull.ssm.blog.controller.admin;

import com.javabull.ssm.blog.entity.Msg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Calendar;

@Slf4j
@RequestMapping("/admin/upload")
@RestController
public class UploadController {

    public final String allowSuffix = ".bmp.jpg.jpeg.png.gif.pdf.doc.zip.rar.gz";

    @RequestMapping(value = "/img", method = RequestMethod.POST)
    public Msg uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest httpServletRequest) {

        final String rootPath = httpServletRequest.getServletContext().getInitParameter("rootPath");

        if (!new File(rootPath).exists()) {
            return Msg.fail("配置的上传文件存储路径无效,请修改后重试!");
        }
        String originalFilename = file.getOriginalFilename();
        String name = originalFilename.substring(0, originalFilename.indexOf("."));
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        if (!allowSuffix.contains(suffix)) {
            return Msg.fail("不允许上传该后缀的文件!");
        }

        Calendar date = Calendar.getInstance();
        File dateDirs = new File(date.get(Calendar.YEAR)
                + File.separator + (date.get(Calendar.MONTH) + 1));

        File descFile = new File(rootPath + File.separator +
                dateDirs + File.separator + originalFilename);
        int i = 1;
        //若文件存在重命名
        String newFilename = originalFilename;
        while (descFile.exists()) {
            newFilename = name + "(" + i + ")" + suffix;
            String parentPath = descFile.getParent();
            descFile = new File(parentPath + File.separator + newFilename);
            i++;
        }
        //判断目标文件所在的目录是否存在
        if (!descFile.getParentFile().exists()) {
            boolean mkdirs = descFile.getParentFile().mkdirs();
            if (!mkdirs) {
                return Msg.fail("无法创建文件夹,请检查是否拥有权限!");
            }
        }

        try {
            file.transferTo(descFile);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("上传失败-->" + e.getCause());
        }

        String fileUrl = "/uploads/" + dateDirs + "/" + newFilename;

        return Msg.success()
                .add("filename", originalFilename)
                .add("fileUrl", fileUrl);
    }
}
