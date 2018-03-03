package com.lixinxin.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lixinxin.service.TransferService1;

public class TransferServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String outAcc = request.getParameter("outAcc");
		String inAcc = request.getParameter("inAcc");
		String amount = request.getParameter("amount");
		TransferService1 service=new TransferService1();
		boolean result=service.transfer(outAcc, inAcc, amount);
		request.setAttribute("result",result);
		request.getRequestDispatcher("/transfer.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}