package com.jh.study.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jh.study.model.CommonParams;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/account")
@Slf4j
public class AccountService {

    @PostMapping("/transfer")
    @ResponseBody
    public String transfer(@RequestBody CommonParams params, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            log.info("{}={}", cookie.getName(), cookie.getValue());
        }
        Cookie cookie = new Cookie("server-token", System.currentTimeMillis() + "");
        response.addCookie(cookie);
        log.info(params.getParams());
        log.info(params.getKey());
        return "{\"msg\":\"OK!\"}";
    }


}
