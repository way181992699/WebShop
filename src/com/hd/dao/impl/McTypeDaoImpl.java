package com.hd.dao.impl;

import java.util.List;

import com.hd.dao.IMcTypeDao;
import com.hd.model.McType;
import com.hd.util.BaseDao;

/**
 * Dao实现类  商品类别
 * @author dpb
 *
 */
public class McTypeDaoImpl extends BaseDao implements IMcTypeDao {

	private String sql;

	@Override
	public int add(McType type) {
		sql = " insert into t_mctype(typeid,typename,fatherid) values(seq_t_mctype.nextval,?,?)";
		return super.baseUpdate(sql, type.getTypename(),type.getFatherid());
	}

	@Override
	public int delete(int id) {
		// 删除大类同时删除相关小类
		sql = " delete from t_mctype where typeid = ? or fatherid = ? ";
		return super.baseUpdate(sql, id,id);
	}

	@Override
	public int update(McType type) {
		sql = " update t_mctype set typename=? , fatherid=? where typeid = ? ";
		return super.baseUpdate(sql, type.getTypename(),type.getFatherid(),type.getTypeid());
	}

	@Override
	public List<McType> queryAll() {
		sql = " select * from t_mctype";
		return super.baseQuery(sql, McType.class);
	}

	@Override
	public McType queryById(int id) {
		sql = " select * from t_mctype where typeid = ?";
		return super.baseQueryById(sql, McType.class, id);
	}

	@Override
	public List<McType> queryFather() {
		sql =" select * from t_mctype where fatherid = 0 ";
		return super.baseQuery(sql, McType.class);
	}

	@Override
	public List<McType> queryByFatherId(int id) {
		sql =" select * from t_mctype where fatherid = ? ";
		return super.baseQuery(sql, McType.class, id);
	}

}
