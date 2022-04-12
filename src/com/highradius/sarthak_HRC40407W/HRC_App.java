package com.highradius.sarthak_HRC40407W;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class HRC_Db
 */
@WebServlet("/HRC_App")
public class HRC_App extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HRC_App() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CrudOperations fetchData = new CrudOperations();
		try {
			ArrayList<InvoiceDetailsPOJO> customerList = fetchData.getData();

			Gson gson = new Gson();
			String responseData = gson.toJson(customerList);
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.getWriter().append(responseData);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
//		response.getWriter().print("You're good to go!");

		// New invoice data
		String businessCode = request.getParameter("BusinessCode");
		String customerNumber = request.getParameter("CustomerNumber");
		String customerName = request.getParameter("CustomerName");
		String clearDate = request.getParameter("ClearDate");
		int businessYear = Integer.parseInt(request.getParameter("BusinessYear"));
		long docID = Long.parseLong(request.getParameter("DocumentID"));
		String postingDate = request.getParameter("PostingDate");
		String dueInDate = request.getParameter("DueInDate");
		String baselineCreateDate = request.getParameter("BaselineDate");
		String customerPaymentTerms = request.getParameter("CustomerPaymentTerms");
		double convertedUSD = Double.parseDouble(request.getParameter("ConvertedUSD"));

		InvoiceDetailsPOJO newEntry = new InvoiceDetailsPOJO();
		newEntry.setBusinessCode(businessCode);
		newEntry.setCustomerNumber(customerNumber);
		newEntry.setCustomerName(customerName);
		newEntry.setClearDate(clearDate);
		newEntry.setBusinessYear(businessYear);
		newEntry.setDocID(docID);
		newEntry.setPostingDate(postingDate);
		newEntry.setDueInDate(dueInDate);
		newEntry.setBaselineCreateDate(baselineCreateDate);
		newEntry.setCustomerPaymentTerms(customerPaymentTerms);
		newEntry.setConvertedUSD(convertedUSD);

		HashMap<Object, Object> responseData = new HashMap<Object, Object>();

		CrudOperations pd = new CrudOperations();
		try {
			int responseFromDB = pd.addData(newEntry);
			if (responseFromDB > 0) {
				responseData.put("insert", true);
			} else {
				responseData.put("insert", false);
			}

			Gson gs = new Gson();
			String responseDataJSON = gs.toJson(responseData);
			response.getWriter().append(responseDataJSON);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
