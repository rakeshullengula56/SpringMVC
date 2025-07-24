package com.example.SpringMVC;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class HomeController {

    @ModelAttribute("course")
    public String courseName(){
        return "java";
    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }
    @RequestMapping("alien")
    public String addAlien(){
        return "Alien";
    }

    /*@RequestMapping("addAlien")
    public ModelAndView getAlien(@RequestParam("id") int id,@RequestParam("name") String name, ModelAndView mv){
        Alien alien=new Alien();
        alien.setId(id);
        alien.setName(name);
        mv.addObject("alien",alien);
        mv.setViewName("alienView");
        return mv;
    }
     */
    @RequestMapping("addAlien")//@ModelAttribute is optional if name in jsp,
    // and parameter name in method is same
    public String getAlien(/*@ModelAttribute("alien")*/ Alien alien){
        return "alienView";
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
    /*
    @RequestMapping("add")
    //public String add(@RequestParam("num1")int number1, @RequestParam("num2") int number2, Model model){
    public ModelAndView add(@RequestParam("num1")int number1, @RequestParam("num2") int number2, ModelAndView mv){
        //int num1= Integer.parseInt(req.getParameter("num1"));
        //int num2= Integer.parseInt(req.getParameter("num2"));
        int result=number1+number2;
        //session.setAttribute("result",result); //sends result to result.jsp
        mv.addObject("result",result);//using spring model to send data jsp
        mv.setViewName("result");
        return mv;
    }
     */

    @RequestMapping("calculate")
    public ModelAndView calculate(@RequestParam("expression") String expression, ModelAndView mv) {
        double result = 0;
        String error = null;
        try {
            result = evaluate(expression);
        } catch (Exception e) {
            error = "Invalid expression!";
        }
        if (error != null) {
            mv.addObject("error", error);
        } else {
            mv.addObject("result", result);
        }
        mv.addObject("expression", expression);
        mv.setViewName("result");
        return mv;
    }
    private double evaluate(String expression) {
        List<String> postfix = infixToPostfix(expression);
        return evalPostfix(postfix);
    }

    private List<String> infixToPostfix(String expression) {
        List<String> output = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder num = new StringBuilder();

        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isWhitespace(c)) continue;

            if (Character.isDigit(c) || c == '.') {
                num.append(c);
            } else {
                if (!num.isEmpty()) {
                    output.add(num.toString());
                    num.setLength(0);
                }

                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        output.add(stack.pop().toString());
                    }
                    if (!stack.isEmpty()) stack.pop(); // remove '('
                } else if (precedence.containsKey(c)) {
                    while (!stack.isEmpty() && stack.peek() != '(' &&
                            precedence.get(stack.peek()) >= precedence.get(c)) {
                        output.add(stack.pop().toString());
                    }
                    stack.push(c);
                }
            }
        }

        if (!num.isEmpty()) output.add(num.toString());
        while (!stack.isEmpty()) output.add(stack.pop().toString());
        return output;
    }

    private double evalPostfix(List<String> postfix) {
        Stack<Double> stack = new Stack<>();
        for (String token : postfix) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (token.charAt(0)) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/':
                        if (b == 0)
                            throw new ArithmeticException("Division by zero");
                        stack.push(a / b);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
