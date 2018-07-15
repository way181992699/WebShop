package com.hd.service.impl;

import java.util.List;

import com.hd.dao.IMcDao;
import com.hd.dao.impl.McDaoImpl;
import com.hd.model.Mc;
import com.hd.service.IMcService;
import com.hd.util.BasePage;
/**
 * Service 实现类 商品信息
 * @author dpb
 *
 */
public class McServiceImpl implements IMcService {

	IMcDao dao = new McDaoImpl();
	@Override
	public int add(Mc mc) {
		// TODO Auto-generated method stub
		return dao.add(mc);
	}

	@Override
	public int update(Mc mc) {
		// TODO Auto-generated method stub
		return dao.update(mc);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public List<Mc> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}

	@Override
	public Mc queryById(int id) {
		// TODO Auto-generated method stub
		return dao.queryById(id);
	}

	@Override
	public BasePage<Mc> queryPage(Mc mc, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return dao.queryPage(mc, currentPage, pageSize);
	}

}
