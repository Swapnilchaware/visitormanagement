package swapdemocode.Service;

import java.util.Date;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import swapdemocode.DemoEntity.VisitorWe;
import swapdemocode.Entity.AdminEntity;
import swapdemocode.Entity.VisitorEntity;
import swapdemocode.Repository.VisitorRepository;

@Component
public class VisitorService {
	@Autowired
	private VisitorRepository repo1;
	
	public void registerVisit(VisitorEntity regVisit) {
	
		regVisit.setStatus(1);
		List<VisitorEntity> temp = repo1.findByAdminEntity(new AdminEntity(regVisit.getAdminEntity().getId()) );
		if(temp == null) throw new IllegalArgumentException( "Invalid Admin");
		else {
		
			
			repo1.save(regVisit);
		}
		
	}

	public List<VisitorEntity> viewVisit() {
		List<VisitorEntity> visitorList = (List<VisitorEntity>) repo1.findAll();
	
		return visitorList;
	}

	public List<VisitorWe> viewVisitByAdmin(int id) {
		// TODO Auto-generated method stub
		
		List<VisitorEntity> allvisit = repo1.findAllByAdminEntity(new AdminEntity(id));
		
//		List<Admin> adminList = (List<Admin>) repo.findAll();
//		List<AdminWe> webAdminList = adminList.stream().map( admin -> new AdminWe(admin.getId(),admin.getUserName(),admin.getEmail()) ).collect(Collectors.toList());
//		
//		System.out.print(adminList);
		
		
	List<VisitorWe> demoVisit = allvisit.stream().map(
				visit -> new VisitorWe(visit.getId(),visit.getName(),visit.getLoginTime(),
			visit.getLogoutTime() )).collect(Collectors.toList());
	
		return demoVisit;
	}

	public List<VisitorWe> viewActiveVisitByAdmin(int id) {
	
		List<VisitorEntity> allactivevisit = repo1.findAllByAdminEntityAndStatus(new AdminEntity(id), 1);
		
		List<VisitorWe> demoVisit = allactivevisit.stream().map(
				visit -> new VisitorWe(visit.getId(),visit.getName(),visit.getLoginTime(),
				visit.getLogoutTime() )).collect(Collectors.toList());
	
		return demoVisit;
	}

	public void logoutUser(int id) {
		
		VisitorEntity userDb = repo1.findById(id);
		if (userDb == null) throw new IllegalArgumentException( "Visitor not found");
		System.out.println(userDb);
		userDb.setStatus(0);
		userDb.setLogoutTime(new Date());
		repo1.save(userDb);

		
	}

	public void deletevisitor(int id) {
	
		repo1.deleteById(id);
	}

	public void editvisitentry(VisitorEntity cp, int id) {
		
		repo1.save(cp);
		
	}


	
}
