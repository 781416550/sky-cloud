package com.hsd.skycloud.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringCloudApplication
//可按需引入全局异常拦截、Swagger2、Redis等配置类[当然推荐配置扫描包]
@ComponentScan({"com.hsd.skycloud.base", "com.hsd.skycloud.common"})
//@Import({RestCtrlExceptionHandler.class, Swagger2Config.class})
//启用JPA审计
@EnableJpaAuditing
@EnableCaching
@EntityScan("com.hsd.skycloud.api.*")
public class SkyBaseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkyBaseServiceApplication.class, args);
	}
}
