package com.springboot.fundamentos.Bean;

import lombok.AllArgsConstructor;

import javax.management.ConstructorParameters;

@AllArgsConstructor
public class MyBeanWithPropertiesImplement implements MyBeanWithProperties {

    private String name;
    private String apellido;

    @Override
    public String function(){
        return name+"-"+apellido;
    }

}
