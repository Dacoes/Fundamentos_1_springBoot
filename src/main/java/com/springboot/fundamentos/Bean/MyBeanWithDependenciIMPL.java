package com.springboot.fundamentos.Bean;

import org.springframework.beans.factory.annotation.Autowired;

public class MyBeanWithDependenciIMPL implements  MyBeanWithDependenci{

    @Autowired
    MyOperation myOperation;

    public MyBeanWithDependenciIMPL(MyOperation myOperation) {
    }

    @Override
    public void printWithDependenci() {
        int numero = 1;
        System.out.println(this.myOperation.sum(numero));
        System.out.println("Hola desde mi dependencia bean with dependenci");
    }

}
