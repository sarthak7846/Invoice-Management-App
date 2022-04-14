package com.highradius.sarthak_HRC40407W;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class UpdateInvoice
 */
@WebServlet("/UpdateInvoice")
public class UpdateInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInvoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		//Updated invoice data
		String docID = request.getParameter("docID");
		String invoiceCurrency = request.getParameter("invoiceCurrency");
		String customerPaymentTerms = request.getParameter("customerPaymentTerms");
		
		InvoiceDetailsPOJO updateInvoice = new InvoiceDetailsPOJO();
		updateInvoice.setDocID(Long.parseLong(docID));
		updateInvoice.setInvoiceCurrency(invoiceCurrency);
		updateInvoice.setCustomerPaymentTerms(customerPaymentTerms);
		
		CrudOperations updateData = new CrudOperations();
		HashMap<Object, Object> updateResponseData = new HashMap<Object, Object>();
		try {
			int updateResponseFromDB = updateData.updateData(updateInvoice);
			if(updateResponseFromDB > 0) {
				updateResponseData.put("update", true);
			} else {
				updateResponseData.put("update", false);
			}
			
			Gson gs = new Gson();
			String updateResponseDataJSON = gs.toJson(updateResponseData);
			response.getWriter().append(updateResponseDataJSON);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		response.getWriter().print(invoiceCurrency+" "+customerPaymentTerms+" "+docID);
		
	}

}
