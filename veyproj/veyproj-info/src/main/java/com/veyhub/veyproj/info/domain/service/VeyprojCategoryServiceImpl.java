package com.veyhub.veyproj.info.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veyhub.common.service.BaseServiceImpl;
import com.veyhub.veyproj.info.domain.entity.VeyprojCategory;
import com.veyhub.veyproj.info.domain.repo.VeyprojCategoryRepo;

@Service("veyprojCategoryService")
public class VeyprojCategoryServiceImpl extends BaseServiceImpl<VeyprojCategory, Long>
		implements VeyprojCategoryService {
	@Autowired
	private VeyprojCategoryRepo veyprojCategoryRepo;

	@Override
	public void init() {
		super.register(veyprojCategoryRepo);
	}

}
