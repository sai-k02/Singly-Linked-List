/**
 * Author: Srilokh Karuturi
 * Date: Tue Feb 15 2022
 * File: Product.java
 * Purpose: Create product object which implements interface "IDedObject"
 */

public class Product implements IDedObject {
    // properties
    private int productID;
    private String productName;
    private String supplierName;
    
    // methods
    Product(int productID, String productName, String supplierName){
        this.productID = productID;
        this.setProductName(productName);
        this.setSupplierName(supplierName);
    }
    


    public String getSupplierName() {
        return supplierName;
    }



    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    // get id 
    public int getID() {
        return this.productID;
    }

    // print id 
    public void printID() {
        System.out.println("\nProduct ID: "+ productID +"\nProduct Name: "+ productName + "\nSupplier Name: "+ supplierName);
    }

    
}
