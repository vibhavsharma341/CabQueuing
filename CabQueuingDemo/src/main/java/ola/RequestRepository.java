package ola;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ola.Request;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface RequestRepository extends CrudRepository<Request, Long> {

	public Request findByCustomerId(Integer customerId);
	
	//public Request findById(Integer requestId);
	
	public Request save(Request request);
	
	public List<Request> findAll();
	   
}
