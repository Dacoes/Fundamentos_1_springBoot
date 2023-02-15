package com.springboot.fundamentos;

import com.springboot.fundamentos.Bean.MyBean;
import com.springboot.fundamentos.Bean.MyBeanWithDependenci;
import com.springboot.fundamentos.Bean.MyBeanWithProperties;
import com.springboot.fundamentos.Component.ComponentDependency;
import com.springboot.fundamentos.Pojo.UserPojo;
import com.springboot.fundamentos.Repository.UserRepository;
import com.springboot.fundamentos.Service.UserService;
import com.springboot.fundamentos.entity.User;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependency componentDependency;
	@Autowired
	private MyBean myBean;
	@Autowired
	private MyBeanWithDependenci myBeanWithDependenci;

	@Autowired
	private MyBeanWithProperties myBeanWithProperties;
	@Autowired
	private UserPojo userPojo;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;


	public FundamentosApplication( @Qualifier("component2Implement") ComponentDependency componentDependency){
		this.componentDependency = componentDependency;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//this.after();
		saveUsers();
		GetInformationUser();

	}

	private void GetInformationUser(){
		LOGGER.info("Usuario encontrado"+userRepository.findByUserEMail("david@gmail.com").
				orElseThrow(()-> new RuntimeException("No se encontro el usuario")));
		userRepository.findAndSort("user", Sort.by("id").descending()).stream().
				forEach(user -> LOGGER.info("usuario con metodo sort"+user));

		userRepository.findByName("david").stream().forEach(user -> LOGGER.info("Usuario con query method"+user));

		LOGGER.info("Usuario encontrado"+userRepository.findByEmailAndName("david@gmail.com","camilo").
				orElseThrow( ()-> new RuntimeException("Usuario no encontrado") ));

		userRepository.findBynameLike("%user%").stream().forEach(
				user -> LOGGER.info("Usuarion findBynameLike "+user)
		);

		userRepository.findByNameOrEmail("","collazos@gmail.com").stream().forEach(
				user -> LOGGER.info("Usuarion findByNameOrEmail "+user)
		);

		userRepository.findByBirthDateBetween(LocalDate.of(2023,1,2), LocalDate.of(2022,9,2)).stream()
				.forEach(user -> LOGGER.info("Fecha entre: "+ user.getBirthDate()));

		userRepository.findByNameLikeOrderByIdDesc("%user%").stream().forEach(
				user -> LOGGER.info("Usuriario encontrado y ordenado "+user)
		);

		saveWithError();


	}

	private void saveWithError(){
		User test1 = new User("test1","dsakjdhiashd@", LocalDate.of(2023,02,14));
		User test2 = new User("test2","dsakjdhiashd@", LocalDate.of(2023,02,14));
		User test3 = new User("test3","dsakjdhiashd@", LocalDate.of(2023,02,14));
		User test4 = new User("test4","dsakjdhiashd@", LocalDate.of(2023,02,14));

		List<User> users = Arrays.asList(test1,test2,test3,test4);
		userService.saveTransactional(users);

		userService.getAll().stream().forEach(
				user -> LOGGER.info("Este es el usuario dentro de transactional "+user)
		);

	}
	private void saveUsers(){
		User user1 = new User("david","dsakjdhiashd@", LocalDate.of(2023,02,14));
		User user2 = new User("camilo","david@gmail.com", LocalDate.of(2023,02,21));
		User user3 = new User("lucia","dsakjdhiashd@", LocalDate.of(2023,02,10));
		User user4 = new User("user1","collazos@gmail.com", LocalDate.of(2023,02,14));
		User user5 = new User("user2","dsakjdh@gmail.com", LocalDate.of(2023,02,14));
		User user6 = new User("user3","dsakjdhiashd@", LocalDate.of(2023,02,14));
		User user7 = new User("user4","dsakjdhiashd@", LocalDate.of(2023,03,14));
		User user8 = new User("user5","escobar@gmail.com", LocalDate.of(2023,02,14));
		User user9 = new User("user6","dsakjdhiashd@", LocalDate.of(2023,12,14));
		List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9);

		userRepository.saveAll(list);


	}

	private void after(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependenci.printWithDependenci();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail());
		try {
			int value = 10/0;
			LOGGER.info("mi valor :" + value);
		}catch (Exception e){
			LOGGER.error("Esto es un error al dividir sobre cero "+ e.getMessage());
		}
	}
}
