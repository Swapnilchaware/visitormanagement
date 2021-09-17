package swapdemocode.Repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import swapdemocode.Entity.AdminEntity;
import swapdemocode.Entity.VisitorEntity;

public interface VisitorRepository extends CrudRepository<VisitorEntity, Integer> {

	
	public List<VisitorEntity> findAllByAdminEntity(AdminEntity id);

	public List<VisitorEntity> findAllByAdminEntityAndStatus(AdminEntity id,int status);
	
	public VisitorEntity findById(int id);
	
	public List<VisitorEntity> findByAdminEntity(AdminEntity id);

}