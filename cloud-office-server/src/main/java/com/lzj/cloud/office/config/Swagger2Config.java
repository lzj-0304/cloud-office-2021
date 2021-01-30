package com.lzj.cloud.office.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger2配置类
 *
 * @author zhoubin
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket createRestApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("云e办-v_2021")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.lzj.cloud.office.controller"))
				.paths(PathSelectors.any())
				.build()
				.securitySchemes(securitySchemes());
	}

	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("云E办接口文档")
				.description("云E办接口文档")
				.contact(new Contact("乐字节","http:localhost:8081/doc.html","xxxx@xxxx.com"))
				.version("1.0")
				.build();
	}

	private List<ApiKey> securitySchemes(){
		//设置请求头信息
		List<ApiKey> result= new ArrayList<>();
		ApiKey apiKey = new ApiKey("Authorization","Authorization","Header");
		result.add(apiKey);
		return result;
	}

}