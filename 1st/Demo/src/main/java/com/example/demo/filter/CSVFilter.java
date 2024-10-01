//package com.example.demo.filter;
//
//import java.io.IOException;
//
//import org.springframework.stereotype.Component;
//
//import com.example.demo.exceptionHandler.WrongRequestException;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component
//public class CSVFilter implements Filter{
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
//	{
//		int pn=Integer.parseInt(request.getParameter("pn"));
//		try {
//			
//		if(pn<=0) throw new WrongRequestException("Page must be greater than 0");
//		pn=pn-1;
//		request.setAttribute("pn",pn);
//		chain.doFilter((HttpServletRequest)request,(HttpServletResponse)response);
//		}catch(WrongRequestException ex)
//		{
//			ex.printStackTrace();
//		}
//		
//		
//		
//	}
//
//}
