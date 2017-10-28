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
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * @author Ritam
 *
 */
@Entity
@Table(name = "cart")
public class Cart implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "cart_type")
	private String cartType;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	@NotFound(action=NotFoundAction.IGNORE)
	private User user;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)	
	private List<Item> itemList = new ArrayList<Item>();
	

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getCartType() {
		return cartType;
	}

	public void setCartType(String cartType) {
		this.cartType = cartType;
	}
	

	public Cart() {
		super();
	}

	public Cart(String cartType,List<Item> itemList) {
		super();
		this.cartType = cartType;
		this.itemList = itemList;
	}

	@Override
	public String toString(){
		String s = "Cart id >> "+this.id+" cart type >>"+this.cartType+" \n user id >> "+this.user.getId()+" user name >> "+this.user.getId();
		return s;
	}
	
}
