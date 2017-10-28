/**
 * 
 */
package com.ibm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.dao.PersonDao;
import com.ibm.dao.ShoppingDao;
import com.ibm.model.Address;
//import com.ibm.model.Address;
import com.ibm.model.Cart;
import com.ibm.model.FourWheeler;
import com.ibm.model.Item;
import com.ibm.model.LoginCredential;
import com.ibm.model.Person;
import com.ibm.model.TwoWheeler;
import com.ibm.model.User;
import com.ibm.model.Vehichle;
import com.sun.xml.internal.ws.api.addressing.AddressingPropertySet;

/**
 * @author Ritam
 *
 */
@Component
@Transactional(readOnly = true)
public class TestController {

	
	@Autowired
	PersonDao personDao;
	@Autowired
	ShoppingDao shoppingDao;
	
	
	public void display(){
		System.out.println("hello");
	}
	public void printPerson(){
	    personDao.setClazz(Person.class);
	    List<Person> personList = personDao.findAll();
	    for(Person p : personList){
	    	System.out.println(p);
	    }		
	}
	public void printUserInfo(){
		shoppingDao.setClazz(User.class);
		//User user = shoppingDao.getUser(1);
		//Cart cart  = user.getCart();
		//System.out.println(cart.getCartType());
		/*List<User> userList = shoppingDao.findAll();
		if(userList != null){
			for(User user : userList){
               Cart cart = user.getCart();
               System.out.println(cart.getCartType());
               
			}
		}*/
	}
	public void printCartInfo(){
		/*shoppingDao.setClazz(User.class);
		List<User> userList = shoppingDao.findAll();
		for(User user : userList){
			System.out.println("user >>"+user.getId()+"  "+user.getUserName());
			System.out.println("cart >> "+user.getCart().getId()+"  "+user.getCart().getCartType());
			List<Item> itemList = user.getCart().getItemList();
			System.out.println("items");
			for(Item item : itemList){
				System.out.println(item.getId()+" "+item.getPrice()+" "+item.getQuantity());
			}
		}*/
		
		
	}
	public void printItemInfo(){
		shoppingDao.setClazz(Item.class);
		List<Item> itemList = shoppingDao.findAll();
		for(Item item : itemList){
			System.out.println(item.getCart().getCartType());
		}
	}
	public void createPerson(){
		Person p = new Person("ritam", "kolkata", "sarkar","description........@#",new Date());
		LoginCredential loginId = new LoginCredential(2,"rita.style@gmail.com"); 
		
		p.setLoginId(loginId);
		personDao.save(p);		
		
	}	
	public void deletePersonById(int id){
		personDao.setClazz(Person.class);
		personDao.deleteById(id);
	}
	@Transactional(readOnly = false,rollbackFor=Exception.class)
    public void createUser(){
    	Item item1 = new Item(18, 4);
    	Item item2 = new Item(20, 15);
    	Item item3 = new Item(9, 10);
    	List<Item> itemList = new ArrayList<Item>();
    	itemList.add(item1);
    	itemList.add(item2);
    	itemList.add(item3);    	
    	User user = new User();
    	user.setUserName("rimpa");
    	Cart cart = new Cart();
    	cart.setCartType("cosmetics");
    	cart.setItemList(itemList);
    	user.setCart(cart);
    	shoppingDao.setClazz(User.class);
    	shoppingDao.save(user);
    }
    public void createCart(){
    	List<Item> itemList = new ArrayList<Item>();
    	Cart cart = new Cart("vegetable", itemList);
    	Item item1 = new Item(1200, 1,cart);
    	Item item2 = new Item(150,5,cart); 
    	User user = new User("ritam", cart);
    	cart.getItemList().add(item1);
    	cart.getItemList().add(item2);    	
        /*shoppingDao.setClazz(Cart.class);
        shoppingDao.save(cart);*/
        shoppingDao.setClazz(Item.class);
        shoppingDao.save(item1);
        shoppingDao.save(item2);
        shoppingDao.setClazz(User.class);    	
    	shoppingDao.save(user);
    	shoppingDao.commit();    	 
    }
    
    @Transactional(readOnly = false,rollbackFor=Exception.class)
    public void createAddress(){
    	Address add1 = new Address("kundanahalli", 37);
    	Address add2 = new Address("munnekollal", 26);
    	Address add3 = new Address("thubarahalli", 58);
    	User user1 = new User();
    	User user2 = new User();
    	user1.setUserName("gudduadd");
    	user2.setUserName("tukkuadd");
    	List<Address> addressList = new ArrayList<Address>();
    	List<Address> addressList2 = new ArrayList<Address>();
    	addressList.add(add1);
    	addressList.add(add2);
    	addressList2.add(add1);
    	addressList2.add(add3);
    	user1.setAddressList(addressList);
    	user2.setAddressList(addressList);
    	
    	shoppingDao.setClazz(User.class);
    	shoppingDao.save(user1);
    	String s = null;
    	s.toString();
    	shoppingDao.save(user2); 
    	//shoppingDao.commit();   	
    	
    }
    public void printaddress(){
    	shoppingDao.setClazz(User.class);
    	List<User> userList = shoppingDao.findAll();
    	for(User user : userList){
    		System.out.println(user.getUserName()+" ");
    	}
    }
    public void createVehichles(){
    	Vehichle vehichle = new Vehichle("vehichle");
    	TwoWheeler twoWheeler = new TwoWheeler("bugati", "clutch");
    	FourWheeler fourWheeler = new FourWheeler("porche", "steering");
    	shoppingDao.setClazz(Vehichle.class);
    	shoppingDao.save(vehichle);
    	shoppingDao.setClazz(TwoWheeler.class);
    	shoppingDao.save(twoWheeler);
    	shoppingDao.setClazz(FourWheeler.class);
    	shoppingDao.save(fourWheeler);
    	shoppingDao.commit();
    	
    }
}
