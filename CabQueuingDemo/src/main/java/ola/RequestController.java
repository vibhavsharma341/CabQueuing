package ola;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // This means URL's start with /demo (after Application path)
public class RequestController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RefreshService refreshService;
	
	@RequestMapping("/customer")
	public String customer(Map<String, Object> model) {
		refreshService.refresh();
		return "customer";
	}
	
	@RequestMapping(value="/rideNow",method=RequestMethod.POST)
	public String rideNow(Map<String, Object> model,@RequestParam(value="customerId") Integer customerId) {		
		refreshService.refresh();
		customerService.registerRide(customerId);
		return "successfulRide";
	}
	
	/*@RequestMapping("/driver")
	public String driver(Map<String, Object> model,@RequestParam(value="driverId") Integer driverId) {
		//CustomerService customerService = new CustomerService();
		System.out.println("DriverID"+driverId);
		return "driver";
	}*/
}
