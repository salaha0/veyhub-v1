package com.veyhub.veyproj.info.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veyhub.common.service.BaseServiceImpl;
import com.veyhub.veyproj.info.domain.entity.VeyprojPaymentMode;
import com.veyhub.veyproj.info.domain.repo.VeyprojPaymentModeRepo;

@Service("veyprojPaymentModeService")
public class VeyprojPaymentModeServiceImpl extends BaseServiceImpl<VeyprojPaymentMode, Long>
		implements VeyprojPaymentModeService{
	@Autowired
	private VeyprojPaymentModeRepo veyprojPaymentModeRepo;
	
	@Override
	public void init() {
		super.register(veyprojPaymentModeRepo);
	}
	
}
