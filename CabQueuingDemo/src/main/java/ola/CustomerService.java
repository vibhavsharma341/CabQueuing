package ola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
		
	@Autowired
	private RequestRepository requestRepository;
		
	public void registerRide(Integer customerId)
	{
		Integer count = RequestCount.getInstance().getCount();
	
		Request request = new Request();
		request.setCustomerId(customerId);
		request.setDriverId(null);
		request.setRequestId(count++);
		
		RequestCount.getInstance().setCount(count);
		
		request.setStatus("Waiting");
		request.setTimeElapsed(null);
		
		requestRepository.save(request);
		
	}

	
	
	
}
