package org.itstep.dao;

import java.util.List;

import org.itstep.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodDAO extends JpaRepository<Good, String> {
	
	
	@Query(value="SELECT * FROM good WHERE availability=true", nativeQuery=true)
	List<Good> findAllByAvailability();
}