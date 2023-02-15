package com.springboot.fundamentos;

import com.springboot.fundamentos.Bean.MyBean;
import com.springboot.fundamentos.Bean.MyBeanWithDependenci;
import com.springboot.fundamentos.Bean.MyBeanWithProperties;
import com.springboot.fundamentos.Component.ComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {


	private ComponentDependency componentDependency;
	@Autowired
	private MyBean myBean;
	@Autowired
	private MyBeanWithDependenci myBeanWithDependenci;

	@Autowired
	private MyBeanWithProperties myBeanWithProperties;


	public FundamentosApplication( @Qualifier("component2Implement") ComponentDependency componentDependency){
		this.componentDependency = componentDependency;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependenci.printWithDependenci();
		System.out.println(myBeanWithProperties.function());
	}
}
