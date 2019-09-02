package com.veyhub.veyproj.info.domain.entity;

import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

import com.veyhub.common.domain.entity.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DynamicUpdate
@Getter
@Setter
public class VeyprojPaymentMode extends BaseEntity<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6641839858881575007L;
	private String desp;
}
