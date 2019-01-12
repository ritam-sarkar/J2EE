/**
 * 
 */
package boot.spring.JpaSpringBoot.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.spring.JpaSpringBoot.model.Person;

/**
 * @author ritsarka
 *
 */
@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepo;
	
	public Person findById(Long id) {
		return personRepo.findById(id).get();
	}
	public void findAll(){
		Iterable<Person> persons = personRepo.findAll();
		System.out.println(persons);
	}

}
