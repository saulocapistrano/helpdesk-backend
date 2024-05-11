package helpdesk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.select()
				.apis(RequestHandlerSelectors.basePackage("helpdesk.domain.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(info()).host("http://helpdesk.org/api");
				
	}
	
	private ApiInfo info() {
		return new ApiInfoBuilder()
				.title("HelpDesk")
				.description("API de controle de chamados.")
				.version("1.0")
				.contact(contact())
				.build();
	}
	
	private Contact contact() {
		return new Contact("Saulo Capistrano", "github.com.br/saulocapistrano", "saulocapistrano@gmail.com");
	}
	
}
