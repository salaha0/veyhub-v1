package com.veyhub.common.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@EntityListeners(AuditingEntityListener.class)
@Where(clause = "status != -1")
@Getter
@Setter
@Accessors(chain = true)
@MappedSuperclass
public abstract class BaseEntity<T> implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1499695318050612305L;
	/**
     * 全局统一状态：正常、成功状态；其他业务状态需自行定义
     */
    public static final int STATUS_OK = 0;  
    /**
     * 全局统一状态：已删除状态
     */
    public static final int STATUS_DELETED = -1; 

    @Id
    @GeneratedValue
    private T id;
    private Integer status;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
}
