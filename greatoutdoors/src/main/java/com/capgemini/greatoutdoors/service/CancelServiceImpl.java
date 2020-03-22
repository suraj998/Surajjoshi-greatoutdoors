package com.capgemini.greatoutdoors.service;
import java.util.HashMap;
import com.capgemini.greatoutdoors.dao.CancelDaoImpl;
import com.capgemini.greatoutdoors.dto.ProductDTO;
import com.capgemini.greatoutdoors.exception.CancelException;

import com.capgemini.greatoutdoors.util.ProductRepository;

public class CancelServiceImpl implements CancelService  {
	 CancelDaoImpl CancelDaoImplObj=new CancelDaoImpl();
	public boolean addToOrder(String productid) throws CancelException {
		// TODO Auto-generated method stub
		boolean result=false;
		if(ProductRepository.productList.get(productid) != null)
		{   if(CancelDaoImpl.orderlist.containsKey(productid))
	          	{	
			        throw new CancelException("Order already contain this PRODUCT\n");
	        	}
		   else {
			 result=CancelDaoImplObj.addToOrder(productid);
		    return result;
		      }
			
		}
		else
		{
			throw new CancelException("Product ID not Found in Product List to Add in ORDERLIST\n");
		}
	}

	public boolean removeProductFromOrder(String productid) throws CancelException {
		// TODO Auto-generated method stub
		boolean result=false;
		if(CancelDaoImpl.orderlist.get(productid) != null)
		{
		
			result=CancelDaoImplObj.removeProductFromOrder(productid);
			return result;
		}
		else
		{   
			throw new CancelException("Product ID not found in ORDER to REMOVE\n");
		}
	
	
	}

	public boolean removeOrder() throws CancelException {
		// TODO Auto-generated method stub
		boolean result=false;
		if(CancelDaoImpl.orderlist.isEmpty()==false)
		{
			result=CancelDaoImplObj.removeOrder();
			return result;
		}
		else
		{
			throw new CancelException("Order is not there");
		}
	}

	public  HashMap<String, ProductDTO> displayOrder() {
		// TODO Auto-generated method stub
		HashMap<String, ProductDTO> list1=CancelDaoImplObj.displayOrder();
		return list1;
	}

	
	

}
