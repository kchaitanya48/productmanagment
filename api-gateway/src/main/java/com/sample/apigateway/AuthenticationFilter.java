package com.sample.apigateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sample.apigateway.jwt.JwtUtil;

import jakarta.ws.rs.core.HttpHeaders;
@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config>{
	
	@Autowired
	private RouteValidator routeValidator;
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	public AuthenticationFilter() {
		super(Config.class);
		// TODO Auto-generated constructor stub
	}

	

	static class Config{
		
	}

	@Override
	public GatewayFilter apply(Config config) {
		// TODO Auto-generated method stub
		return ((exchange,chain)->{
			if(routeValidator.isSecured.test(exchange.getRequest())) {
				//verify header has token?
				if(!exchange.getRequest()
						.getHeaders()
						.containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("missing authorization header");
				}
				
				String authHeader=exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				if(authHeader!=null && authHeader.startsWith("Bearer ")) {
				authHeader=authHeader.substring(7);
				} 
				try {
					//template.getForObject("http://identity-service//validate?token="+authHeader, String.class);
					
					jwtUtil.validateToken(authHeader);
				}catch(Exception e) {
					System.out.println("invalid access...");
					throw new RuntimeException("unauthorized access to the application");
				}
			}
			return chain.filter(exchange);
		});
		
	}

}
