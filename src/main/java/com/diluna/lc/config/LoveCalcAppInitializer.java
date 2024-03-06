package com.diluna.lc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Approach 2->More control take by Spring
public class LoveCalcAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Register Spring Config file
		Class arr[] = { LoveCalcAppConfig.class };
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		// configure mapping for Dispatcher Servelet
		String arr[] = { "/" };
		return arr;

	}

}
