package com.veyhub.veyproj.info.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veyhub.common.service.BaseServiceImpl;
import com.veyhub.veyproj.info.domain.entity.VeyprojSecurityLevel;
import com.veyhub.veyproj.info.domain.repo.VeyprojSecurityLevelRepo;

@Service("veyprojSecurityLevelService")
public class VeyprojSecurityLevelServiceImpl extends BaseServiceImpl<VeyprojSecurityLevel, Long>
		implements VeyprojSecurityLevelService{
	@Autowired
	private VeyprojSecurityLevelRepo veyprojSecurityLevelRepo;
	
	@Override
	public void init() {
		super.register(veyprojSecurityLevelRepo);
	}
	
}
