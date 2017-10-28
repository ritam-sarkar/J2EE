/**
 * 
 */
package com.ibm.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.model.LoginCredential;
import com.ibm.model.Person;

/**
 * @author Ritam
 *
 */
@Repository
public class PersonDaoImpl extends AbstractHibernateDao implements PersonDao{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Person getCacheData() {
		Session session1 = sessionFactory.openSession();
		LoginCredential loginId = new LoginCredential(1, "rit.style@gmail.com");
		Person p1 = (Person) session1.get(Person.class,loginId);
		session1.close();		
		Session session2 = sessionFactory.openSession();
		Person p2 = (Person) session2.get(Person.class,loginId);		
        return p2;
}

	
	
}
