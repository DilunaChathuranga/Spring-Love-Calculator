package com.diluna.lc.config;

import java.util.Properties;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.diluna.lc.formatter.PhoneNumberFormatter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.diluna.lc")
//@PropertySources({@PropertySource("classpath:email.properties"),@PropertySource("classpath:messages.properties")})
//but messages can't load this way, we need below 3 methods for that
public class LoveCalcAppConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;
	
	//AddLogger(work as Sysout)
	Logger logger = Logger.getLogger(LoveCalcAppConfig.class.getName());
	
	// For setting up viewResolver
	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		System.out.println("Inside View Resolver");
		return viewResolver;

	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/URLToReachResorceFolder/**").addResourceLocations("/resources/");
		
	}

	// Add Formatter to separate country code and phone number in Mobile number
	// field
	@Override
	public void addFormatters(FormatterRegistry registry) {
		System.out.println("Inside addformatter...");
		registry.addFormatter(new PhoneNumberFormatter());
	}
	
	@Bean
	public JavaMailSender getJavaMAilSender() {
		
		JavaMailSenderImpl javamailSenderImpl=new JavaMailSenderImpl();
		
		logger.info("Check the Logger >>>>>>>>"+env.getProperty("mail.host"));
		System.out.println(env.getProperty("mail.host"));
		/*
		//Like this we can take those details from properties file
		javamailSenderImpl.setHost(env.getProperty("mail.host"));
		javamailSenderImpl.setHost(env.getProperty("mail.username"));
		javamailSenderImpl.setHost(env.getProperty("mail.password"));
		javamailSenderImpl.setHost(env.getProperty("mail.port"));
		*/
		
		
		
		
		javamailSenderImpl.setHost("smtp.gmail.com");
		javamailSenderImpl.setUsername("kmac617udee@gmail.com");
		javamailSenderImpl.setPassword("fudjjkzkownzfjgl"); //put password
		javamailSenderImpl.setPort(587);//567
		
		//javamailSenderImpl.setPort(getIntProperty("mail.port"));
		
		System.out.println("Retun JavaMailSender Object");
		System.out.println("Retun Values"+ javamailSenderImpl.getPassword());
		
		Properties mailProperties = getMailProperty();
		javamailSenderImpl.setJavaMailProperties(mailProperties);
		return javamailSenderImpl;
		
		
	}
	//Helper method for get Properties for mail
	private Properties getMailProperty() {
		Properties mailProperties=new Properties();
		//mailProperties.put("mail.smtp.auth", "true"); 
		mailProperties.put("mail.smtp.starttls.enable", "true");
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		mailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		return mailProperties;
	}
	

	//Helper Method
	private int getIntProperty(String key) {
		String property=env.getProperty(key);
		return Integer.parseInt(property);
	}

	// To load default validation messages from properties file(We use below 3 methods to do that)
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messagesrc = new ResourceBundleMessageSource();
		messagesrc.setBasename("messages");
		return messagesrc;
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean v1 = new LocalValidatorFactoryBean();
		v1.setValidationMessageSource(messageSource());
		return v1;
	}

	@Override
	public Validator getValidator() {
		return validator();
	}
}
