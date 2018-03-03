package com.lixinxin.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.lixinxin.Utils.C3P0Utils;
import com.lixinxin.dao.TransferDao;

public class TransferService {

	public boolean transfer(String outAcc, String inAcc, String amount) {
		boolean result=true;
		TransferDao dao=new TransferDao();
		Connection conn = C3P0Utils.getConnection();
		try {
			conn.setAutoCommit(false);
			dao.inTransfer(conn,inAcc,amount);
//			int i=10/0;
			dao.outTransfer(conn,outAcc,amount);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			result=false;
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}		
		return result;
	}

}
