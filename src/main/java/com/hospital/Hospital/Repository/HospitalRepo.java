package com.hospital.Hospital.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.Hospital.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer> {

}
