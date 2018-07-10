package ola;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RefreshService refreshService;
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private RequestRepository requestRepository;
	
	@RequestMapping("/customer")
	public String customer(Map<String, Object> model) {
		refreshService.refresh();
		return "customer";
	}
	
	@RequestMapping(/*value=*/"/rideNow"/*,method=RequestMethod.POST*/)
	public String rideNow(Map<String, Object> model,@RequestParam(value="customerId") Integer customerId) {		
		refreshService.refresh();
		customerService.registerRide(customerId);
		return "successfulRide";
	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String showList(ModelMap model) {
		List<Request> listOfRequests = requestRepository.findAll();
        model.addAttribute("RequestList", listOfRequests);
        return "dashboard";
    }
	
	@RequestMapping(value = "/driverPage", method = RequestMethod.GET)
    public String showDriver(ModelMap model,@RequestParam(value="driverId") Integer driverId) {
		model.addAttribute("driverId",driverId);
		
        return "driverPage";
    }
	
	@RequestMapping(value = "/ongoing", method = RequestMethod.GET)
    public String ongoing(ModelMap model) {
		List<Request> listOfRequests = requestRepository.findAllByStatus("Ongoing");
		
        model.addAttribute("List", listOfRequests);
        return "ongoing";
    }
	
	@RequestMapping(value = "/waiting", method = RequestMethod.GET)
    public String waiting(ModelMap model,@RequestParam(value="driverId") Integer driverId) {
		List<Request> listOfRequests = requestRepository.findAllByStatus("Waiting");
		model.addAttribute("driver",driverId);	
		
		
        model.addAttribute("List", listOfRequests);
        return "waiting";
    }
	
	@RequestMapping(value = "/driverApp", method = RequestMethod.GET)
    public String driverApp(ModelMap model) {
		
        return "driverApp";
    }
	
	@RequestMapping(value = "/completed", method = RequestMethod.GET)
    public String completed(ModelMap model) {
		List<Request> listOfRequests = requestRepository.findAllByStatus("Completed");
		
        model.addAttribute("List", listOfRequests);
        return "completed";
    }
	
	@RequestMapping(value = "/select", method = RequestMethod.GET)
    public String completed(ModelMap model,@RequestParam(value="customerId") Integer customerId,@RequestParam(value="driverId") Integer driverId) {
		System.out.println("SELECTED "+customerId);
		refreshService.refresh();
		if(driverService.acceptRide(customerId,driverId))
		return "successfulRide";
		else
			return "failureRide";
       
    }
	
	
}
