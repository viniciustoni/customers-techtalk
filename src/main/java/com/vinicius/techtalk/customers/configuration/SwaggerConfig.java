package com.vinicius.techtalk.customers.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {
//
//    @Bean
//    public LinkDiscoverers discoverers() {
//        List<JsonPathLinkDiscoverer> plugins = new ArrayList<>();
//        plugins.add(new HalLinkDiscoverer());
//        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
//    }
//
//    @Bean
//    public LinkRelationProvider provider() {
//        return new EvoInflectorLinkRelationProvider();
//    }
//    
//    @Bean
//    @Primary
//    public PluginRegistryFactoryBean<LinkRelationProvider, LinkRelationProvider.LookupContext>
//        myPluginRegistryProvider(){
//        
//        PluginRegistryFactoryBean<LinkRelationProvider, LinkRelationProvider.LookupContext> factory 
//            = new PluginRegistryFactoryBean<>();
//        
//        factory.setType(LinkRelationProvider.class);
//        Class<?> classes[] = new Class<?>[1]; 
//        classes[0] = DelegatingLinkRelationProvider.class;
//        factory.setExclusions(classes);
//        
//        return factory;
//    }
//
//    @Bean
//    public Docket api() {
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("customer-api")
//                .select()
//                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).build()
//                .apiInfo(apiInfo()).tags(new Tag("Customer Techtalk", "Customer Techtalk"))
//                .globalResponseMessage(RequestMethod.GET, responseMessages());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("Customer")
//                .description("Customer - TechTalks")
//                .version("v1")
//                .contact(new Contact("Vinicius Antonio Gai.", "https://github.com/viniciustoni/", "viniciustoni@gmail.com"))
//                .build();
//    }
//
//    private List<ResponseMessage> responseMessages() {
//        final List<ResponseMessage> responseMessages = new ArrayList<>();
//
//        responseMessages.add(new ResponseMessageBuilder().code(200).message("Success").build());
//        responseMessages.add(new ResponseMessageBuilder().code(401).message("Unauthorized").build());
//        responseMessages.add(new ResponseMessageBuilder().code(403).message("Forbidden").build());
//        responseMessages.add(new ResponseMessageBuilder().code(404).message("Not Found").build());
//        responseMessages.add(new ResponseMessageBuilder().code(500).message("Failure").build());
//
//        return responseMessages;
//    }
}
