package com.veyhub.veyproj.bidding.domain.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veyhub.common.util.BeanCopyUtil;
import com.veyhub.veyproj.bidding.domain.entity.VeyprojInfo;
import com.veyhub.veyproj.bidding.domain.repo.VeyprojInfoRepo;

@Service("veyprojInfoService")
public class VeyprojInfoServiceImpl implements VeyprojInfoService {
	private static final Logger logger = LoggerFactory.getLogger(VeyprojInfoServiceImpl.class);
	@Autowired
	private VeyprojInfoRepo veyprojInfoRepo;

	@Override
	public void add(VeyprojInfo veyprojInfo) throws Exception {
		if (veyprojInfo.getId() != null) {
			throw new Exception("add an entity while id was given");
		}
		veyprojInfoRepo.save(veyprojInfo);
	}

	@Override
	public void updateIgnoreNullProperties(Object sourceVeyprojInfo, Long id) throws Exception {
		Optional<VeyprojInfo> entity = veyprojInfoRepo.findById(id);
		entity.ifPresent(t->{
			BeanCopyUtil.beanCopy(sourceVeyprojInfo, t);
			veyprojInfoRepo.save(t);
		});
	}
	
	@Override
	public void update(VeyprojInfo sourceVeyprojInfo) throws Exception {
		if (!veyprojInfoRepo.existsById(sourceVeyprojInfo.getId())) {
			throw new Exception("update entity while id not exists.");
		}
		veyprojInfoRepo.save(sourceVeyprojInfo);
	}

	@Override
	public void update(Map<String, ?> sourceVeyprojInfo, Long id) throws Exception {
		Optional<VeyprojInfo> veyprojInfo = veyprojInfoRepo.findById(id);
		veyprojInfo.ifPresent(t->{
				try {
					//TODO 存在问题：当sourceMap中的数值类型与entity不一致，不能写入，可能要通过ConvertUtils配置，太麻烦
					BeanUtils.populate(t, sourceVeyprojInfo);
				} catch (IllegalAccessException | InvocationTargetException e) {
					logger.error(e.getMessage(), e);
				}
				veyprojInfoRepo.save(t);
		});
	}

	@Override
	public void deleteById(Long veyprojInfoId) {
		veyprojInfoRepo.deleteById(veyprojInfoId);
	}

	@Override
	public Optional<VeyprojInfo> findById(Long veyprojInfoId) {
		return veyprojInfoRepo.findById(veyprojInfoId);
	}

	@Override
	public Optional<VeyprojInfo> findByNum(String veyprojInfoNum) {
		return veyprojInfoRepo.findByNumber(veyprojInfoNum);
	}

}
