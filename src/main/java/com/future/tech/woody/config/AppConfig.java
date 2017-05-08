package com.future.tech.woody.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = { "classpath:config/spring/applicationContext.xml" })
public class AppConfig {

}
