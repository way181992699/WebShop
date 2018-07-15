package com.hd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hd.dao.IMcDao;
import com.hd.model.Mc;
import com.hd.util.BaseDao;
import com.hd.util.BasePage;
import com.hd.util.WebUtil;
/**
 * Dao 实现类 商品信息
 * @author dpb
 *
 */
public class McDaoImpl extends BaseDao implements IMcDao {

	private String sql;

	@Override
	public int add(Mc mc) {
		sql = "insert into t_mc(mcid,mcname,mcdecx,price,pic,flag,smalltypeid,createdate,quantity)values(seq_t_mc.nextval,?,?,?,?,?,?,sysdate,?)";
		return super.baseUpdate(sql, mc.getMcname(),mc.getMcdecx(),mc.getPrice(),mc.getPic(),mc.getFlag(),mc.getSmalltypeid(),mc.getQuantity());
	}

	@Override
	public int update(Mc mc) {
		sql = "update t_mc set mcname=?,mcdecx=?,price=?,pic=?,flag=?,smalltypeid=?,quantity=? where mcid=?";
		return super.baseUpdate(sql, mc.getMcname(),mc.getMcdecx(),mc.getPrice(),mc.getPic(),mc.getFlag(),mc.getSmalltypeid(),mc.getQuantity(),mc.getMcid());
	}

	@Override
	public int delete(int id) {
		sql = " delete from t_mc where mcid = ? ";
		return super.baseUpdate(sql, id);
	}

	@Override
	public List<Mc> queryAll() {
		sql = " select * from t_mc ";
		return super.baseQuery(sql, Mc.class);
	}

	@Override
	public Mc queryById(int id) {
		sql = " select * from t_mc where mcid = ? ";
		return super.baseQueryById(sql, Mc.class, id);
	}

	@Override
	public BasePage<Mc> queryPage(Mc mc, int currentPage, int pageSize) {
		// select * from t_mc where 1=1 and mcname like '%abc%'
		// select count(1) from t_mc where 1=1 and mcname like '%abc%'
		StringBuilder countSql = new StringBuilder("select count(1) from t_mc where 1=1 ");
		StringBuilder querySql = new StringBuilder(" select * from t_mc where 1=1 ");
		StringBuilder whereSql = new StringBuilder();
		StringBuilder otherSql = new StringBuilder();
		// 保存sql中占位符对应的参数的
		List<Object> list = new ArrayList<>();
		
		// 添加查询条件
		if(mc != null){
			if(!WebUtil.isEmpty(mc.getMcname())){
				// 表示查询需要根据商品名称模糊查询
				whereSql.append(" and mcname like ? ");
				// 将占位符中的值保存到集合中
				list.add("%"+mc.getMcname()+"%");
			}
		}
		
		return super.queryByPage(countSql, querySql, whereSql, otherSql, pageSize, currentPage, Mc.class, list);
	}

}
