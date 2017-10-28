/**
 * 
 */
package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.dao.PersonDao;
import com.ibm.dao.ShoppingDao;
import com.ibm.model.Person;
import com.ibm.model.ShoppingView;
import com.ibm.model.User;

/**
 * @author Ritam
 *
 */
@Service("hqlController")
public class HqlController {
	
	@Autowired
	private PersonDao personDao;
	@Autowired
	ShoppingDao shoppingDao;
	
	public void printShpingDetails(){
		List<User> userDetailsList =  shoppingDao.getAllUserDetails();
		System.out.println(userDetailsList.size());
		for(User user : userDetailsList){
			System.out.println(user.getId()+" "+user.getUserName()+" ");
		}
	}
	public void printCacheablePerson(){
		Person p = personDao.getCacheData();
		System.out.println(p);
	}

}
