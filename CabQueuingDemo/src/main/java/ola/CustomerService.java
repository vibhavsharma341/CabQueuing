package ola;

import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
		
	private static int count = 0;
	@Autowired
	private RequestRepository requestRepository;
		
	public void registerRide(Integer customerId)
	{
		Queue<Integer> queue = CustomerQueue.getInstance().getCustomerQueue();
		queue.add(customerId);
		CustomerQueue.getInstance().setCustomerQueue(queue);
		Request request = new Request();
		request.setCustomerId(customerId);
		request.setDriverId(null);
		request.setRequestId(count++);
		request.setStatus("Waiting");
		request.setTimeElapsed(0L);
		
		/*Date d1 = null;
	    Date d2 = null;
	    try {
	        d1 = format.parse(dateStart);
	        d2 = format.parse(dateStop);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    // Get msec from each, and subtract.
	    long diff = d2.getTime() - d1.getTime();
	    long diffSeconds = diff / 1000 % 60;
	    long diffMinutes = diff / (60 * 1000) % 60;*/
		
		
		requestRepository.save(request);
		
	}

	
	
	
}
