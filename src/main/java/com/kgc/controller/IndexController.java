package com.kgc.controller;

import com.kgc.pojo.Studentinfo;
import com.kgc.service.IndexService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.rmi.MarshalledObject;
import java.util.List;

/**
 * @author shkstart
 */
@Controller
public class IndexController {
    @Resource
    IndexService indexService;

    @RequestMapping("/")
    public String index(Model model) {
        List<Studentinfo> selall = indexService.selall();
        model.addAttribute("list", selall);
        return "index";
    }

    @RequestMapping("/toupd/{id}")
    public String tpupd(@PathVariable Integer id, Model model, HttpSession session) {
        session.setAttribute("id", id);
        Studentinfo studentinfo = indexService.selById(id);
        model.addAttribute("student", studentinfo);
        return "upd";
    }

    @RequestMapping("/upd")
    public String upd(HttpSession session, Studentinfo studentinfo) {
        Integer id = (Integer) session.getAttribute("id");
        int upd = indexService.upd(studentinfo, id);
        if (upd > 0) {
            session.setAttribute("msg","修改成功");
        } else {
            session.setAttribute("msg","修改失败");
        }
        return "redirect:/";
    }
}
