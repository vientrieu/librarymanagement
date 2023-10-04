package com.example.librarymanagement.config.filter;

import com.example.librarymanagement.dto.api.ResponseDto;
import com.example.librarymanagement.dto.auth.UserAuthentication;
import com.example.librarymanagement.exception.AuthException;
import com.example.librarymanagement.util.AuthUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Slf4j
@Component
public class JWTFilter extends OncePerRequestFilter {

	@Autowired
	private ObjectMapper objectMapper;

	@Value("${app.secret-key}")
	private String secretKey;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
	                                FilterChain filterChain) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			String token = request.getHeader(HttpHeaders.AUTHORIZATION).replace("Bearer ", "");
			UserAuthentication user = objectMapper.convertValue(AuthUtil.getPayloadJwt(token, secretKey),
					UserAuthentication.class);
			Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			filterChain.doFilter(request, response);
		} catch (AuthException e) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write(objectMapper.writeValueAsString(ResponseDto.fail(null, e)));
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().write(objectMapper.writeValueAsString(ResponseDto.fail(null, e)));
		}
	}

}
