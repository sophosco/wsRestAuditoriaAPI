package com.sophos.poc.wsrestauditoriaapi.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class AddResponseHeaderFilter implements Filter {
	 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, 
      FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");	
        chain.doFilter(request, response);
    }
}
