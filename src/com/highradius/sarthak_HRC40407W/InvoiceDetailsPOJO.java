package com.highradius.sarthak_HRC40407W;

//PaymentDate POJO

public class InvoiceDetailsPOJO {
	private int id;
	private String BusinessCode;
	private String CustomerNumber;
	private String CustomerName;
	private String ClearDate;
	private int BusinessYear;
	private long DocID;
	private String PostingDate;
	private String DueInDate;
	private String BaselineCreateDate;
	private String CustomerPaymentTerms;
	private double ConvertedUSD;
	private String AgingBucket;

	public int getID() {
		return id;
	}

	public void setID(int iD) {
		id = ++iD;
	}

	public String getBusinessCode() {
		return BusinessCode;
	}

	public void setBusinessCode(String businessCode) {
		BusinessCode = businessCode;
	}

	public String getCustomerNumber() {
		return CustomerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		CustomerNumber = customerNumber;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getClearDate() {
		return ClearDate;
	}

	public void setClearDate(String clearDate) {
		String[] clearDateReduced = clearDate.split(" ");
		ClearDate = clearDateReduced[0];
	}

	public int getBusinessYear() {
		return BusinessYear;
	}

	public void setBusinessYear(int businessYear) {
		BusinessYear = businessYear;
	}

	public long getDocID() {
		return DocID;
	}

	public void setDocID(long docID) {
		DocID = docID;
	}

	public String getPostingDate() {
		return PostingDate;
	}

	public void setPostingDate(String postingDate) {
		String[] postingDateReduced = postingDate.split(" ");
		PostingDate = postingDateReduced[0];
	}

	public String getDueInDate() {
		return DueInDate;
	}

	public void setDueInDate(String dueInDate) {
		String[] dueInDateReduced = dueInDate.split(" ");
		DueInDate = dueInDateReduced[0];
	}

	public String getBaselineCreateDate() {
		return BaselineCreateDate;
	}

	public void setBaselineCreateDate(String baselineCreateDate) {
		String[] baselineCreateDateReduced = baselineCreateDate.split(" ");
		BaselineCreateDate = baselineCreateDateReduced[0];
	}

	public String getCustomerPaymentTerms() {
		return CustomerPaymentTerms;
	}

	public void setCustomerPaymentTerms(String customerPaymentTerms) {
		CustomerPaymentTerms = customerPaymentTerms;
	}

	public double getConvertedUSD() {
		return ConvertedUSD;
	}

	public void setConvertedUSD(double convertedUSD) {
		String cUSD = String.format("%.2f", convertedUSD);
		Double dUSD = Double.parseDouble(cUSD);
		ConvertedUSD = dUSD;
	}

	public String getAgingBucket() {
		return AgingBucket;
	}

	public void setAgingBucket(String agingBucket) {
		AgingBucket = agingBucket;
	}

	@Override
	public String toString() {
		return "PaymentDate [ID=" + id + ", BusinessCode=" + BusinessCode + ", CustomerNumber=" + CustomerNumber
				+ ", CustomerName=" + CustomerName + ", ClearDate=" + ClearDate + ", BusinessYear=" + BusinessYear
				+ ", DocID=" + DocID + ", PostingDate=" + PostingDate + ", DueInDate=" + DueInDate
				+ ", BaselineCreateDate=" + BaselineCreateDate + ", CustomerPaymentTerms=" + CustomerPaymentTerms
				+ ", ConvertedUSD=" + ConvertedUSD + ", AgingBucket=" + AgingBucket + "]";
	}
}
