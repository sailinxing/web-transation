package com.lixinxin.service;


import java.sql.SQLException;

import com.lixinxin.Utils.C3P0Utils;
import com.lixinxin.dao.TransferDao1;

public class TransferService1 {

	public boolean transfer(String outAcc, String inAcc, String amount) {
		boolean result=true;
		TransferDao1 dao=new TransferDao1();
		try {
			C3P0Utils.startTransaction();
			dao.inTransfer(inAcc,amount);
//			int i=10/0;
			dao.outTransfer(outAcc,amount);
			C3P0Utils.commit();
		} catch (Exception e) {
			e.printStackTrace();
			result=false;
			try {
				C3P0Utils.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}		
		return result;
	}

	

}
