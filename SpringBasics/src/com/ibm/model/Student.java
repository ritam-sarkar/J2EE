/**
 * 
 */
package com.ibm.model;

import java.util.List;

/**
 * @author Ritam
 *
 */
public class Student {

	private Integer id;
	private String name;
	private String email;
	private List<Address> address;
	private Address singleAddress;
	
	public Student(){
		
	}
	public Student(int id,String name,String email){
		this.id = id;
		this.name = name;
		this.email = email;
	}
	@Override
	public String toString(){
		return "id "+this.id+" name "+this.name+" email"+this.email+" address "+this.address.get(1).getLocation();
		
	}	
	
	public Student(Integer id, List<Address> address) {
		super();
		this.id = id;
		this.address = address;
	}
	
	public Student(Integer id, Address singleAddress) {
		super();
		this.id = id;
		this.singleAddress = singleAddress;
	}
	public List<Address> getAddress() {
		return address;
	}
	
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	/**
	 * @return the singleAddress
	 */
	public Address getSingleAddress() {
		return singleAddress;
	}
	/**
	 * @param singleAddress the singleAddress to set
	 */
	public void setSingleAddress(Address singleAddress) {
		this.singleAddress = singleAddress;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
