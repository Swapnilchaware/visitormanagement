package swapdemocode.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import swapdemocode.DemoEntity.AdminWe;
import swapdemocode.Entity.AdminEntity;
import swapdemocode.Service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	public AdminService adminserve;
	
	@RequestMapping(method = RequestMethod.POST,value="/register-admin")
	public void registerAdmin(@RequestBody AdminEntity regAdmin) {	
		adminserve.registerAdmin(regAdmin);	
	}

	@RequestMapping("view-admin")
	public List<AdminWe> viewAdmin() {
		return adminserve.viewAdmin();
	}
	
	@RequestMapping(method= RequestMethod.PUT,value="/{id}/change-password")
	public void changePassword(@RequestBody AdminEntity cp,@PathVariable int id ) {
		adminserve.changepassword(cp,id);
	}
	
	@RequestMapping(method= RequestMethod.DELETE,value="/{id}/delete")
	public void deleteAdmin(@PathVariable int id) {
		adminserve.deleteadmin(id);
	}
	
}





	
	