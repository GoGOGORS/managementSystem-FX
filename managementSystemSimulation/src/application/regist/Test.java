package application.regist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import application.main.Vitamin;
import application.util.jdbcUtil;

public class Test {
 
	
	
	public static void main(String[] args) {
		 Connection conn = null; 
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 String username = "root"; 
		 String password = "root"; 
		 String url =
					"jdbc:mysql://localhost:3306/t?useUnicode=true&usecharsetEncoding=utf8";
		try {
			String name2 = "百";
			conn = jdbcUtil.getConnection(username, password, url);
			String sql = "select * from vitamin where name like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+name2+"%");
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
			
			vlist.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, ps, rs);
		}
	}
}
