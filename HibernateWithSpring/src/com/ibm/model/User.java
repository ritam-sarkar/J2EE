/**
 * 
 */
package com.ibm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * @author Ritam
 *
 */
@Entity
@Table(name = "cart_user")
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String userName;	
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Cart cart;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_address", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "address_id") })
	@NotFound(action=NotFoundAction.IGNORE) 
	private List<Address> addressList = new ArrayList<Address>();
	
	@Transient
	private int cartId;
	@Transient
	private String cartType;
	

	
	public User(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
		
	}

	public int getCartId() {
		return cartId;
	}

	public String getCartType() {
		return cartType;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public User() {
		super();
	}

	public User(String userName, Cart cart) {
		super();
		this.userName = userName;
		this.cart = cart;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString(){
		String s = " user id >>"+this.id+" user name >>"+this.userName+" \n cart id >>"+this.getCart().getId()+" cart type "+this.getCart().getCartType();
		return s;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public void setCartType(String cartType) {
		this.cartType = cartType;
	}
	

	
}
