/**
 * 
 */
package com.ibm.dao;

import java.util.List;

import com.ibm.model.ShoppingView;
import com.ibm.model.User;

/**
 * @author Ritam
 *
 */
public interface ShoppingDao extends BaseDAO{

	List<User> getAllUserDetails();
	ShoppingView getUserDetails();
	
	
}
