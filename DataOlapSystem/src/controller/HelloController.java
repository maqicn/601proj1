package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import service.OlapService;
import util.SpringUtil;

@Controller
public class HelloController {
    
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
    
    @RequestMapping("/getAllDiseaseType")
    @ResponseBody
    public String getAllDiseaseType(){
    	OlapService service = (OlapService) SpringUtil.getBean("olapService");
    	return JSON.toJSONString(service.getAllDiseaseType());
    }
    
    @RequestMapping("/getAllDiseaseName")
    @ResponseBody
    public String getAllDiseaseName(){
    	OlapService service = (OlapService) SpringUtil.getBean("olapService");
    	return JSON.toJSONString(service.getAllDiseaseName());
    }
    
    @RequestMapping("/getAllDiseaseDesc")
    @ResponseBody
    public String getAllDiseaseDesc(){
    	OlapService service = (OlapService) SpringUtil.getBean("olapService");
    	return JSON.toJSONString(service.getAllDiseaseDesc());
    }
    
    @RequestMapping("/getCntByDiseaseDesp")
    @ResponseBody
    public String getCntByDiseaseDesp(HttpServletRequest request){
    	String param = request.getParameter("disDesc");
    	OlapService service = (OlapService) SpringUtil.getBean("olapService");
    	return service.getCntByDiseaseDesp(param)+"";
    }
    
    @RequestMapping("/getCntByDiseaseName")
    @ResponseBody
    public String getCntByDiseaseName(HttpServletRequest request){
    	String param = request.getParameter("disName");
    	OlapService service = (OlapService) SpringUtil.getBean("olapService");
    	return service.getCntByDiseaseName(param)+"";
    }
    
    @RequestMapping("/getCntByDiseaseType")
    @ResponseBody
    public String getCntByDiseaseType(HttpServletRequest request){
    	String param = request.getParameter("disType");
    	OlapService service = (OlapService) SpringUtil.getBean("olapService");
    	return service.getCntByDiseaseType(param)+"";
    }
    
}