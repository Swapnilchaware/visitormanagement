package swapdemocode.Service;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import swapdemocode.DemoEntity.AdminWe;
import swapdemocode.Entity.AdminEntity;
import swapdemocode.Repository.AdminRepository;
@Component
public class AdminService {
	
	@Autowired
	private AdminRepository repo;
	
	public void registerAdmin(AdminEntity regAdmin) {
		
		String username = regAdmin.getUsername();
		System.out.println(username);
		AdminEntity temp = repo.findByUsername(username);
		if (temp != null) throw new IllegalArgumentException( "Username already exits");
		else {
			repo.save(regAdmin);
		}	
	}
	

	public List<AdminWe> viewAdmin() {
		// TODO Auto-generated method stub
		
		List<AdminEntity> adminList = (List<AdminEntity>) repo.findAll();
		List<AdminWe> webAdminList = adminList.stream().map( admin -> new AdminWe(admin.getId(),admin.getUsername(),admin.getEmail()) ).collect(Collectors.toList());
		
		System.out.print(adminList);
		
		return webAdminList;
}

	public void changepassword(AdminEntity cp,int id) {
		// TODO Auto-generated method stub
		AdminEntity db_cp = repo.getUserById(id);
		
		if (db_cp == null) throw new IllegalArgumentException( "admin not found");
		String oldpass = db_cp.getPassword();
		System.out.println(oldpass);
		db_cp.setPassword(cp.getPassword());
		repo.save(db_cp);
	}

	public void deleteadmin(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	
	
}
	















	
//List<ProductManager> B = A.stream()
//.map(developer -> new ProductManager(developer.getName(), developer.getAge()))
//.collect(Collectors.toList());






	