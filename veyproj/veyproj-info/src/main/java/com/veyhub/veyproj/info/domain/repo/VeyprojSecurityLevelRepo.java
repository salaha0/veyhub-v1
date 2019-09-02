package com.veyhub.veyproj.info.domain.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.veyhub.veyproj.info.domain.entity.VeyprojSecurityLevel;

@Repository
public interface VeyprojSecurityLevelRepo extends CrudRepository<VeyprojSecurityLevel, Long> {

}
