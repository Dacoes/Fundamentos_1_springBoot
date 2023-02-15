package com.springboot.fundamentos.Configuration;


import com.springboot.fundamentos.Bean.MyBeanWithDependenci;
import com.springboot.fundamentos.Bean.MyBeanWithProperties;
import com.springboot.fundamentos.Bean.MyBeanWithPropertiesImplement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;
    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplement(name,apellido);
    }

}