package com.veyhub.veyproj.info.domain.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.veyhub.veyproj.info.domain.entity.VeyprojPaymentMode;

@Repository
public interface VeyprojPaymentModeRepo extends CrudRepository<VeyprojPaymentMode, Long> {

}
