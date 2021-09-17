package swapdemocode.Repository;

import org.springframework.data.repository.CrudRepository;
import swapdemocode.Entity.AdminEntity;


public interface AdminRepository extends CrudRepository<AdminEntity, Integer> {
	
	public AdminEntity getUserById(int id); 
	
//	public String findByUsernameContaining(String username);
	
	public AdminEntity findByUsername(String username);
	
	
	
}