package com.highradius.sarthak_HRC40407W;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class CrudOperations {
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/payment_date_prediction_db";
		String username = "root";
		String pw = "ricky5678";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, pw);

		return con;
	}

	public ArrayList<InvoiceDetailsPOJO> getData() throws SQLException, ClassNotFoundException {
		ArrayList<InvoiceDetailsPOJO> customerList = new ArrayList<InvoiceDetailsPOJO>();
		int id;
		String businessCode;
		String customerNumber;
		String customerName;
		String clearDate;
		int businessYear;
		long docID;
		String postingDate;
		String dueInDate;
		String baselineCreateDate;
		String customerPaymentTerms;
		double convertedUSD;
		String agingBucket;

		String readQuery = "SELECT * FROM hrc40407w_sarthak_kumar_behera";

		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement(readQuery);

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			InvoiceDetailsPOJO pd = new InvoiceDetailsPOJO();
			id = rs.getInt(1);
			businessCode = rs.getString(2);
			customerNumber = rs.getString(3);
			customerName = rs.getString(4);
			clearDate = rs.getString(5);
			businessYear = rs.getInt(6);
			docID = rs.getLong(7);
			postingDate = rs.getString(8);
			dueInDate = rs.getString(9);
			baselineCreateDate = rs.getString(10);
			customerPaymentTerms = rs.getString(11);
			convertedUSD = rs.getDouble(12);
			agingBucket = rs.getString(13);

			pd.setID(id);
			pd.setBusinessCode(businessCode);
			pd.setCustomerNumber(customerNumber);
			pd.setCustomerName(customerName);
			pd.setClearDate(clearDate);
			pd.setBusinessYear(businessYear);
			pd.setDocID(docID);
			pd.setPostingDate(postingDate);
			pd.setDueInDate(dueInDate);
			pd.setBaselineCreateDate(baselineCreateDate);
			pd.setCustomerPaymentTerms(customerPaymentTerms);
			pd.setConvertedUSD(convertedUSD);
			pd.setAgingBucket(agingBucket);
			customerList.add(pd);
		}
		return customerList;
	}

	public int addData(InvoiceDetailsPOJO newEntry) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();

		// Get max no. of entries in the table
		String getMaxID = "SELECT MAX(MyUnknownColumn) FROM hrc40407w_sarthak_kumar_behera";
		int newID;

		PreparedStatement pst = con.prepareStatement(getMaxID);
		ResultSet rs = pst.executeQuery();
		rs.next();
		newID = rs.getInt(1);

		// Firing the Insert Query
		String insertQuery = "insert into hrc40407w_sarthak_kumar_behera (MyUnknownColumn, business_code, cust_number, "
				+ "name_customer, clear_date, buisness_year, doc_id, posting_date, due_in_date, baseline_create_date, "
				+ "cust_payment_terms, converted_usd) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst2 = con.prepareStatement(insertQuery);
		pst2.setInt(1, ++newID);
		pst2.setString(2, newEntry.getBusinessCode());
		pst2.setString(3, newEntry.getCustomerNumber());
		pst2.setString(4, newEntry.getCustomerName());
		pst2.setString(5, newEntry.getClearDate());
		pst2.setInt(6, newEntry.getBusinessYear());
		pst2.setLong(7, newEntry.getDocID());
		pst2.setString(8, newEntry.getPostingDate());
		pst2.setString(9, newEntry.getDueInDate());
		pst2.setString(10, newEntry.getBaselineCreateDate());
		pst2.setString(11, newEntry.getCustomerPaymentTerms());
		pst2.setDouble(12, newEntry.getConvertedUSD());

		return pst2.executeUpdate();
	}
}
