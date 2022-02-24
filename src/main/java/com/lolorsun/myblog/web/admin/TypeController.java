package com.lolorsun.myblog.web.admin;

import com.lolorsun.myblog.po.Type;
import com.lolorsun.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @Author lolorsun
 * @Date 2022/2/23 21:08
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;
    @GetMapping("/types")
    public String types(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.ASC) Pageable pageable
    ,Model model){
        model.addAttribute("page",typeService.getTypes(pageable));
        return "admin/types";
    }
    @GetMapping("/types/input")
    public String input(){
        return "admin/types-input";
    }

    @PostMapping("/types")
    public String addType(Type type, RedirectAttributes redirectAttributes) {
        Type t = typeService.saveType(type);
        if (t == null) {
            redirectAttributes.addFlashAttribute("mesage","操作失败");
        } else {
            redirectAttributes.addFlashAttribute("message","操作成功");
        }
        return "redirect:/admin/types";
    }
    //修改类型的映射方法
    @PostMapping("/types/{id}")
    public String modiTypePost(Type type,@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Type t = typeService.saveType(type);
        if (t == null) {
            redirectAttributes.addFlashAttribute("mesage","操作失败");
        } else {
            redirectAttributes.addFlashAttribute("message","操作成功");
        }
        return "redirect:/admin/types";
    }
    @GetMapping("/types/{id}/del")
    public String delType(@PathVariable Long id,RedirectAttributes redirectAttributes){
        typeService.delType(id);
        return "redirect:/admin/types";
    }
    @GetMapping("/types/{id}/modi")
    public String modiType(@PathVariable Long id,Model model){
        model.addAttribute("type",typeService.getOneType(id));
        return "admin/types-input";
    }


}
