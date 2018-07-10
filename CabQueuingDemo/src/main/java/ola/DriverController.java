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
		
	@RequestMapping("/refresh")
	public String refresh(Map<String, Object> model) {		
		refreshService.refresh();
		return "successfulRide";
	}
	
	
}
