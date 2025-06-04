package br.com.erudio.java_springboot_erudio.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// para carregar a classe quando estiver inicicializando o contexto pq tem config importante p aplicação
// que precisam estar disponíveis quando a aplicação inicializar
public class OpenApiConfig {

    @Bean
// bean é um objeto instanciado, gerenciado pelo spring IOC - container que busca informações em arquivos XML, Notations ou no código Java
// sobre como os beans devem ser instanciados, configurados e montados
// e como se relacionam com outro beans
    // se criar uma classe que depende de algum bean, vc só precisa se preocupar com o bean que sua classe depende, não com o que suas
    // dependencias dependem
    OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("REST API's RESTful from 0 with Java, Spring Boot, Kubernetes and Docker")
                        .version("v1")
                        .description("REST API's RESTful from 0 with Java, Spring Boot, Kubernetes and Docker")
                        .termsOfService("https://pub.erudio.com.br/meus-cursos")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://pub.erudio.com.br/meus-cursos")
                        )
                );
    }
}
