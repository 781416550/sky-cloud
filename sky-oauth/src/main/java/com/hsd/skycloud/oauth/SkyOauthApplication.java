package com.hsd.skycloud.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@EnableOAuth2Sso
@EnableFeignClients
@ComponentScan({"com.hsd.skycloud.oauth", "com.hsd.skycloud.common"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EntityScan("com.hsd.skycloud.api.*")
public class SkyOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkyOauthApplication.class, args);
	}
}
