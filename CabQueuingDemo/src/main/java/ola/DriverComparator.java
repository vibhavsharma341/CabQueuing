package ola;

import java.util.Comparator;

class DriverComparator implements Comparator<Driver>{
    
    // Overriding compare()method of Comparator 
                // for descending order of cgpa
    public int compare(Driver d1, Driver d2) {
        if (d1.getStatus() < d2.getStatus())
            return 1;
        else if (d1.getStatus() > d2.getStatus())
            return -1;
                        return 0;
        }
}
