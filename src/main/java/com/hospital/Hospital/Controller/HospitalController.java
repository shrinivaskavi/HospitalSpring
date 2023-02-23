package com.hospital.Hospital.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.Hospital.dao.HospitalDao;
import com.hospital.Hospital.dto.Hospital;

@RestController
public class HospitalController {
	@Autowired
	HospitalDao hosDao;
	
	@PostMapping("/hospital")
	public Hospital saveData(@RequestBody Hospital hospital) {
		return hosDao.saveHospital(hospital);
	}
	@GetMapping("/hospital/{id}")
	public Hospital getHospitalById(@PathVariable int id)
	{
		Optional<Hospital>op=hosDao.getHospitalById(id);
		if(op.isEmpty()) {
			return null;
		}else {
			return op.get();
			
		}
	
	}
	@GetMapping("/hospital")
	public List<Hospital> getAllHospital() {
		return hosDao.getAllHospital();
	}
	@PutMapping("/hospital")
	public Hospital updateHospital(@RequestBody Hospital hos) {
		return hosDao.updateHospital(hos);
	}
	@DeleteMapping("/hospital")
	public String deleteHospital(@RequestParam int id) {
		Optional<Hospital>op=hosDao.getHospitalById(id);
		if(op.isPresent()) {
			hosDao.deletehospital(id);
			return "deleted data";
		}else {
			return"data not found";
		}
	}

}
