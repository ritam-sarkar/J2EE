/**
 * 
 */
package boot.spring.JpaSpringBoot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.spring.JpaSpringBoot.model.Person;

/**
 * @author ritsarka
 *
 */
public interface PersonRepository extends CrudRepository<Person, Long>{

}
