package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.spring.controller")
public class WebAppConfig extends WebMvcConfigurerAdapter{

    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
      configurer.favorPathExtension(true).
              ignoreAcceptHeader(true).
              useJaf(false).
              defaultContentType(MediaType.TEXT_HTML).
              mediaType("xml", MediaType.APPLICATION_XML).
              mediaType("json", MediaType.APPLICATION_JSON).
              mediaType("html", MediaType.TEXT_HTML);
    }
 
    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
 
}
