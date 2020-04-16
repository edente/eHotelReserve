package edu.miu.cs544.eHotelReserve.amqpconfigJava;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfiguration {

	    @Bean
	    public ConnectionFactory connectionFactory() {
	    	CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
	    	connectionFactory.setUsername("joe");
	    	connectionFactory.setPassword("joe");
	        return connectionFactory;
	    }
	    
	    @Bean
		DirectExchange exchange() {
			return new DirectExchange("bookingDirectExchange");
		}
	    
	    @Bean
		Queue queueSanFrancisco() {
			return new Queue("bookingQueueSanFrancisco", true);
		}
	    
	    @Bean
		Queue queueSanJose() {
	    	Queue queue = new Queue("bookingQueueSanJose", true);
			return queue;
		}
	    
	    @Bean
		Queue queueLasVegas() {
			return new Queue("bookingQueueLasVegas", true);
		}

	    @Bean
	    public AmqpAdmin amqpAdmin() {
	        return new RabbitAdmin(connectionFactory());
	    }

 
	    @Bean
		Binding bindingSanFrancisco(@Qualifier("queueSanFrancisco") Queue queue, DirectExchange exchange) {
			return BindingBuilder.bind(queue).to(exchange).with("booking.SanFrancisco");
		}
	    
	    @Bean
		Binding bindingSanJose(@Qualifier("queueSanJose") Queue queue, DirectExchange exchange) {
			return BindingBuilder.bind(queue).to(exchange).with("booking.SanJose");
		}
	    
	    @Bean
		Binding bindingLasVegas(@Qualifier("queueLasVegas") Queue queue, DirectExchange exchange) {
			return BindingBuilder.bind(queue).to(exchange).with("booking.LasVegas");
		}

	    @Bean
	    public RabbitTemplate bookingTemplateSanFrancisco() {
	        RabbitTemplate bookingTemplate= new RabbitTemplate(connectionFactory());
	        bookingTemplate.setDefaultReceiveQueue("bookingQueueSanFrancisco");
	        bookingTemplate.setRoutingKey("booking.SanFrancisco");
	        bookingTemplate.setExchange("bookingDirectExchange");
	        bookingTemplate.setReplyTimeout(2000);
	        return bookingTemplate;
	    }
	   
	   	@Bean
	    public RabbitTemplate bookingTemplateSanJose() {
	        RabbitTemplate bookingTemplate= new RabbitTemplate(connectionFactory());
	        bookingTemplate.setDefaultReceiveQueue("bookingQueueSanJose");
	        bookingTemplate.setRoutingKey("booking.SanJose");
	        bookingTemplate.setExchange("bookingDirectExchange");
	        bookingTemplate.setReplyTimeout(2000);
	        return bookingTemplate;
	    }
	   	
	   	@Bean
	    public RabbitTemplate bookingTemplateLasVegas() {
	        RabbitTemplate bookingTemplate= new RabbitTemplate(connectionFactory());
	        bookingTemplate.setDefaultReceiveQueue("bookingQueueLasVegas");
	        bookingTemplate.setRoutingKey("booking.LasVegas");
	        bookingTemplate.setExchange("bookingDirectExchange");
	        bookingTemplate.setReplyTimeout(2000);
	        return bookingTemplate;
	    }
				   
}
