package top.by.xuf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import top.by.xuf.service.FileUploadService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 文件上传
 *
 * @author zwp
 */
@Controller
@RequestMapping(value = "/")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /**
     * 单文件上传
     *
     * @param file 文件
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Object upload(@RequestParam("fileName") MultipartFile file) {

        if (file.isEmpty()) {
            return "文件异常";
        }

        String fileName = file.getOriginalFilename();

        int size = (int) file.getSize();

        System.out.println("=======> " + size);

        String path = "E:/tmp/tmp/";

        File dir = new File(path + fileName);

        if (!dir.getParentFile().exists()) {
            dir.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dir);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return index();
    }

    @RequestMapping(value = "/uploads", method = RequestMethod.POST)
    public Object uploads(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("fileName");

        if (files.isEmpty()) {
            return "文件异常";
        }

        String path = "E:/tmp/";

        for (MultipartFile file : files
             ) {
            String fileName = file.getOriginalFilename();
            int size = (int) file.getSize();
            System.out.println("-------> " + size);

            if (file.isEmpty()) {
                return "文件异常";
            } else {
                File dir = new File(path + fileName);
                if (!dir.getParentFile().exists()) {
                    dir.getParentFile().mkdirs();
                }

                try {
                    file.transferTo(dir);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

}
