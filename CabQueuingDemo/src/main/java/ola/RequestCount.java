package ola;

public class RequestCount {
    
    private static RequestCount requestCount;
    private Integer count;
   
    private RequestCount(Integer count){
    	
    	this.count = count; 
         
    }
    
    public static RequestCount getInstance(){
        if(requestCount == null){
        	requestCount = new RequestCount(1);
        }
        return requestCount;
    }
     
    public Integer getCount(){
        return count;
    }
    
    public void setCount(Integer count){
        this.count = count;
    }
}
