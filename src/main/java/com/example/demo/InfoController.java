package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


/**
 * @author yinzhihong
 * @date 2021/7/12 2:04 下午
 */

@Controller
public class InfoController {

    @RequestMapping("/info")
    public String info(HttpServletRequest request,Model model) {

        Map<String,String> map = new HashMap<>();

        //获取post方式参数
        map.put("post method",request.getMethod());

        //获取请求参数
        Enumeration parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String key = (String) parameterNames.nextElement();
            String value = request.getParameter(key);
            map.put(key,value);
        }

        //获取header
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key,value);
        }

        model.addAttribute("map",map);
        return "info";
    }

}
