//package edu.miu.cs544.eHotelReserve.main;
//
//import java.util.Scanner;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class Main {
//	private final static String[] configFilesGatewayDemo = {
//			"/META-INF/integration/common.xml",
//	 		"/META-INF/integration/reserveGateway.xml",
//			"/META-INF/integration/jms-LasVegas-app-context.xml",
//			"/META-INF/integration/amqp-reserve-app-context.xml",
//			"/META-INF/integration/mailContext.xml"
//			
//		};
//	
//
//	
//	public static void main(String[] args) {
//
//		//final Scanner scanner = new Scanner(System.in);
//
//			System.out.println(".....Loading Gateway......");
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configFilesGatewayDemo, Main.class);
//
//	    applicationContext.getBean(Main.class).mainInternal(applicationContext);
//}
//	private void mainInternal(ApplicationContext applicationContext) {
//		System.out.println("_________Las_Vegas Hotel is going to be reserved__________");
//
//
//	}
//}
