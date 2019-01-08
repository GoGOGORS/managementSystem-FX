package application.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import application.main.Vitamin;

public class UpdateTableData {

	private final String username = "root"; 
	private final String password = "root"; 
	private final String url =
			"jdbc:mysql://localhost:3306/t?useUnicode=true&usecharsetEncoding=utf8";
	private Connection conn = null; 
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/**
	 * 修改名称
	 */
	public void UpdateName(int id ,String name) {
		try {
			conn = jdbcUtil.getConnection(username, password, url);
			String sql = "update vitamin set name = ? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, id);
			System.out.println("UpdateName   " + name);
			
			int a = ps.executeUpdate();
			System.out.println(a);
			System.out.println("执行成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, ps, rs);
		}
	}
	
	/**
	 * 修改价格
	 */
	public void UpdatePrice(int id ,String price) {
		try {
			conn = jdbcUtil.getConnection(username, password, url);
			String sql = "update vitamin set Price = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, price);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, ps, rs);
		}
	}
	
	/**
	 * 修改重量
	 */
	public void UpdateWeight(int id ,String weight) {
		try {
			conn = jdbcUtil.getConnection(username, password, url);
			String sql = "update vitamin set Weight = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, weight);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, ps, rs);
		}
	}
	
	/**
	 * 修改类型
	 */
	public void UpdateType(int id ,String type) {
		try {
			conn = jdbcUtil.getConnection(username, password, url);
			String sql = "update vitamin set Type = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, ps, rs);
		}
	}
	
	/**
	 * 修改来源
	 */
	public void UpdateSource(int id ,String source) {
		try {
			conn = jdbcUtil.getConnection(username, password, url);
			String sql = "update vitamin set Source = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, source);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, ps, rs);
		}
	}
	
	/**
	 * 根据id删除
	 */
	public void DeleteById(int id) {
		try {
			conn = jdbcUtil.getConnection(username, password, url);
			String sql = "delete from vitamin where id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, ps, rs);
		}
	}
	
	/**
	 * 根据输入的商品名称查询数据
	 */
	public List<Vitamin> SearchByName(String inputName) {
		try {
			conn = jdbcUtil.getConnection(username, password, url);
			String sql = "select * from vitamin where name like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + inputName + "%");
			rs = ps.executeQuery();
			List<Vitamin> vlist = new ArrayList<>();
			while(rs.next()) {
				Vitamin v = new Vitamin();
				v.setId(rs.getInt("Id"));
				v.setName(rs.getString("Name"));
				v.setPraise(rs.getString("Praise"));
				v.setPrice(rs.getString("Price"));
				v.setCommonly(rs.getString("Commonly"));
				v.setComponent(rs.getString("Component"));
				v.setWeight(rs.getString("Weight"));
				v.setNegative(rs.getString("Negativecomment"));
				v.setApply(rs.getString("Apply"));
				v.setSource(rs.getString("Source"));
				v.setType(rs.getString("Type"));
				vlist.add(v);
			}
			return vlist;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, ps, rs);
		}
		return null;
	}
}
