package com.jh.study.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexService {

    @GetMapping("index")
    public ModelAndView index(ModelAndView model){
        model.getModel().put("msg", "Srv001 index!");
        return model;
    }

}
