package com.example.demo.controller;


//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Work;
import com.example.demo.repository.WorkRepository;

@RestController
@RequestMapping("/works/")
public class WorkController {
	
	@Autowired
	private WorkRepository workrepository;
	
	@GetMapping(value="/getallworks", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Work> getAllWorks(){
		return workrepository.findAll();
	}
	
	@GetMapping(value="/getworkbyid/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Optional<Work> getWorkById(@PathVariable("id") int id) {
		return workrepository.findById(id);
	}
	
	@GetMapping(value="/getbyname/{name}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Work> findByName(@PathVariable("name") String wname){
		return workrepository.findByName(wname);
	}
	
	@GetMapping(value="/countbyphonenumber/{phonenumber}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Long countByPhonenumber(@PathVariable("phonenumber") String pnumber) {
		return workrepository.countByPhonenumber(pnumber);
		
	}
	
	@PostMapping(value="/addwork", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addWork(@Valid @RequestBody Work work) {
		workrepository.save(work);
	}
	
	@DeleteMapping(value="/deletework/{id}")
	public void deleteWork(@PathVariable("id") int id) {
		workrepository.deleteById(id);
	}
	
	@PutMapping(value="/updatework/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updatework(@PathVariable("id") int workid, @Valid @RequestBody Work work) {
		
	Optional<Work> work1 =workrepository.findById(workid);
		
		if(work1.isPresent()) {
			Work workitem=work1.get();
			workitem.setName(work.getName());
			workrepository.save(workitem);
			}
		else {
			workrepository.save(work);
		}
		
	
										 	
	}
}
//Logic using Java Stream.Was able to update only if id is present.

	/*List<Work> worklist =workrepository.findAll();
		List<Work> workobjlist=worklist.stream()
				.filter(p->p.getId()==workid)
				.collect(Collectors.toList());
		 workobjlist.forEach(p->p.setName(work.getName()));
	     workrepository.saveAll(workobjlist);
	    */