/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.adp3.Customer3;

/**
 *
 * @author shina kara 219333181
 */
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

//to be written and displayed on a txt file.
public class SerTpText3 {

    ArrayList<Customer> cusList = new ArrayList<>();
    ArrayList<Stakeholder> supList = new ArrayList<>();
    private ObjectInputStream input;

    //Opens the ser File
    public void openSerFile() {
        try {
            input = new ObjectInputStream(new FileInputStream("stakeholder.ser"));
            System.out.println("*** ser File opened for reading ***");
        } catch (IOException iow) {
            System.out.println("Error opening ser File: " + iow.getMessage());
        }
    }

    //Closes the ser File
    public void closeSerFile() {
        try {
            input.close();
            System.out.println("*** ser Filed closed ***");
        } catch (IOException ioe) {
            System.out.println("Error closing ser File: " + ioe.getMessage());
        }
    }

    //Adding ser Objects to ArrayList
   public void cusListPopulateArrays() {
        try {
            //Object ob = null;
			Boolean cont = true;
            FileInputStream is = new FileInputStream("stakeholder.ser");
            ObjectInputStream os = new ObjectInputStream(is);
			Customer cust = null;
			while (cont) {
				try {
					cust = (Customer)os.readObject();
					//cusList.add(customer);
					//Customer cust = (Customer)os.readObject();
				} catch (ClassNotFoundException e) {
					System.out.println("Class not Found: " + e.getMessage());
				} 
				
				if(cust != null)
                    cusList.add(cust);
                else
                    cont = false;
			}
			
            os.close();
			is.close();
		} catch (FileNotFoundException e){
			System.out.println("Error adding arrays: " + e.getMessage());
		}
         catch (IOException ioe) {
            System.out.println("Error adding arrays: " + ioe.getMessage());
        }
        System.out.println("Arrays added - EOF");
}
	
	    public void suppListPopulateArrays() {
        try {
            //Object ob = null;
			Boolean cont = true;
            FileInputStream is = new FileInputStream("stakeholder.ser");
            ObjectInputStream os = new ObjectInputStream(is);
			Supplier supp = null;
			while (cont) {
				try {
					 supp = (Supplier)os.readObject();
				} catch (ClassNotFoundException e) {
					System.out.println("Class not Found: " + e.getMessage());
				} 
				
				if(supp != null)
                    supList.add(supp);
                else
                    cont = false;
			}
			
            os.close();
			is.close();
		} catch (FileNotFoundException e){
			System.out.println("Error adding arrays: " + e.getMessage());
		}
         catch (IOException ioe) {
            System.out.println("Error adding arrays: " + ioe.getMessage());
        }
        System.out.println("Arrays added - EOF");
    }
    //Writing to the txt File

    public void writeToCus() {
        try {
            FileOutputStream out = new FileOutputStream("myfile.txt");
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            for (int i = 0; i < cusList.size(); i++) {

//                objOut.writeObject(cusList);
                //objOut.writeObject(supList.get(i));
            }

            objOut.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //Opens the txt File for reading
    public void openTxtFile() {
        try {
            input = new ObjectInputStream(new FileInputStream("myfile.txt"));
            System.out.println("*** txt File opened for reading ***");
        } catch (IOException iow) {
            System.out.println("Error opening txt File: " + iow.getMessage());
        }
    }

//Closes the txt File
    public void closeTxtFile() {
        try {

            input.close();
        } catch (IOException ioe) {
            System.out.println("Error closing txt File: " + ioe.getMessage());
        }
    }
public int calculateAge(LocalDate dateOfBirth, LocalDate currentDate)
{
return Period.between(dateOfBirth, currentDate).getYears();
}
 public void sortBothMethods(){
        String[] sortingCust = new String[Customer.size()];
        String[] sortingSupplier= new String[Supplier.size()];
        ArrayList<Customer> sortingCustomer= new ArrayList<>();
        ArrayList<Supplier> sortSupplierArray= new ArrayList<>();
        int count = Customer.size();
        int icount = Supplier.size();
        for (int i = 0; i < count; i++) {
            sortingCust[i] = Customer.get(i).getStHolderId();
        }
        Array.sort(sortingCust);
        
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (sortingCust[i].equals(Customer.get(j).getStHolderId())){
                    sortingCustomer.add(Customer.get(j));
                }
            }
        }
       
        Customer = sortingCustomer;
        
        for(int i= 0; i<icount;i++){
            sortingSupplier[i]= Supplier.get(i).getName();
        }
        Arrays.sort(sortingSupplier);
        
        for (int i=0; i<icount;i++){
            for (int j=0; j< icount;j++){
                if(sortingSupplier[i].equals(Supplier.get(j).getName())){
                    sortSupplierArray.add(Supplier.get(j));
                }
            }
        }
       Supplier= sortSupplierArray;
    }
   
    
    public void writeCustomer(){
        try{
            customerWrite = new FileWriter("customerOutFile.txt");
          
            bf = new BufferedWriter(customerWrite);
            
            bf.write(String.format("%-10s \n", "=================== CUSTOMERS ========================"));
            
            bf.write(String.format("%-5s %-10s %-12s %-15s %-15s\n", "ID","Name","Surname","Date of Birth","Age"));
             
            bf.write(String.format("%-10s \n", "======================================================"));
            
            for (int i = 0; i < Customer.size(); i++) {
                bfr.write(String.format("%-5s %-10s %-12s \n", customer.get(i).getStHolderId(), customer.get(i).getFirstName(), customer.get(i).getSurName()));
            }
         
            
            
            bf.write(String.format("%-10s \n", "\nNumber of customers allowed to rent:        4"));
            bf.write(String.format("%-10s \n", "Number of customers not allowed to rent:     2"));
           
          
        }
        catch(IOException fnfe )
        {
            System.out.println(fnfe);
            System.exit(1);
        }
        try{
            bf.close( ); 
        }
        catch (IOException ioe){            
            System.out.println("error closing text file: " + ioe.getMessage());
            System.exit(1);
        }
    }
    
     public void writeSupplier(){
        try{
            
            FileWriter supplierWriter = new FileWriter("supplierOutFile.txt");
           
            BufferedWriter bf2 = new BufferedWriter(supplierWriter);
           
            bf2.write(String.format("%-10s \n", "========================== SUPPLIERS ============================="));
            
            bf2.write(String.format("%-5s %-20s %-15s %-15s\n", "ID","Product Name","Product Type","Product Description"));
            
            bf2.write(String.format("%-10s \n", "=================================================================="));
            
            for (int i = 0; i < Supplier.size(); i++) {
                bf2.write(String.format("%-5s %-20s %-15s %-15s \n", supplier.get(i).getStHolderId(), supplier.get(i).getName(), supplier.get(i).getProductType(),supplier.get(i).getProductDescription()));
            }
          
        }
        catch(IOException exc )
        {
            System.out.println(exc);
            System.exit(1);
        }
        try{
            bf2.close( ); 
        }
        catch (IOException ioe){            
            System.out.println("error closing text file: " + ioe.getMessage());
            System.exit(1);
        }
    }
    //Reads the txt File
  /* public void readTxtFile() {
//        // Deserialization
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("myfile.txt");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            //cusList. = (Customer) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("a = " + object1.a);
          System.out.println("b = " + object1.b);
       } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }}
*/
   
}
