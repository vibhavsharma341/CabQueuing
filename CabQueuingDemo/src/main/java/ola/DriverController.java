package ola;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // This means URL's start with /demo (after Application path)
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private RefreshService refreshService;
	
	@RequestMapping("/driver")
	public String driver(Map<String, Object> model) {
		refreshService.refresh();
		return "driver";
	}
	
	@RequestMapping(value="/acceptRide",method=RequestMethod.POST)
	public String rideNow(Map<String, Object> model,@RequestParam(value="driverId") Integer driverId) {
		refreshService.refresh();
		if(driverService.acceptRide(driverId))
		return "successfulRide";
		else
			return "failureRide";
	}
	
	@RequestMapping("/refresh")
	public String refresh(Map<String, Object> model) {		
		refreshService.refresh();
		return "successfulRide";
	}
	
	
}
