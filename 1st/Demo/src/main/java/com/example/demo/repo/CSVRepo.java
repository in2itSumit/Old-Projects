package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CSVEntity;
@Repository
public interface CSVRepo extends JpaRepository<CSVEntity, Integer> {
	@Query(value="select * from csv where vcode like %?1%", nativeQuery =true)
	public Page<CSVEntity> searchByVcode(String vcode, Pageable page);
//			To take values in ascending order
//	@Query(value ="select * from csv  where ianzsioc like %?1%",nativeQuery=true)
//	public Page<CSVEntity> findByIanzsiocByOrderBysnumberASC(String ianzsioc,Pageable paging);
//			To take values in descending orderBy Query
//	@Query(value ="select * from csv  where ianzsioc like %?1% ORDER BY snumber DESC",nativeQuery=true)
//	public Page<CSVEntity> findByIanzsioc(String ianzsioc,Pageable paging);
	
	@Query(value ="select * from csv  where ianzsioc like %?1%",nativeQuery=true)
	public Page<CSVEntity> findByIanzsioc(String ianzsioc,Pageable paging);
}
