package com.veyhub.example.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.veyhub.common.domain.entity.BaseEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@DynamicUpdate
@SelectBeforeUpdate
@Getter
@Setter
@Accessors(chain = true)
public class VeyprojInfo extends BaseEntity<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1972083400625520890L;
    private String name;
	@Column(unique = true)
	private String number;
	private Long createrId;
	private Long ownerId;
	private Long categoryId;
	private String desp;
	private String demands;
	private Date deadline;
	private Long securityLevel;
	private BigDecimal paymentAmount;
	private Long paymentMode;
}
