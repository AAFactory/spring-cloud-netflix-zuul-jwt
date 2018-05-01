package io.github.aafactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import io.github.aafactory.zuul.SimpleFilter;

@SpringBootApplication
@EnableZuulProxy
public class Application {

    @Bean
    public SimpleFilter simpleFilter() {
        return new SimpleFilter();
    }
    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
