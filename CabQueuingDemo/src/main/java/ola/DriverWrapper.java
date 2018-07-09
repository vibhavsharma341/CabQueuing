package ola;

import java.util.HashMap;
import java.util.Map;

public class DriverWrapper {
    
    private static DriverWrapper driverWrapper;
    private Map<Integer,Boolean> allDrivers = new HashMap<Integer,Boolean>();
   
    private DriverWrapper(){
    	
    	for(int i=1;i<=5;i++)
    		allDrivers.put(i, true);
         
    }
    
    public static DriverWrapper getInstance(){
        if(driverWrapper == null){
        	driverWrapper = new DriverWrapper();
        }
        return driverWrapper;
    }
     
    public Map<Integer,Boolean> getAllDrivers(){
        return allDrivers;
    }
    
    public void setAllDrivers(HashMap<Integer,Boolean> allDrivers){
        this.allDrivers = allDrivers;
    }
}

