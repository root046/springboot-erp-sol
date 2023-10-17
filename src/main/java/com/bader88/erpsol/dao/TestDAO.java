package com.bader88.erpsol.dao;

import com.bader88.erpsol.entity.testEntity;
import com.bader88.erpsol.repository.testRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/test")
public class TestDAO {

	@Autowired
	private testRepo TestRepo;
	
	public String getName() {
		return"Name..(Test DAO)";
	}

	public Iterable<testEntity> getUsers(){

		return  this.TestRepo.findAll();
	}
	
	public Optional<testEntity> getUserById(Integer userId){
		
		return this.TestRepo.findById(userId);
	}
	
	public long xx(){
		return this.TestRepo.count();
	}
	
	public String deleteUserById(Integer userId) {
		Optional<testEntity> user = this.getUserById(userId);
		if(user.isPresent()) {
			this.TestRepo.deleteById(userId);
			return "User Deleted ..";
		}
		else {
			return "User Not Exist";
		}
	}
	
	public testEntity saveUser(testEntity user) {
		
		return this.TestRepo.save(user);
	}

	public testEntity updateUser(testEntity user) {
		Optional<testEntity> u = this.getUserById((user.getUserId()));
		
		if(u.isPresent()) {
			return this.TestRepo.save(user);
		}else {
			return null;
		}
	}
	
	public List<testEntity> getAllUsersUsingJPQL(){
		return this.TestRepo.getAllUsersUsingJPQL();
	}
	
	public testEntity getUserByIdUsingJPQL(Integer id){
		return this.TestRepo.getUserByIdUsingJPQL(id);
	}
	
	public void resetPasswordByIdUsingJPQL(String password,Integer id) {
		//void doesn`t return data
		 this.TestRepo.resetPasswordByIdUsingJPQL(password, id);
	}

	public String deleteUserByIdUsingJPQL(Integer Id){
//		this.TestRepo.deleteUserByIdUsingJPQL(Id);
		Optional<testEntity> user = this.getUserById(Id);
		if(user.isPresent()) {
			this.TestRepo.deleteUserByIdUsingJPQL(Id);
			return "User Deleted ..";
		}
		else {
			return "User Not Exist";
		}
	}

	public List<testEntity> getAllUsersByNativeQueryJPQL(){
		return this.TestRepo.getAllUsersByNativeQueryJPQL();
	}
	


}


