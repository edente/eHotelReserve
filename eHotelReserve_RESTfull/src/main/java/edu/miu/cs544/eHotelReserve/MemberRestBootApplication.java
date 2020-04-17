package edu.miu.cs544.eHotelReserve;

import java.util.Arrays;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@SpringBootApplication
public class MemberRestBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberRestBootApplication.class, args);
	} 

	 @Bean
	  public DozerBeanMapper dozerBean() {

	    DozerBeanMapper dozerBean = new DozerBeanMapper();

	    return dozerBean;
	  }

	
	@Bean
	public Hibernate5Module hibernate5Module()
	{
	    return new Hibernate5Module();
	}

	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource
	      = new ReloadableResourceBundleMessageSource();
	     
	    messageSource.setBasename("classpath:errorMessages");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}
	@Bean
	public MessageSourceAccessor getMessageSourceAccessor() {
	  return new MessageSourceAccessor(messageSource());
	}
	
//	@Bean
//	public LocalValidatorFactoryBean getValidator() {
//	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//	    bean.setValidationMessageSource(messageSource());
//	    return bean;
//	}
}
