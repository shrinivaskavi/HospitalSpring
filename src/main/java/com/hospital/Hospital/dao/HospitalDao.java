package com.hospital.Hospital.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospital.Hospital.Repository.HospitalRepo;
import com.hospital.Hospital.dto.Hospital;
@Repository
public class HospitalDao {
	
	@Autowired
	HospitalRepo hospitalrepo;
	
	public Hospital saveHospital(Hospital hospital)
	{
		return hospitalrepo.save(hospital);
	}
	public Optional<Hospital> getHospitalById(int id)
	{
		return hospitalrepo.findById(id);
	}
	public List<Hospital> getAllHospital() {
		return hospitalrepo.findAll();
	}
	public Hospital updateHospital(Hospital hospital) {
		return hospitalrepo.save(hospital);
	}
	public void deletehospital(int id) {
		hospitalrepo.deleteById(id);
	}
}
