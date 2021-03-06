package edu.miu.cs544.eHotelReserve.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AmqpDirectBranchConsumerMainJava {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AmqpConfiguration.class);
		applicationContext.getBean(AmqpDirectBranchConsumerMainJava.class).mainInternal(applicationContext);

	}
	
	

	private void mainInternal(ApplicationContext applicationContext) {

		System.out.println("\n-------- LasVegas Branch -> Waiting For Messages From Booking Direct Exchange - Rabbitmq");

	}
}
