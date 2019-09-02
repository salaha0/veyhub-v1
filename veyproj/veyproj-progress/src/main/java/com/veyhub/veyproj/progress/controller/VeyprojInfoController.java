package com.veyhub.veyproj.progress.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veyhub.veyproj.progress.domain.entity.VeyprojInfo;
import com.veyhub.veyproj.progress.domain.service.VeyprojInfoService;
import com.veyhub.veyproj.progress.domain.vo.VeyprojInfoVO;

@RestController
@RequestMapping("/v1/veyproj/info")
public class VeyprojInfoController {
	private static final Logger logger = LoggerFactory.getLogger(VeyprojInfoController.class);
	@Autowired
	private VeyprojInfoService veyprojInfoService;

	@PostMapping("/add")
	public ResponseEntity<VeyprojInfo> add(@RequestBody VeyprojInfoVO veyprojInfoVO) {
		logger.info("add {}", veyprojInfoVO.getName());
		VeyprojInfo veyprojInfo = new VeyprojInfo();
		BeanUtils.copyProperties(veyprojInfoVO, veyprojInfo);
		try {
			veyprojInfoService.add(veyprojInfo);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/update")
	public ResponseEntity<VeyprojInfo> update(@RequestBody VeyprojInfoVO veyprojInfoVO) {
		Long id = veyprojInfoVO.getId();
		logger.info("update entity {}", id);

		try {
			veyprojInfoService.updateIgnoreNullProperties(veyprojInfoVO, id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
