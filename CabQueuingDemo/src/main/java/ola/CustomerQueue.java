package ola;

import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueue {
    
    private static CustomerQueue customerObj;
    private Queue<Integer> customerQueue = new LinkedList<Integer>();
   
    private CustomerQueue(Queue<Integer> customerQueue){
    	
    	this.customerQueue = customerQueue; 
         
    }
    
    public static CustomerQueue getInstance(){
        if(customerObj == null){
            customerObj = new CustomerQueue(new LinkedList<Integer>());
        }
        return customerObj;
    }
     
    public Queue<Integer> getCustomerQueue(){
        return customerQueue;
    }
    
    public void setCustomerQueue(Queue<Integer> customerQueue){
        this.customerQueue = customerQueue;
    }
}
