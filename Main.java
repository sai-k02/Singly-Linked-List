/**
 * Author: Srilokh Karuturi
 * Date: Tue Feb 15 2022
 * File: Main.java
 * Purpose: Prompt user .. Make the linkedlist, add products, display menu for user .. 
 */

import java.util.Scanner;
public class Main{
    // Scanner object for input 
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        // Define Linked List 
        LinkedList<Product> products = new LinkedList<Product>();

        // define menuInput
        int menuInput = -1;

        // define cleanline
        String clean = "\n\n------------------------------------";
        System.out.println(clean);

        // define menuOptions
        String menuOptions = "\n\nOperations on List:\n" + 
        "1. Make Empty\n" +
        "2. Find ID\n"+
        "3. Insert At Front\n"+
        "4. Delete From Front\n"+
        "5. Delete ID\n"+
        "6. Print All Records\n"+
        "7. Done\n";





        //

        // define scanner object for input
        Scanner input = new Scanner(System.in);

        // prompt user menu
        do{
            // ask user for input
            System.out.println(menuOptions);
            // print line
            System.out.println(clean);
            // ask user for option 
            System.out.print("\n\nOption: ");


            // get the next integer from user 
            menuInput = input.nextInt();
            if(menuInput == 7){
                System.out.println("You picked 'Done'\n\n");
                menuInput = -1;
                System.exit(0);
            }
            else{
                products = processMenuOption(menuInput, products);
            }
            System.out.println(clean);
        }while(menuInput != -1); // while the input does not equal -1 which is the exit value 

        // close scanner object
        input.close();


    }

    public static LinkedList processMenuOption(int option, LinkedList products){

        int productID;
        String productName, supplierName;
        Product temp;
        switch (option){
            case 1:
                // process make empty
                System.out.println("\n"+"You picked 'Make Empty' ");
                products.makeEmpty();
                break;
            case 2: 
                // find id 
                System.out.println("\n"+"You picked 'Find ID' \n");
                // get id 
                System.out.print("ID: ");
                int id = input.nextInt();
                System.out.println();
                // print information regarding this id 
                temp = (Product) products.findID(id);

                if(temp == null){
                    System.out.println("\nID does not exist.\n");
                }else{
                    System.out.println("\nID found.\n");
                    temp.printID();
                }
                break;
            case 3:
                System.out.println("\n"+"You picked 'Insert At Front' \n");
                // create a product
                // ask the user for productID, productName, supplierName
                System.out.print("Product ID: ");
                productID = input.nextInt();
                System.out.print("Product Name: ");
                productName = input.next();
                System.out.print("Supplier Name: ");
                supplierName = input.next();

                Product tempProduct = new Product(productID, productName, supplierName);
                // insert product 
                if(products.insertAtFront(tempProduct)){
                    System.out.println("\nSuccessfully inserted a new product.\n ");
                }

                break;
            case 4:
                System.out.println("\n"+"You picked 'Delete From Front'");
                // get id of the front
                temp = (Product) products.deleteFromFront();

                if(temp == null){
                    System.out.println("\nLinkedList is empty. Nothing to delete.\n");
                }else{
                    System.out.println("\nSuccessfully deleted \n");
                    temp.printID();
                }

                break;

            case 5:
                System.out.println("\n"+"You picked 'Delete ID'");
                // get id from user
                System.out.print("ID: ");
                productID = input.nextInt();
 
                // delete that specific id 
                temp =  (Product) products.delete(productID);
                if(temp == null){
                    System.out.println("\nID does not exist.\n");
                }else{
                    System.out.println("\nSuccessfully deleted \n");
                    temp.printID();
                }
                break;

            case 6:
                System.out.println("\n"+"You picked 'Print All Records'\n");
                products.printAllRecords();
                break;
            default:
                System.out.println("'"); 
                break;

        }
        // return products
        return products;

    }





}