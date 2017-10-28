/**
 * 
 */
package com.ibm.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ritam
 *
 */
public interface BaseDAO {
	
 public <T> void setClazz(Class<T> clazz);
 
 public <T> T findById(int id);
	 
 public <T> List<T> findAll();
	 
 public <T> void save(T entity);
     
 public <T> void update(T entity);
     
 public <T> void delete(T entity);
 
 public <T> void deleteById(int entityId);

 public  int getCount();
 
 public void commit();
 
 


}
