package com.nayak11.springboot.basics.springbootin10steps;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/*
 * How did all the things needed for REST service to be up and running configured automatically?
 * -  @SpringBootApplication indicates that:
 * 1) This is a spring context file
 * 2) It enables auto-configuration
 * 3) It enables component scan
 * */
@SpringBootApplication
public class SpringbootIn10StepsApplication {

	public static void main(String[] args) {
		
		/*
		 * auto-configuration (STILL NOT CLEAR HOW IT WORKS :-( ; CLASS PATH ?) <----------------------------- ? ? ? ? ? ? ? ?
		 * 
		 * One of the Maven dependencies is spring-boot-autoconfigure. There are lot of auto configuration classes inside this jar.
		 * These auto-configuration classes what are creating these beans.
		 * At start-up spring boot would trigger spring-boot-autoconfiguration jar, it would look through classes that are in the class path.
		 * */
		ApplicationContext applicationContext = SpringApplication.run(SpringbootIn10StepsApplication.class, args);
		for(String str : applicationContext.getBeanDefinitionNames()) {
			System.out.println(str);
		}
	}
	
	
	/*
	 * SPRING vs SPRING MVC vs SPRING BOOT
	 * 
	 * SPRING
	 * 1)The core problem that spring solves is testability, if we don't define proper dependencies then our application is not testable
	 * - Most important feature of Spring Framework is Dependency Injection or IOC Inversion Of Control
	 * - When DI or IOC is used properly, we can develop loosely coupled applications. And loosely coupled applications can be easily unit tested.
	 * 2)Duplication/ Plumbing code
	 * - When using JDBC we need to write lot of boiler plate code, try, catch, exception etc. This is not needed when we usethings related to 
	 *   spring framework.
	 * 3)Good integration with other frameworks
	 * - Hibernate for ORM
	 * - iBatis for Object Mapping
	 * - jUnit & Mockito for Unit Testing
	 * 
	 * 
	 * SPRING MVC
	 * - Concerned with developing web apps.
	 * - Separation of concerns. DispatcherSerlet is concerned with basic from controller part, ModelAndView, ViewResolver is concerned with 
	 *   solving view name to the physical view.  
	 * */
	
	
	/*
	 * Various starter projects present in spring boot
	 * spring-boot-starter-web-services - SOAP web services
	 * spring-boot-starter-web - Web & Restful applications
	 * spring-boot-starter-test - Unit testing & Integration testing
	 * spring-boot-starter-jdbc
	 * spring-boot-starter-hateoas
	 * spring-boot-starter-security - authentication & authorization using spring security
	 * spring-boot-starter-data-jpa - spring data JPA with hibernate
	 * spring-boot-starter-cache - enabling spring frameworks caching support
	 * spring-boot-starter-data-rest - Expose simple REST services using spring data REST
	 * 
	 * spring-boot-starter-actuator
	 * spring-boot-starter-logging
	 * spring-boot-starter-log4j2
	 * spring-boot-starter-undertow, spring-boot-starter-jetty, spring-boot-starter-tomcat
	 * */
	
	
	/*
	 * Spring boot actuator
	 * - Brings in lot of monitoring around our application, we can read a lot of meta data about our application
	 * - What are the beans that are configured ? How auto-configuration has worked ?  How many times a specific service is called ?
	 *   How many times a specific service is failed ?
	 * - Spring boot actuator actually exposes lot of REST services, these services are compliant with the standard called hal standard, we will
	 *   use hal browser to explore.
	 * */
	
	
	/* 
	 * Spring devtools is faster because
	 * - Maven dependencies will not changes at all, so it will not load things which are dependent on these things again. It will load
	 * only those beans which are application beans. 10 seconds vs 2 seconds
	 * 
	 * Is this working 
	 * */

}
