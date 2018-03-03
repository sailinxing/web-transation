package com.lixinxin.TestJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		PreparedStatement psttm1 = null;
		PreparedStatement psttm2 = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql:///day17", "root", "123");
			String sql1 = "update user set account=account+1000 where uid=1";
			String sql2 = "update user set account=account-1000 where uid=2";
			psttm1 = conn.prepareStatement(sql1);
			psttm2 = conn.prepareStatement(sql2);
			conn.setAutoCommit(false);
			psttm1.executeUpdate();
//			int i = 10 / 0;
//			System.out.println(i);
			psttm2.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally {
			try {
				conn.close();
				psttm1.close();
				psttm2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
}
