package net.guides.springboot2.crud.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import antlr.collections.List;
import net.guides.springboot2.crud.demo1.model.*;

@Repository
public interface ReportRepository extends JpaRepository<DetailsFromOrm, Integer>{
	
	 DetailsFromOrm findByDoctorid(int doctorid);
	public static DetailsFromOrm finByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	 
	 
}