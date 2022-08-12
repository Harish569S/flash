package com.example.VaccinationCenter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.VaccinationCenter.entity.Citizen;
import com.example.VaccinationCenter.entity.RequiredResponse;
import com.example.VaccinationCenter.entity.VaccinationCenter;
import com.example.VaccinationCenter.repositories.VaccinationCenterRepository;

@RestController
@RequestMapping("/center")
public class VaccinationController{
	@Autowired
	private VaccinationCenterRepository vaccinationCenterRepository;
	
	
	@Autowired
	private RestTemplate restTemplate;
	

	
	private List<RequiredResponse> full=new ArrayList<>();
	
	
	@PostMapping()
	public VaccinationCenter addcenter(@RequestBody VaccinationCenter center)
	{
		return vaccinationCenterRepository.save(center);
	
	}
	
	@GetMapping("/{id}")
	public RequiredResponse getcenterwithcitizen(@PathVariable int id)
	{
		RequiredResponse rep=new RequiredResponse();
		VaccinationCenter vaccinationCenter=vaccinationCenterRepository.findById(id).get();
				rep.setCenter(vaccinationCenter);
	   rep.setCitizens(restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/"+id, List.class));
	  return rep;
		
	}

	@GetMapping
	public List<RequiredResponse> vacwithcitz()
	{
		for(int i=1;i<5;i++)
		{
			RequiredResponse rep1=new RequiredResponse();
	VaccinationCenter vaccinationCenter=vaccinationCenterRepository.findById(i).get();
       rep1.setCenter(vaccinationCenter);
 List<Citizen> cit= restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/name/"+i, List.class);
	
    rep1.setCitizens(cit);
  //  full.add(new RequiredResponse(vaccinationCenter,cit));
     full.add(rep1);	
		}
	return full;
	
	}
}


//U can either create new object or we can pass the parameters with argsconstructor



/*
 *  rep.setCitizens(restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/"+i, ArrayList.class));
  List<Citizen> k=rep.getCitizens();
  full.add(k);
 */




