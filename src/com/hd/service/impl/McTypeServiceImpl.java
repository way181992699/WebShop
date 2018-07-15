package com.hd.service.impl;

import java.util.List;

import com.hd.dao.IMcTypeDao;
import com.hd.dao.impl.McTypeDaoImpl;
import com.hd.model.McType;
import com.hd.service.IMcTypeService;
/**
 * Service实现类 商品类别
 * @author dpb
 *
 */
public class McTypeServiceImpl implements IMcTypeService {

	// 获取商品类别dao中的实现类对象
	IMcTypeDao dao = new McTypeDaoImpl();
	
	@Override
	public int add(McType type) {
		// TODO Auto-generated method stub
		return dao.add(type);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public int update(McType type) {
		// TODO Auto-generated method stub
		return dao.update(type);
	}

	@Override
	public List<McType> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}

	@Override
	public McType queryById(int id) {
		// TODO Auto-generated method stub
		return dao.queryById(id);
	}

	@Override
	public List<McType> queryFather() {
		// TODO Auto-generated method stub
		return dao.queryFather();
	}

	@Override
	public List<McType> queryByFatherId(int id) {
		// TODO Auto-generated method stub
		return dao.queryByFatherId(id);
	}

}
