package com.veyhub.veyproj.info.domain.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.veyhub.veyproj.info.domain.entity.VeyprojCategory;

@Repository
public interface VeyprojCategoryRepo extends CrudRepository<VeyprojCategory, Long> {

}
