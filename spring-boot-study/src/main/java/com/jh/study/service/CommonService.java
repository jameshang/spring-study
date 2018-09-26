package com.jh.study.service;

import com.jh.study.model.LoginModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/common")
@Slf4j
public class CommonService {

    private void showRequest(HttpServletRequest req) {
        Cookie[] cs = req.getCookies();
        for (Cookie c : cs) {
            log.info(c.toString());
        }
    }

    @GetMapping("index")
    public String index() {
        return "Hello!";
    }

    @PostMapping("login")
    public String login(@RequestBody LoginModel model) {
        log.info(model.toString());
        return "{code:0}";
    }

    @GetMapping("query")
    public String query(HttpServletRequest req) {
        this.showRequest(req);
        return "{code:0}";
    }

    @PostMapping("update")
    public String update(HttpServletRequest req) {
        this.showRequest(req);
        return "{code:0}";
    }

}
