package com.lixinxin.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.lixinxin.Utils.C3P0Utils;

public class TransferDao1 {

	public void outTransfer(String outAcc, String amount) throws SQLException {
		QueryRunner qr=new QueryRunner();
		String sql="update user set account=account-? where uid=?";
		qr.update(C3P0Utils.getCurrentConnection(), sql,amount,outAcc);
	}

	public void inTransfer(String inAcc, String amount) throws SQLException {
		QueryRunner qr=new QueryRunner();
		String sql="update user set account=account+? where uid=?";
		qr.update(C3P0Utils.getCurrentConnection(), sql,amount,inAcc);
	}

}
