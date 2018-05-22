package com.example.kinesiscommercesystemsample.inventory.api;

import com.example.kinesiscommercesystemsample.common.web.base.BaseApplicationConfig;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ApplicationConfig extends BaseApplicationConfig {

	@Override
	protected List<String> getCorsAllowedOrigins() {
		return Arrays.asList("*");
	}

	@Override
	protected List<String> getCorsAllowedHeaders() {
		//return Arrays.asList("Origin", "X-Requested-With", "Content-Type", "Accept", "X-XSRF-TOKEN");
		return Arrays.asList("*");
	}

	@Override
	protected List<String> getCorsAllowedMethods() {
		return Arrays.asList("POST", "GET", "PUT", "OPTIONS", "DELETE");
		//return Arrays.asList("*");
	}
}
