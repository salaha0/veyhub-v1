package com.veyhub.example.domain.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.veyhub.example.domain.entity.VeyprojInfo;

@Repository
public interface VeyprojInfoRepo extends CrudRepository<VeyprojInfo, Long> {
	
	public Optional<VeyprojInfo> findByNumber(String number);

}
