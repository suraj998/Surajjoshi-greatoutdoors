package com.capgemini.greatoutdoors.ui;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import com.capgemini.greatoutdoors.dto.ProductDTO;
import com.capgemini.greatoutdoors.exception.CancelException;
import com.capgemini.greatoutdoors.service.CancelServiceImpl;
import com.capgemini.greatoutdoors.util.ProductRepository;

public class Cancel {
	
	 static CancelServiceImpl cancelobj=new CancelServiceImpl();
	 static Scanner sc=new Scanner(System.in);
	public static void main(String arg[]) 
	{
	
	     {
		ProductRepository.createProductList();
	     }
	      HashMap<String , ProductDTO> wishlist=ProductRepository.getProductList();
	
		for(Entry<String, ProductDTO> me:wishlist.entrySet())
	   {
		System.out.println("Product ID: "+me.getKey()+" ,Car Name: "+me.getValue().getProductName()+" , Product Category: "+me.getValue().getProductCategory()+" , Colour: "+me.getValue().getColor()+" , Specification: "+me.getValue().getSpecification()+" , Manufacturer: "+me.getValue().getManufacturer()+" , Price: "+me.getValue().getProductPrice());
	    System.out.println();
	   }
	
     chooseManagement();
  
}
	///////////////////management choice //////////////////////
	
	public static void chooseManagement()
	{
		boolean decision = true;
		while(decision)
		{
			System.out.println("Press 1 for Cancel Management System\n");
			int choice=sc.nextInt();
			switch(choice)
			{
			  case 1: cancelManagement();
			          break;
			   default:
				    System.out.println("Please enter correct choice\n");
				
			}
		}
	}
	
	//////////////////////Cancel Management System ////////////////////
	
	public static void cancelManagement()
	{
		try {
			cancelOperation();
		}catch(CancelException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	////////////////// handle Cancel Operations //////////////////////////
	
	private static void cancelOperation() throws CancelException {
		// TODO Auto-generated method stub
		boolean decision=true;
		 while(decision)
		   {

			System.out.println("Press 1 to insert item in order");
			System.out.println("Press 2 to Remove Product from Order");
			System.out.println("Press 3 to Remove Order");
			System.out.println("Press 4 to display Order");
			int choice;
			
			choice=sc.nextInt();
		    
		   
			switch(choice)
			{
			case 1:  createOrder();
			         break;  
			case 2:  removeProductFromOrder();
			         break;
			case 3: removeOrder();
			        break;
			case 4: displayOrder();
			        break;
			default: System.out.println("WRONG CHOICE");
			}
			System.out.println("\nWant to do more Operation on ORDER(true/false)");
			 decision=sc.nextBoolean();
		   }
		
	}
   
 ///////////////////////////// Display the Order List  //////////////////////////
	
	private static void displayOrder() { 
		// TODO Auto-generated method stub
		System.out.println("YOUR ORDERLIST\n");
		HashMap<String, ProductDTO>orderlist=cancelobj.displayOrder();
		
		for(Entry<String, ProductDTO> me:orderlist.entrySet())
		{
			System.out.println("Product ID: "+me.getKey()+" ,Car Name: "+me.getValue().getProductName()+" , Product Category: "+me.getValue().getProductCategory()+" , Colour: "+me.getValue().getColor()+" , Specification: "+me.getValue().getSpecification()+" , Manufacturer: "+me.getValue().getManufacturer()+" , Price: "+me.getValue().getProductPrice());
		    System.out.println();
		}
	}

////////////////////////// Remove the Order ///////////////////////////////
	
	private static void removeOrder() {
		// TODO Auto-generated method stub
		boolean result;
		try {
			result = cancelobj.removeOrder();
			if(result)
			{
				System.out.println("YOUR ORDER HAS BEEN CANCELLED SUCCESSFULLY\n");
			}
		} catch (CancelException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}
  
/////////////////////////// remove particular product from Order list ////////////////////////
	
	private static void removeProductFromOrder() throws CancelException{
		// TODO Auto-generated method stub
		boolean decision=true;
		   while(decision)
		   {  try {
		      System.out.println("Enter Pid to remove Product from Order");
		      Scanner input=new Scanner (System.in);
		      String removePid=input.nextLine();
		   boolean result=   cancelobj.removeProductFromOrder(removePid);
		     if(result)
		     {
		    	 System.out.println("REMOVED SUCCESSFULLY");
		     }
		   }
		   catch(CancelException e)
		   {
			   System.out.println(e.getMessage());
		   }
	       	  System.out.println("\nWant to remove more Product from ORDER(true/false)");
		      decision=sc.nextBoolean();
		 }
		
		
	}

	/////////////////////////create a Order List//////////////////////////
	
	private static void createOrder() throws CancelException{
		// TODO Auto-generated method stub
		

		 System.out.println("CREATE ORDER");
		 boolean decision=true;
		
		 while(decision)
		 {
			
			  try {
				  System.out.println("Enter ProductID to insert in Order List");
				  sc.nextLine();
			  String pid= sc.nextLine();
			  boolean result=cancelobj.addToOrder(pid);
			  if(result)
			  {
				  System.out.println("Added Successfully");
			  }
			  }
			  catch(CancelException e)
			  {
				System.out.print(e.getMessage());
			  } 
			  System.out.println("Want to Enter more Product in ORDER(true/false)");
			 
			  decision=sc.nextBoolean();
			  
		 }
		  
}
	
 }