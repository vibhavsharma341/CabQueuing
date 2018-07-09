package ola;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefreshService {

	@Autowired
	private RequestRepository requestRepository;
	
	public void refresh(){
		List<Request> listOfRequests = requestRepository.findAllByStatus("Ongoing");
		for(int i=0;i<listOfRequests.size();i++)
		{
			String requestTime = listOfRequests.get(i).getTimeElapsed();
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("en", "UK"));
			String currentTime = simpleDateFormat.format(new Date());
			
			
			Date d1 = null;
		    Date d2 = null;
		    try {
		        d1 = simpleDateFormat.parse(requestTime);
		        d2 = simpleDateFormat.parse(currentTime);
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }

		    long diff = d2.getTime() - d1.getTime();
		    long diffMinutes = diff / (60 * 1000) % 60;
		    
		    System.out.println("DIFFERENCE"+diffMinutes);
		    
		    if(diffMinutes>1)
		    {
		    	listOfRequests.get(i).setStatus("Completed");
		    	
		    	HashMap<Integer,Boolean> availability = (HashMap<Integer, Boolean>) DriverWrapper.getInstance().getAllDrivers();
		    	availability.replace(listOfRequests.get(i).getDriverId(), true);
		    	DriverWrapper.getInstance().setAllDrivers(availability);
		    	
		    	requestRepository.save(listOfRequests.get(i));
		    	
		    }
		    
		    		    	
		    
		}
	}
	
}
