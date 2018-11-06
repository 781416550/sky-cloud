package com.hsd.skycloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableZuulProxy
@SpringCloudApplication
@EnableFeignClients
@ComponentScan(value = {"com.hsd.skycloud.gateway", "com.hsd.skycloud.common"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class SkyGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkyGatewayApplication.class, args);
	}
}
