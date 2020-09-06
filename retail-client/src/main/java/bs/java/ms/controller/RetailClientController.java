package bs.java.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class RetailClientController {

	
	@Autowired 
	RestTemplate restTemplate;
	
	@Value("${message}")  
	String message;
	
	//@Value("${message.shared.config}")
	String commongMsg;


	
	//@Autowired 
	//DiscoveryClient client;
	//@Autowired
	//EurekaClient eurekaClient;
	
	@GetMapping("/hello")
	@HystrixCommand(fallbackMethod="getHelloFallback")
	public String getHello() {
		
		//Using exlicpit Ribbon based load balancer and without using Eureka
		//return restTemplate.getForObject("http://product-catalog-ribbon/", String.class);
		
		//Access the service using Service Discovery
		String response = restTemplate.getForObject("http://product-catalog-service/hello", String.class);
		return "Response =" +  response + " message=" + message + " commongMsg=" + commongMsg;
	
	}
	
	public String getHelloFallback() {
		return "Service is not available";
		
	}
	
}
