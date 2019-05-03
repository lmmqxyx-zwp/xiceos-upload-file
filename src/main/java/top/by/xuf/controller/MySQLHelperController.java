package top.by.xuf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/db")
public class MySQLHelperController {

    @GetMapping(value = "/index")
    public String index() {
        return "db/index";
    }

    public Object searchValue() {
        return "";
    }

}
