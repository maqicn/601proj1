package controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import service.OlapService;
import util.SpringUtil;

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
    	OlapService service = (OlapService) SpringUtil.getBean("olapService");
    	System.out.println("test:"+service.getCntByDiseaseDesp("tumor"));
    	return model;
    }
}