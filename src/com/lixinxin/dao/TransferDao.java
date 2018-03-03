package com.lixinxin.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class TransferDao {

	public void inTransfer(Connection conn, String inAcc, String amount) throws SQLException {
		QueryRunner qr=new QueryRunner();
		String sql="update user set account=account+? where uid=?";
		qr.update(conn, sql,amount,inAcc);
	}

	public void outTransfer(Connection conn, String outAcc, String amount) throws SQLException {
		QueryRunner qr=new QueryRunner();
		String sql="update user set account=account-? where uid=?";
		qr.update(conn, sql,amount,outAcc);		
	}



}
