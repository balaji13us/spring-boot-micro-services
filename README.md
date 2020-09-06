Spring Microsservices 
MYSQL 

spring.datasource.driverClassName=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost/infytel
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect

Config Server
default port 8888
spring.cloud.config.failFast=true
spring.profiles.active=native
spring.cloud.config.server.native.search-locations=classpath:properties/{application}


Config Server:

Annotations:
@EnableConfigServer

Config Client:
@RefreshScope


Load Balancing - Ribbon:

<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
</dependency>

Create a @LoadBalanced RestTemplate Bean

Service Discovery - Eureka:
@EnableDiscoveryServer --> @EnableEurekaServer
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>
eureka.client.service-url.defaultZone=http://localhost:5555/eureka

Eureka Client: 		
@EnableDiscoveryClient --> @EnableEurekaClient
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
http://{eureka-host}:{eureka-port}/{eureka}/apps/{spring-application-name}


Circuit Breaker - Hysterix

<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>

@HystrixCommand(fallbackMethod="getCustomerProfileFallback")
