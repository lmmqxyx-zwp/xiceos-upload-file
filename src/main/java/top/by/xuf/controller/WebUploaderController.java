package top.by.xuf.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * <p>Title: WebUploaderController</p>
 * <p>Description: 上传文件组件WebUploader的使用</p>
 *
 * @author zwp
 * @date 2019/4/24 13:54
 */
@Controller
@RequestMapping(value = "/webUploader")
public class WebUploaderController {

    private Logger log = LoggerFactory.getLogger(WebUploaderController.class);

    /**
     * 文件上传主页
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "web-uploader/index";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file")MultipartFile files,HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject json=new JSONObject();
        response.setCharacterEncoding("utf-8");
        String msg = "添加成功";
        log.info("-------------------开始调用上传文件upload接口-------------------");
        try{
            String name = files.getOriginalFilename();
            String path = "E:/tmp/tmp";
            path = path + File.separator + name;
            File uploadFile = new File(path);
            files.transferTo(uploadFile);
        }catch(Exception e){
            msg="添加失败";
        }
        log.info("-------------------结束调用上传文件upload接口-------------------");
        json.put("msg", msg);

        return JSON.toJSONString(json);
    }

    @RequestMapping(value = "/uploadservlet", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
    protected String uploadServlet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JSONObject json=new JSONObject();
        response.setCharacterEncoding("utf-8");
        String msg = "添加成功";
        log.info("-------------------开始调用上传文件uploadservlet接口-------------------");
        try {
            if (request instanceof MultipartHttpServletRequest) {
                MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
                List<MultipartFile> multipartFile = mr.getFiles("file");
                if (null != multipartFile && !multipartFile.isEmpty()) {
                    MultipartFile file = multipartFile.get(0);
                    String name = file.getOriginalFilename();
                    String path = this.getClass().getClassLoader().getResource("/").getPath();
                    int index = path.indexOf("Shopping");
                    path = path.substring(0, index + "Shopping".length()) + "/WebContent/resources/upload/";
                    path = path + File.separator + name;
                    File uploadFile = new File(path);
                    if(FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(uploadFile))>0)
                    {
                        json.put("path",path);
                    }

                }
            }
        } catch (Exception e) {
            msg = "上传失败";
        }
        log.info("-------------------结束调用上传文件uploadservlet接口-------------------");
        json.put("msg", msg);
        return JSON.toJSONString(json);
    }
}
