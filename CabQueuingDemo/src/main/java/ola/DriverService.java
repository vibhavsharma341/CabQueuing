package ola;

import java.util.Date;
import java.util.Locale;
import java.util.Queue;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ola.CustomerQueue;

@Service
public class DriverService {
	@Autowired
	private RequestRepository requestRepository;
		
	public boolean acceptRide(Integer driverId)
	{Boolean isAvailable = DriverWrapper.getInstance().getAllDrivers().get(driverId);
	
	if(isAvailable)		
	{
	
		Queue<Integer> queue = CustomerQueue.getInstance().getCustomerQueue();
		Integer customerToRide = queue.poll();
		
		System.out.println("Customer to Ride "+customerToRide);
		CustomerQueue.getInstance().setCustomerQueue(queue);
		Request allotRide = requestRepository.findByCustomerId(customerToRide);
		System.out.println("Allot Ride "+ allotRide);
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("en", "UK"));
		String date = simpleDateFormat.format(new Date());
		
		System.out.println("ALLOTTED DRIVER " + driverId);		
		allotRide.setTimeElapsed(date);		
		allotRide.setStatus("Ongoing");
		allotRide.setDriverId(driverId);
		requestRepository.save(allotRide);
		DriverWrapper.getInstance().getAllDrivers().put(driverId, false);
		return true;
		}
		
		return false;
		
		
	}
	
}
