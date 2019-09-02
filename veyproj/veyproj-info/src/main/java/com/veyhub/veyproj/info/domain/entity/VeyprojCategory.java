package com.veyhub.veyproj.info.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

import com.veyhub.common.domain.entity.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DynamicUpdate
@Getter
@Setter
public class VeyprojCategory extends BaseEntity<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9113454885301564996L;
	@Column(unique = true)
	private String industryType;
}
