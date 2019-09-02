package com.veyhub.common.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;

import com.veyhub.common.util.BeanCopyUtil;

public abstract class BaseServiceImpl<TE extends com.veyhub.common.domain.entity.BaseEntity<T>, T> extends ReadOnlyBaseServiceImpl<TE, T> implements BaseService<TE, T> {
	private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
	private CrudRepository<TE, T> _repository;

	@PostConstruct
	public abstract void init();
	
    public void register(CrudRepository<TE, T> repository) {
        _repository = repository;
    }
	
	public TE add(TE entity) {
		return _repository.save(entity);
	}

	public void updateIgnoreNullProperties(Object sourceObj, T id) throws Exception {
		Optional<TE> entity = _repository.findById(id);
		entity.ifPresent(t->{
			BeanCopyUtil.beanCopy(sourceObj, t);
			_repository.save(t);
		});
	}

	public void update(TE sourceEntity) throws Exception {
		if (!_repository.existsById(sourceEntity.getId())) {
			throw new Exception("update entity while id not exists.");
		}
		_repository.save(sourceEntity);
	}
	
	public void update(Map<String, ?> sourceMap, T id) throws Exception {
		Optional<TE> entity = _repository.findById(id);
		entity.ifPresent(t->{
				try {
					//TODO 存在问题：当sourceMap中的数�?�类型与entity不一致，不能写入，可能要通过ConvertUtils配置，太麻烦
					BeanUtils.populate(t, sourceMap);
				} catch (IllegalAccessException | InvocationTargetException e) {
					logger.error(e.getMessage(), e);
				}
				_repository.save(t);
		});
	}
	
	public Iterable<TE> saveAll(Iterable<TE> entities) {
		return _repository.saveAll(entities);
	}

	public void deleteAll(Iterable<TE> entities) {
		_repository.deleteAll(entities);
	}

	public void delete(T id) {
		_repository.deleteById(id);
	}
}
