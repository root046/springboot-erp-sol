package com.bader88.erpsol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bader88.erpsol.entity.testEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface testRepo extends JpaRepository<testEntity, Integer> {
//	Diving Into Spring Data (JPQL & Native Query)
	
	@Query(value = "SELECT t FROM testEntity t")
	List<testEntity> getAllUsersUsingJPQL();
	
	@Query(value = "SELECT t FROM testEntity t WHERE t.userId=:id")
	testEntity getUserByIdUsingJPQL(Integer id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE testEntity t SET t.password=:password WHERE t.userId =:userId")
	void  resetPasswordByIdUsingJPQL(String password,Integer userId);
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM testEntity t where t.userId = :userId")
	void deleteUserByIdUsingJPQL(Integer userId);
	@Query(value = "select * from users order by user_id desc",nativeQuery = true)
	List<testEntity> getAllUsersByNativeQueryJPQL();



}
