package com.example.thinbanrest;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.example.thinbanrest.domain.Person;
import com.example.thinbanrest.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class ThinbanRestApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ThinbanRestApplication.class, args);
        PersonRepository personRepository = context.getBean(PersonRepository.class);
        personRepository.save(new Person("Hans", "Meiser"));
        personRepository.save(new Person("Peter", "Lustig"));

        try {
            Runtime.getRuntime().exec("cmd /c start http://localhost:8080");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
