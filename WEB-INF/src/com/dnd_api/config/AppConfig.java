package com.dnd_api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration 
@ComponentScan("com.dnd_api") 
@EnableWebMvc   
public class AppConfig {  
	// for application specific configuration
} 
