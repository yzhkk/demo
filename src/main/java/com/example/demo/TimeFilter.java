package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yinzhihong
 * @description: 利用Filter过滤器 获取当前请求耗时
 * @date 2021/7/13 5:19 下午
 */
@Component
@Service
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("Filter初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        double start = System.nanoTime();

        //过滤处理
        chain.doFilter(request, response);
        out.print("request time consuming : " + (System.nanoTime() - start )/ 1000000.0 + " ms");

    }

    @Override
    public void destroy() {
        System.out.println("Filter销毁");
    }
}
