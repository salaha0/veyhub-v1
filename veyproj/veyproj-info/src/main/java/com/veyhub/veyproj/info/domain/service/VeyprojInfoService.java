package com.veyhub.veyproj.info.domain.service;

import java.util.Map;
import java.util.Optional;

import com.veyhub.veyproj.info.domain.entity.VeyprojInfo;

public interface VeyprojInfoService{

	public void add(VeyprojInfo veyprojInfo) throws Exception;

	public void updateIgnoreNullProperties(Object sourceVeyprojInfo, Long id) throws Exception;

	public void update(VeyprojInfo sourceVeyprojInfo) throws Exception;

	/**
	 * Map元素类型必须与entity保持一致，否则写不进去，还需要测试
	 * @param sourceVeyprojInfo
	 * @param id
	 * @throws Exception
	 */
	public void update(Map<String, ?> sourceVeyprojInfo, Long id) throws Exception;

	public void deleteById(Long veyprojInfoId);

	public Optional<VeyprojInfo> findById(Long veyprojInfoId);

	public Optional<VeyprojInfo> findByNum(String veyprojInfoNum);

}
