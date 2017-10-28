/**
 * 
 */
package com.ibm.dao;

import java.io.Serializable;

import com.ibm.model.Person;

/**
 * @author Ritam
 *
 */
public interface PersonDao extends BaseDAO{

	 Person getCacheData();
}
