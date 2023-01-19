package com.ibrahim.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
//	@Bean
//	public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder)
//	{
//		return routeLocatorBuilder.routes()
//				.route(r-> r.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))//lb= Load Balancer
//				.route(r-> r.path("/products/**").uri("lb://INVENTORY-SERVICE"))
//				.build();
//	}
	@Bean
	public DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient discoveryClient, DiscoveryLocatorProperties properties)
	{
		return new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties);
	}
}
