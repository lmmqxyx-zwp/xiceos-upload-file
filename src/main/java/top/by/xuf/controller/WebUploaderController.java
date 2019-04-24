package top.by.xuf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    /**
     * 文件上传主页
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "web-uploader/index";
    }

}
