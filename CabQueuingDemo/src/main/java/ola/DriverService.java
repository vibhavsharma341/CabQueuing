package ola;

import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
	@Autowired
	private RequestRepository requestRepository;
		
	public boolean acceptRide(Integer customerId,Integer driverId)
	{Boolean isAvailable = DriverWrapper.getInstance().getAllDrivers().get(driverId);
	
	if(isAvailable)		
	{	
		System.out.println("Customer to Ride "+customerId);
		Request allotRide = requestRepository.findByCustomerId(customerId);
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
