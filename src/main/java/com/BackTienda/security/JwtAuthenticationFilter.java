package com.BackTienda.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private JwtService jwtService;
	@Autowired
	private UserDetailsService userDetails;
	
	
	public JwtAuthenticationFilter(@Autowired JwtService jwtService,@Autowired UserDetailsService userDetails) {
		this.jwtService = jwtService;
		this.userDetails = userDetails;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String header = request.getHeader("Authorization");
		
		if(header==null || !header.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		final String jwt = header.substring(7);
		final String email = jwtService.extractUsername(jwt);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(email!=null && auth==null) {
			UserDetails userDetail = userDetails.loadUserByUsername(email);
			
			if(jwtService.isTokenValid(jwt, userDetail)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
						userDetails,null,userDetail.getAuthorities());
				
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
			
		}
		filterChain.doFilter(request, response);
	}

}
