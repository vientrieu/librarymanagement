//package com.example.librarymanagement.config.filter;
//
//import com.example.demospringboot.dto.UserAuthentication;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponseWrapper;
//import java.io.IOException;
//
///**
// * @author mangvientrieu
// */
//@Slf4j
//@Component
//public class RoleFilter implements Filter {
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		Filter.super.init(filterConfig);
//		log.info("Init role filter");
//	}
//
//	@Override
//	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication != null && authentication.isAuthenticated()) {
//			UserAuthentication userAuthentication = (UserAuthentication) authentication.getPrincipal();
//			HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
//			String requestURI = httpRequest.getRequestURI();
//			if (UrlAccessConfig.checkAccessUrlByRole(userAuthentication.getRole(), requestURI)) {
//				filterChain.doFilter(servletRequest, servletResponse);
//				return;
//			} else {
//				HttpServletResponseWrapper httpServletResponseWrapper = (HttpServletResponseWrapper) servletResponse;
//				httpServletResponseWrapper.getWriter().append("Cút");
//				return;
////				throw new CustomizeException("Cút", "Không có quyền");
//			}
//		}
//		filterChain.doFilter(servletRequest, servletResponse);
//	}
//
//	@Override
//	public void destroy() {
//		Filter.super.destroy();
//		log.info("Destroy role filter");
//	}
//}
