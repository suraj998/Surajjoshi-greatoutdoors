package com.capgemini.greatoutdoors.dao;
import java.util.HashMap;
import com.capgemini.greatoutdoors.dto.ProductDTO;
import com.capgemini.greatoutdoors.util.ProductRepository;

public class CancelDaoImpl implements CancelDao{
	public static  HashMap<String, ProductDTO> orderlist=new HashMap<String , ProductDTO>();
	public boolean addToOrder(String pid) {
		
		 orderlist.put(pid,ProductRepository.productList.get(pid));       //adding item to order with product id
			return true;
		
	}

	public boolean removeProductFromOrder(String pid) {
		
		orderlist.remove(pid);											//removing any particular product from order
		return true;
	}

	public boolean removeOrder() {
		
		orderlist.clear();												//clearing the entire order 
		return true;
	}

	
	public HashMap<String, ProductDTO> displayOrder() {
		
		return orderlist;												//Display products in the order
	}

	

	
	
	

}
