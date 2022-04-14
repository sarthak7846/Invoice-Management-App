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
 * Servlet implementation class DeleteInvoice
 */
@WebServlet("/DeleteInvoice")
public class DeleteInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteInvoice() {
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
		String docID = request.getParameter("docID");
//		response.getWriter().print("docID "+docID);
		InvoiceDetailsPOJO delIInvoice = new InvoiceDetailsPOJO();
		delIInvoice.setDocID(Long.parseLong(docID));
		
		CrudOperations deleteData = new CrudOperations();
		HashMap<Object, Object> deleteResponseData = new HashMap<Object, Object>();
		try {
			int deleteResponseFromDB = deleteData.deleteData(delIInvoice);
			if(deleteResponseFromDB > 0) {
				deleteResponseData.put("delete", true);
			} else {
				deleteResponseData.put("delete", false);
			}
			
			Gson gs = new Gson();
			String deleteResponseDataJSON = gs.toJson(deleteResponseData);
			response.getWriter().append(deleteResponseDataJSON);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
