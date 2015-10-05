package controller;

import java.util.List;
import java.util.Map;

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
    	System.out.println("tumor:"+service.getCntByDiseaseDesp("tumor"));
    	System.out.println("leukemia:"+service.getCntByDiseaseType("leukemia"));
    	System.out.println("ALL:"+service.getCntByDiseaseName("ALL"));
    	List<Map<String,Object>> drugTypeList = service.getDrugTypeByDisDesp("tumor");
    	for(Map<String, Object> map: drugTypeList){
    		System.out.println("drug type:"+map.get("TYPE"));
    	}
    	return model;
    }
}