/**
 * Author: Srilokh Karuturi
 * Date: Tue Feb 15 2022
 * File: LinkedList.java
 * Purpose: LinkedList Implementation with Static Linked List Node implementation 
 */

 // LinkedList Class Class which also defines IDedObject which let's us know of T implementation 
public class LinkedList<AnyType extends IDedObject> {
    // static class Node such that T extends IDedobject, we use this extra information to define
    // the properties that data will have . 
    public static class Node<AnyType extends IDedObject> {
        // IDed object for sure
        AnyType data;
        // pointer to the next 
        Node<AnyType> next;

        // constructor for creating a node 
        public Node(AnyType data){
            this.data = data;
            this.next = null;
        }

        // constructor for creating a node 
        public Node(AnyType data, Node<AnyType> next){
            this.data = data;
            this.next = null;
        }
        
    }

    // define node head and tail
    Node<AnyType> head;
    Node<AnyType> tail;

    // default constructor where we initialize head and tail
    public LinkedList() {
        head = null;
        tail = null;
    }
    // empty the linked list
    public void makeEmpty(){
        if(head == null && tail == null)
            System.out.println("\nLinked List is already empty.\n");
        head = null;
        tail = null;
    }

    // find the id and return the node
    public AnyType findID(int ID){
        // check if it's empty
        if(head == null){
            System.out.println("LinkedList is empty. There are no ID's to find.");
        }
        else{
        // start at the head
        Node<AnyType> temp = head;
        while(temp != null){
            // if we the id matches then return T object
            if(temp.data.getID() == ID){
                return temp.data;
            }
            // go to the next node
            temp = temp.next;
        }
        // return null
        }

        // return null 
        return null;
    }

    // This is a function where we insert a node at the front
    public Boolean insertAtFront(AnyType t){
        // create a temporary node
        Node<AnyType> insert = new Node<AnyType>(t);
        // id type of insert
        // check if head is null 
        if(head==null){
            // define the head to be the temp 
            head = insert;
            return true;
        }// insert at the front by changing the pointer
        else{

            if(findID(insert.data.getID()) == t){
                return false;
            }
            // set the temporary pointer to the current head
            Node<AnyType> temp = head;
            // set head
            head = insert;
            // let head.next equal the predecessor head 
            head.next = temp; 
            return true;
        }

    }

    public AnyType deleteFromFront(){
        // if the head is null list 
        if(head == null){
            return null;
        } else {
            Node<AnyType> temp = head;
            head = head.next;
            return temp.data;
        }

    }

    public AnyType delete(int ID){
        if(head == null)
            return null;

        // begin at the start 
        Node<AnyType> temp = head;

        // check if the head is equal to the id we are trying to delete
        if(temp.data.getID() == ID){
            AnyType removing = temp.data; 
            deleteFromFront();
            return removing;
        }

        // traverse till we find the id we are looking for 
        while(temp != null && temp.next != null){
            // if we the id matches then return T object
            if(temp.next.data.getID() == ID){
                // temporarily set t to this so we can return this 
                AnyType removing = temp.next.data;
                temp.next = temp.next.next;
                return removing;
            }
            // go to the next node 
            temp = temp.next;
        }

        
        return null;
 
    }


    // print all records 
    public void printAllRecords(){
        // check to see if we can even print anything 
        if(head == null){
            // 
            System.out.println("LinkedList is empty. There are no ID's to find. \n");
        }
        else {
            // start at the temp
            Node<AnyType> temp = head;
            // while temp is not null 
            while(temp != null){
                // print the records 
                temp.data.printID();
                // move to the next node 
                temp = temp.next;
            }
        }// else

    }
    






}
