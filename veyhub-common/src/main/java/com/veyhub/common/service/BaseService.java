package com.veyhub.common.service;

import java.util.Map;

public interface BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {
	
	public TE add(TE entity);
	
	/**
	 * update时，会忽略entity中的null
	 * @param entity
	 * @throws Exception
	 */
	public void updateIgnoreNullProperties(Object sourceObj, T id) throws Exception;

	/**
	 * 完全覆盖
	 * @param entity
	 * @throws Exception
	 */
	public void update(TE sourceEntity) throws Exception;
	
	/**
	 * Map元素类型必须与entity保持一致，否则写不进去，还需要测试 TODO
	 * @param sourceMap
	 * @param id
	 * @throws Exception
	 */
	public void update(Map<String, ?> sourceMap, T id) throws Exception;

	public Iterable<TE> saveAll(Iterable<TE> entities);

	public void deleteAll(Iterable<TE> entities);

	public void delete(T id);
}
