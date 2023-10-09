//package com.example.librarymanagement.config.filter;
//
//import com.example.librarymanagement.dto.auth.UserAuthentication;
//import com.example.librarymanagement.util.AuthUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author mangvientrieu
// */
//@Slf4j
//@Component
//public class RoleFilter implements OncePerRequestFilter {
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
//	                                FilterChain filterChain) throws ServletException, IOException {
//		UserAuthentication userAuthentication = AuthUtil.getUserAuthentication();
//			String requestURI = httpRequest.getRequestURI();
//			if (UrlAccessConfig.checkAccessUrlByRole(userAuthentication.getRole(), requestURI)) {
//				filterChain.doFilter(servletRequest, servletResponse);
//				return;
//			} else {
//				HttpServletResponseWrapper httpServletResponseWrapper = (HttpServletResponseWrapper) servletResponse;
//				httpServletResponseWrapper.getWriter().append("Cút");
//				return;
//				throw new CustomizeException("Cút", "Không có quyền");
//			}
//		}
//		filterChain.doFilter(servletRequest, servletResponse);
//	}
//
//}
