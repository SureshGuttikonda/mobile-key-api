package org.mk.generator.config;

import org.mk.generator.constants.MobileKeyConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
 
	@Value("${spring.cors.origin.host}")
	private String corsOriginHost; 
	
	@Value("${spring.cors.origin.port}")
	private String corsOriginPort;
	
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	String finalURI = corsOriginHost + corsOriginPort;
		registry.addMapping(MobileKeyConstants.CORS_GLOBAL_ENDPOINT)
				.allowedOrigins(finalURI);
    }
}
