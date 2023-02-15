package com.springboot.fundamentos.Configuration;

import com.springboot.fundamentos.Bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean myBean(){
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation myOperation(){
        return new MyOperationImpl();
    }

    @Bean
    public MyBeanWithDependenci myOperationImpl(MyOperation myOperation){
        return new MyBeanWithDependenciIMPL(myOperation);
    }
}
