package com.springboot.fundamentos.Component;

import org.springframework.stereotype.Component;

@Component
public class Component2Implement implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Desde componente 2");
    }
}
