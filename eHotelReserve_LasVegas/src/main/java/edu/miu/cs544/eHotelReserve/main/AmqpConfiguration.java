package edu.miu.cs544.eHotelReserve.main;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.spring4.SpringTemplateEngine;

import edu.miu.cs544.eHotelReserve.amqp.DirectBranchListener;
import edu.miu.cs544.eHotelReserve.emailservice.EmailService;


@Configuration
@ComponentScan("edu.miu.cs544.eHotelReserve.main")
public class AmqpConfiguration {

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		return connectionFactory;
	}

	@Bean
	public SimpleMessageListenerContainer directListenerContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setQueueNames("bookingQueueLasVegas");//
		container.setMessageListener(new MessageListenerAdapter(queueListener(), "listen"));
		return container;
	}

	@Bean
	DirectBranchListener queueListener() {
		return new DirectBranchListener();
	}

	@Bean
	JavaMailSender javaMailSender() {
		return new JavaMailSenderImpl();
	}

	@Bean
	SpringTemplateEngine springTemplateEngine() {
		return new SpringTemplateEngine();
	}
	
	
	    
	    
}
