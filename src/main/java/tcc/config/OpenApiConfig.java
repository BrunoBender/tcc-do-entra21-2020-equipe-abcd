package tcc.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
						.components(new Components())
						.info(new Info().title("API da Plataforma Local Search").description(
										"Esta é uma plataforma de pesquisa consultando um cadastro de produtos, serviços e negócios incluídos pelos próprios empreendedores."));
	}
}
