package com.lolorsun.myblog.web;

import com.lolorsun.myblog.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

//    @GetMapping("/{id}/{name}")
    @GetMapping("/")
    public String index(){
//        public String index(@PathVariable Integer id, @PathVariable String name){
//        int i = 9/0;
//        String blog = null;
//        if(blog==null){
//            throw new NotFoundException("博客不存在");
//        }
        System.out.println("------index-------");
        return "index";
    }
    @GetMapping("/blog")
    public String blog(){


        return "blog";
    }
}
