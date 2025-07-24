package com.example.SpringMVC;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index.jsp";
    }

    /* this is Servlet way of handling forms, but we need Spring boot Way
    @RequestMapping("add")
    public String add(HttpServletRequest req, HttpSession session){
        int num1= Integer.parseInt(req.getParameter("num1"));
        int num2= Integer.parseInt(req.getParameter("num2"));
        int result=num1+num2;
        session.setAttribute("result",result); //sends result to result.jsp
        return "result.jsp";
    }
     */

    /*@RequestMapping("add")
    public String add(@RequestParam("num1")int number1,@RequestParam("num2") int number2, HttpSession session){
        //int num1= Integer.parseInt(req.getParameter("num1"));
        //int num2= Integer.parseInt(req.getParameter("num2"));
        int result=number1+number2;
        session.setAttribute("result",result); //sends result to result.jsp
        return "result.jsp";
    }
     */
    @RequestMapping("add")
    //public String add(@RequestParam("num1")int number1, @RequestParam("num2") int number2, Model model){
    public ModelAndView add(@RequestParam("num1")int number1, @RequestParam("num2") int number2, ModelAndView mv){
        //int num1= Integer.parseInt(req.getParameter("num1"));
        //int num2= Integer.parseInt(req.getParameter("num2"));
        int result=number1+number2;
        //session.setAttribute("result",result); //sends result to result.jsp
        mv.addObject("result",result);//using spring model to send data jsp
        mv.setViewName("result.jsp");
        return mv;
    }
}
