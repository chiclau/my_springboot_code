package com.liu.springboot;

import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 1.查询方式:全查,封装格式为List嵌套Map的形式
	 */
	public List<Map<String, Object>> getListForMap(){
		String sql = "select * from goods";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list;
	}
	
	/**
	 * 2.查询方式:按条件查询,封装的格式为List嵌套Map的形式
	 */
	public List<Map<String, Object>> getListForCondition(String goods_name,int goods_num){
		String sql = "select * from goods where goods_name = ? and goods_num = ?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,new Object[]{goods_name,goods_num});
		return list;
	}
	
	/**
	 * 3.查询方式:全查,封装格式为List嵌套实体类
	 * 注意:RowMapper表示数据库中的,列名和值之间的映射关系,会自动完成便利封装
	 */
	public List<Goods> getListForGoods(){
		String sql = "select * from goods";
		RowMapper<Goods> rowMapper = new BeanPropertyRowMapper<Goods>(Goods.class);
		List<Goods> list = jdbcTemplate.query(sql, rowMapper);
		return list;
	}
	
	/**
	 * 4.查询方式:按条件查询,封装格式为List嵌套实体类
	 * 注意:关于两种封装方式:List<Goods>形式的,只针对单一表的操作;List<Map<String,Object>>,针对多表操作,map中的key值就是数据库查询结果的列名
	 */
	public List<Goods> getListForGoodsCondition(String goods_name){
		String sql = "select * from goods where goods_name = ?";
		RowMapper<Goods> rowMapper = new BeanPropertyRowMapper<Goods>(Goods.class);
		List<Goods> list = jdbcTemplate.query(sql, rowMapper,new Object[]{goods_name});
		return list;
	}
	
	/**
	 * 5.查询方式:全查,特殊处理,通过RowMapper接口的匿名内部类来实现功能
	 */
	public List<Goods> getListBySp(){
		String sql = "select * from goods";
		//----------start
		RowMapper<Goods> rowMapper = new RowMapper<Goods>() {

			@Override
			public Goods mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Goods goods = new Goods();
				goods.setGoods_id(rs.getString("goods_id"));
				goods.setGoods_name(rs.getString("goods_name"));
				goods.setGoods_num(rs.getInt("goods_num"));
				return goods;
			}
			
		};
		//-----------end
		List<Goods> list = jdbcTemplate.query(sql, rowMapper);
		return list;
	}

	/**
	 * 6.查询单一实体类,按条件查询
	 */
	public Goods getGoodsEntity(String goods_id){
		String sql = "select * from goods where goods_id = ?";
		RowMapper<Goods> rowMapper = new BeanPropertyRowMapper<Goods>(Goods.class);
		Goods goods = jdbcTemplate.queryForObject(sql, rowMapper,new Object[]{goods_id});
		return goods;
	}
	
	/**
	 * 7.新增操作
	 * @param goods
	 */
	public void insertGoods(Goods goods){
		String sql = "insert into goods (goods_id,goods_name,goods_num) values (?,?,?)";
		jdbcTemplate.update(sql,new Object[]{goods.getGoods_id(),goods.getGoods_name(),goods.getGoods_num()});
	}
	
	/**
	 * 8.修改操作
	 * @param goods
	 */
	public void updateGoods(Goods goods){
		String sql = "update goods set goods_name = ?,goods_num = ? where goods_id = ?";
		jdbcTemplate.update(sql,new Object[]{goods.getGoods_name(),goods.getGoods_num(),goods.getGoods_id()});
	}
	
	public void delGoods(String goods_id){
		String sql = "delete from goods where goods_id = ?";
		jdbcTemplate.update(sql,new Object[]{goods_id});
	}
}
