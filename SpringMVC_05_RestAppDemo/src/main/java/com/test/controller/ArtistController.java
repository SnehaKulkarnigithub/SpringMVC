package com.test.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.beans.Album;
import com.test.beans.Artist;
import com.test.beans.Employee;
 
@RestController
@Controller
@RequestMapping(value = "/album") // URL : https://localhost:8080/employee/getEmployee?id=099?name="darshit"
public class ArtistController {
 
	@ResponseBody
	@RequestMapping(value = "/getAlbum", method = RequestMethod.GET, produces = "application/json")
	public Set<Artist> getAllArtist() {
		Album album1=new Album();
		album1.setAlbum_name("Retro");
		Album album2=new Album();
		album2.setAlbum_name("Bollywood");
		
		Set<Album> albums = new HashSet<Album>();
		albums.add(album1);
		albums.add(album2);
		
		Artist artist1=new Artist();
		artist1.setArtist_name("Arjit");
		artist1.setAlbum(albums);
		
		Set<Artist> artists= new HashSet<Artist>();
		artists.add(artist1);
		return artists;
	}
	
	@ResponseBody
	@GetMapping(value = "/getEmployee/{id}/{name}", produces = "application/json")
	public Employee getEmployeeById(
			@PathVariable("id") Integer id,
			@PathVariable("name") String employeeName) {
		System.out.println("==========>>>>>id from getEmployeeById ::"+id);
		System.out.println("==========>>>>>Employee name from URL ::"+employeeName);
		Employee employee = new Employee();
		employee.setAge(111);
		employee.setFirstName("Darshit");
		employee.setLastName("rabadiya");
		employee.setAge(28);
		employee.setSalary(1500000.00);
		return employee;
	} 
	//localhost:8080/employee/getemployee/800
	
	@ResponseBody
	@GetMapping(value = "/getEmployeeRP", produces = "application/json")
	public Employee getEmployeeByIdpp(@RequestParam(value = "id", required = false) Integer id) {
		System.out.println("========>>>>> id from getEmployeeByUsing RequestParam "+id);
		Employee employee = new Employee();
		//employee.setAge(id);
		employee.setFirstName("Darshit");
		employee.setLastName("rabadiya");
		employee.setAge(28);
		employee.setSalary(1500000.00);
		return employee;
	} 
	
	@PostMapping("/createArtist")
	public void createArtist(@RequestBody Artist artist) {
		System.out.println("====>>> Create emlployee api/url call");
		System.out.println(artist.getArtist_id());
		System.out.println(artist.getArtist_name());
		System.out.println(artist.getAlbum());
		
	}
}