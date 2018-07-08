package ola;

import java.util.Queue;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ola.CustomerQueue;

@Service
public class DriverService {
	@Autowired
	private RequestRepository requestRepository;
		
	public void acceptRide()
	{
		Queue<Integer> queue = CustomerQueue.getInstance().getCustomerQueue();
		Integer customerToRide = queue.peek();
		CustomerQueue.getInstance().setCustomerQueue(queue);
		Request allotRide = requestRepository.findByCustomerId(customerToRide);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime current = LocalDateTime.now(); 
		
		allotRide.setStatus("Ongoing");
		requestRepository.save(allotRide);
		
		
	}
	
}
