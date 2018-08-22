package org.nynui.boot.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public Docket  createRestApi(){
		  return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.nynui.boot")).paths(PathSelectors.any()).build();
		
		}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("集成Swagger2 构建 Restful APIs ").description("集成Swagger2 构造 RESTful APIs")
				.termsOfServiceUrl("https://www.baidu.com").contact("zhangsan").version("1.0.0").build();
	}

}
