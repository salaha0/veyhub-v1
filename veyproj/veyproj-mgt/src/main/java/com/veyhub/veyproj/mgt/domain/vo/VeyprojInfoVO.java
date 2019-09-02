package com.veyhub.veyproj.mgt.domain.vo;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeyprojInfoVO {
	private Long id;
    private String name;
	private Long createrId;
	private Long categoryId;
	private String desp;
	private String demands;
	private Date deadline;
	private Long securityLevel;
	private BigDecimal paymentAmount;
	private Long paymentMode;
}
