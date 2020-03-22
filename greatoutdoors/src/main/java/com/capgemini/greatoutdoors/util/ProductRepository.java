package com.capgemini.greatoutdoors.util;
import java.util.HashMap;

import com.capgemini.greatoutdoors.dto.ProductDTO;

public class ProductRepository {
	
	/////////HashMap to store product items//////////
	
static public  HashMap<String, ProductDTO> productList=new HashMap<String , ProductDTO>(); 
static public void createProductList()
{
	productList.put("P101", new ProductDTO(11,10,"P101","GOLF STICK","Red","dimension1","S1","xyz",9999));
	productList.put("P102", new ProductDTO(22,7,"P102","CAMPING TENT","black","dimension2","S2","xyz",3499));
	productList.put("P103", new ProductDTO(22,20,"P103","TENT HOOKS","white","dimension1","S3","xyz",745));
	productList.put("P104", new ProductDTO(11,51,"P104","GOLF TEE","black","dimension3","S1","xyz",300));
	productList.put("P105", new ProductDTO(11,18,"P105","GOLF BALL","white","dimension1","S2","xyz",500));
	productList.put("P106", new ProductDTO(33,44,"P106","TRIMMER","black","dimension1","S2","xyz",999));
	productList.put("P107", new ProductDTO(33,73,"P107","KNEE CAP","blue","dimension1","S2","xyz",399));
	productList.put("P108", new ProductDTO(33,29,"P108","SUNGLASSES","golden","dimension1","S2","xyz",5999));
	productList.put("P109", new ProductDTO(44,9,"P109","FIRST AID KIT","as per availability","dimension1","S2","xyz",999));
}
public static HashMap<String, ProductDTO> getProductList() {
	return productList;
}
public static void setProductList(HashMap<String, ProductDTO> productList) {
	ProductRepository.productList = productList;
}







	
	
}

