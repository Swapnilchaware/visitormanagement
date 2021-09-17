package swapdemocode.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import swapdemocode.DemoEntity.VisitorWe;
import swapdemocode.Entity.VisitorEntity;
import swapdemocode.Service.VisitorService;

@RestController
@RequestMapping("/visitor")
public class VisitorController {

	@Autowired
	private VisitorService visitorServe;
	
	
	@RequestMapping(method = RequestMethod.POST,value="/register-visit")
	public void registerAdmin(@RequestBody VisitorEntity regVisit) {
		
	
		
		visitorServe.registerVisit(regVisit);		
	}
	
	@RequestMapping("/visitor")
	public List<VisitorEntity> viewVisitor() {
		return visitorServe.viewVisit();
	}
	
	//it will return visits by admin 
	@RequestMapping("visits-by-admin/{id}")
	public List<VisitorWe> viewVisitorByAdmin(@PathVariable int id) {
		return visitorServe.viewVisitByAdmin(id);
	}
	//it will return active visits by admin
	@RequestMapping("active-visits-by-admin/{id}")
	public List<VisitorWe> viewActiveVisitorByAdmin(@PathVariable int id
			) {
		return visitorServe.viewActiveVisitByAdmin(id);
	}
	
	@RequestMapping(method= RequestMethod.PUT,value="/{id}/logout-user")
	public void LogoutUser(@PathVariable int id) {
		 visitorServe.logoutUser(id);
	}
	
	@RequestMapping(method= RequestMethod.DELETE,value="/{id}/delete")
	public void deleteVisitor(@PathVariable int id) {
		visitorServe.deletevisitor(id);
	}
	
	@RequestMapping(method= RequestMethod.PUT,value="/{id}/edit-visit")
	public void editVisitEntry(@RequestBody VisitorEntity cp,@PathVariable int id ) {
		visitorServe.editvisitentry(cp,id);
	}
	
}
