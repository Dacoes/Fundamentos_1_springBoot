package com.springboot.fundamentos.Bean;

import com.springboot.fundamentos.FundamentosApplication;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBeanWithDependenciIMPL implements  MyBeanWithDependenci{

    private final Log LOGGER = LogFactory.getLog(MyBeanWithDependenciIMPL.class);
    @Autowired
    MyOperation myOperation;

    public MyBeanWithDependenciIMPL(MyOperation myOperation) {
    }

    @Override
    public void printWithDependenci() {
        LOGGER.info("Hemos ingresado al metodo printwithdependency");
        int numero = 1;
        LOGGER.debug("El numero enviado como parametro "+numero);
        System.out.println(this.myOperation.sum(numero));
        System.out.println("Hola desde mi dependencia bean with dependenci");
    }

}
