package com.bader88.erpsol.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bader88.erpsol.dao.TestDAO;
import com.bader88.erpsol.dto.AddressDTO;
import com.bader88.erpsol.dto.Registration;
import com.bader88.erpsol.dto.UserDTO;
import com.bader88.erpsol.entity.testEntity;
import com.bader88.erpsol.repository.testRepo;

@RestController
public class TestController {
	
	@GetMapping("/test")
	public String testMethod() {
		return "test method executed!";
	}
	
	@GetMapping(path = "/x")
	public String x() {
		return "x";
	}
	
	@GetMapping("/y")
	public String name(@RequestParam String name,
					   @RequestParam(name = "xx") String x) {
		return "my name is:"+name+x;
	}
	
	@GetMapping("/path/{firstName}/{lastName}")
	public String path(@PathVariable("firstName") String Fname,
						@PathVariable("lastName") String Lname) {
		
		return "Your Name Is : "+Fname+"-"+Lname;
	}
	
	@PostMapping(path =  "/testPost")
	public String testPost(@RequestBody Registration form) throws Exception{
		
//		throw new Exception("test ex...");
		return "Username : "+form.getUsername()+
				"E-mail : "+form.getEmail()+
				"password : "+form.getPassword();
	}
	
	@PostMapping(path =  "/testPost2")
	public Registration testPost2(@RequestBody Registration form) throws Exception{
		
		return form;
	}
	@GetMapping(path = "/json")
	public List<UserDTO> getUsers(){
		List<UserDTO> users = new ArrayList<>();
		
		List<AddressDTO> baderAddress = new ArrayList<>();
		baderAddress.add(new AddressDTO("Saudi", "Tabuk", "alworod"));
		baderAddress.add(new AddressDTO("Saudi", "Yanbu", "alsimiri"));
		baderAddress.add(new AddressDTO("Saudi", "Riyadh", "alnasim"));
		
		List<AddressDTO> naderAddress = new ArrayList<>();
		naderAddress.add(new AddressDTO("Saudi", "Tabuk", "alworod"));
		naderAddress.add(new AddressDTO("Saudi", "Yanbu", "alsimiri"));
		naderAddress.add(new AddressDTO("Saudi", "Riyadh", "alnasim"));
		
		List<AddressDTO> ibrahimAddress = new ArrayList<>();
		ibrahimAddress.add(new AddressDTO("Saudi", "Tabuk", "alworod"));
		ibrahimAddress.add(new AddressDTO("Saudi", "Yanbu", "alsimiri"));
		ibrahimAddress.add(new AddressDTO("Saudi", "Riyadh", "alnasim"));
		
		
		
		users.add(new UserDTO("bader","alanazi","123456789","M", baderAddress));
		users.add(new UserDTO("nader","alanazi","111111111","M", naderAddress));
		users.add(new UserDTO("ibrahim","alanazi","222222222","M", ibrahimAddress));
		
		
		return users;
	}
	
	@PostMapping(path = "/postJson")
	public UserDTO postJson(@RequestBody UserDTO user){
		user.getAddresses().forEach(p->{
			
			System.err.println("-----------------");
			System.err.println(p.getCountry());
			System.err.println(p.getCity());
			System.err.println(p.getStreet());
			
		});
		
		return user;
	}
	
	@Autowired
	private TestDAO testDAO;
	
	@GetMapping(path = "/testDAO")
	public String getName() {
		return this.testDAO.getName();
		
	}
	
	@Autowired
	private testRepo TestRepo;
	@GetMapping(path = "/getUsers")
	public Iterable<testEntity> getUsersFromDAO() {
		
		
//		return this.testDAO.getUsers();
		return this.TestRepo.findAll();
	}
	
	@GetMapping(path = "/getUserById")
	public Optional<testEntity> getUserById(@RequestParam(name = "id") Integer id){
		
		return this.testDAO.getUserById(id);
	}
	
	@GetMapping(path = "/getNameByUserId")
	public String getName(@RequestParam(name="id") Integer id) {
		
		Optional<testEntity> user = this.testDAO.getUserById(id);
		
		if(user.isPresent()) {
			return "Full Name : "+user.get().getFullName();
		}else
		return "ID Not Valid !";
	}
	
	@GetMapping(path = "/count")
	public long count() {
		return this.testDAO.xx();
	}
	
	@GetMapping(path = "/deleteUserById")
	public String deleteUserById(@RequestParam (name = "id") Integer id) {
		return this.testDAO.deleteUserById(id);
	}
	
	@PostMapping(path = "/saveUser")
	public testEntity saveUser(@RequestBody testEntity user) {
		return this.testDAO.saveUser(user);
	}
	
	@PostMapping(path = "/updateUser")
	public testEntity updateUser(@RequestBody testEntity user) {
		
		return this.testDAO.updateUser(user);
	}
	
	@GetMapping(path = "/getAllUsersByJPQL")
	public List<testEntity> getAllUsersByJPQL() {
		return this.testDAO.getAllUsersUsingJPQL();
	}
	
	@GetMapping(path = "/getUsersByIdUsingJPQL")
	public testEntity getUsersByIdUsingJPQL(@RequestParam (name = "id") Integer id){
		return this.testDAO.getUserByIdUsingJPQL(id);
	}
	
	@PostMapping(path = "/resetPasswordByIdUsingJPQL")
	public void resetPasswordByIdUsingJPQL(@RequestBody testEntity user) {
		this.testDAO.resetPasswordByIdUsingJPQL(user.getPassword(), user.getUserId());
	}

	@GetMapping(path = "/deleteUserByIdUsingJPQL")
	public String deleteUserByIdUsingJPQL(@RequestParam (name = "id") Integer id){
		return this.testDAO.deleteUserByIdUsingJPQL(id);
	}
@GetMapping(path = "/getAllUsersByNativeQueryJPQL")
	public List<testEntity> getAllUsersByNativeQueryJPQL(){
		return this.testDAO.getAllUsersByNativeQueryJPQL();
	}
}
