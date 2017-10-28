/**
 * 
 */
package com.ibm.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ibm.model.ShoppingView;
import com.ibm.model.User;

/**
 * @author Ritam
 *
 */
@Repository
public class ShoppingDaoImpl extends AbstractHibernateDao implements ShoppingDao{

	@Override
	public List<User> getAllUserDetails() {
		String hql = "select new User(u.id,u.userName) from User u";
		Query query = getSession().createQuery(hql);
		return query.list();		
	}

	@Override
	public ShoppingView getUserDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
