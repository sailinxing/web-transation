package com.lixinxin.TestJdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.lixinxin.Utils.C3P0Utils;

public class Dbutils {
	public static void main(String[] args) {
		QueryRunner qr=new QueryRunner();
		Connection conn=C3P0Utils.getConnection();
		String sql1="update user set account=account-1000 where uid=1";
		String sql2="update user set account=account+1000 where uid=2";
		try {
			conn.setAutoCommit(false);
			qr.update(conn, sql1);
//			int i=10/0;
			qr.update(conn,sql2);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
