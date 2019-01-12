package boot.spring.JpaSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import boot.spring.JpaSpringBoot.dao.PersonService;
import boot.spring.JpaSpringBoot.model.Person;

@SpringBootApplication
public class JpaSpringBootApplication implements CommandLineRunner{

	@Autowired
	private PersonService personService;
	public static void main(String[] args) {
		SpringApplication.run(JpaSpringBootApplication.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception{
		Person person = personService.findById(1L);
		System.out.println(person.getName());
	}

}

