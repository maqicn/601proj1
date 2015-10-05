package controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    String home() {
        return "Hello World!";
    }
    
    @RequestMapping("/aaa")
    public ModelAndView aaa() {
    	ModelAndView model = new ModelAndView();
    	model.setViewName("aaa");
    	return model;
    }
}