/**
 * 
 */
package com.ibm.model;

import java.io.Serializable;

/**
 * @author Ritam
 *
 */
public class ShoppingView implements Serializable{
	
	private int userId;
	private String userName;
	private int cartId;
	private String cartType;
	public ShoppingView(int userId, String userName, int cartId, String cartType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.cartId = cartId;
		this.cartType = cartType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getCartType() {
		return cartType;
	}
	public void setCartType(String cartType) {
		this.cartType = cartType;
	}
	
	
	

}
