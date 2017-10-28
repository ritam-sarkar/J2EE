package com.ibm.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public  class AbstractHibernateDao implements BaseDAO{

	private Class clazz;
	
	private Session session;
	
	private Transaction transaction;
	

	public Session getSession() {
		return session;
	}
    @Autowired
	public void setSession(SessionFactory sessionFactory) {     	
    	this.session = sessionFactory.openSession(); 
    	this.transaction = session.getTransaction();
    	
    	/*if(session.getTransaction() != null && session.getTransaction().isActive()){
    		this.transaction = session.getTransaction();
    	}else{
    		this.transaction = session.beginTransaction();
    	} */   	
	}
    
    public Transaction getTransaction() {
		return transaction;
	}
    @Override
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
    @Override
	public <T> T findById(int id) {	
    	//session.clear();
		return (T) session.load(clazz, id);
		
	}    
    @Override
	public <T> List<T> findAll() {
    	session.clear();
		List<T> list = session.createCriteria(clazz).list();
		return list;
	}
    @Override
	public int getCount(){
		Integer count = (Integer)session.createCriteria(clazz).uniqueResult();
		if(count != null){
			return count.intValue();
		}else{
			return 0;
		}
	}
    @Override
	public <T> void save(T entity) {
		try{
			//transaction.begin();
			session.save(entity);			
			//transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}
				
	}
    @Override
	public <T> void update(T entity) {
		try{
			transaction.begin();
			session.update(entity);
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}
	}
    @Override
	public <T> void delete(T entity) {		
		try{
			transaction.begin();
			session.delete(entity);
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}
		
	}
    @Override
	public <T> void  deleteById(int entityId) {
		try{
			transaction.begin();
			T entity = findById(entityId);
			session.delete(entity);
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}
		
	}
    @Override
	public void finalize(){
		this.session.close();		
	}
	@Override
	public void commit() {
       if(!transaction.wasCommitted()){
    	   transaction.commit();
       }
	}
}
