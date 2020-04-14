package edu.miu.cs544.eHotelReserve;

import java.util.Arrays;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

}
