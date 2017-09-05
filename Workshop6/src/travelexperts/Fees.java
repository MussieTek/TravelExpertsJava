package travelexperts;

// default package
// Generated 29-Aug-2017 10:13:16 AM by Hibernate Tools 5.2.5.Final

import java.math.BigDecimal;

/**
 * Fees generated by hbm2java
 */
public class Fees implements java.io.Serializable {

	private String feeId;
	private String feeName;
	private BigDecimal feeAmt;
	private String feeDesc;

	public Fees() {
	}

	public Fees(String feeId, String feeName, BigDecimal feeAmt) {
		this.feeId = feeId;
		this.feeName = feeName;
		this.feeAmt = feeAmt;
	}

	public Fees(String feeId, String feeName, BigDecimal feeAmt, String feeDesc) {
		this.feeId = feeId;
		this.feeName = feeName;
		this.feeAmt = feeAmt;
		this.feeDesc = feeDesc;
	}

	public String getFeeId() {
		return this.feeId;
	}

	public void setFeeId(String feeId) {
		this.feeId = feeId;
	}

	public String getFeeName() {
		return this.feeName;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	public BigDecimal getFeeAmt() {
		return this.feeAmt;
	}

	public void setFeeAmt(BigDecimal feeAmt) {
		this.feeAmt = feeAmt;
	}

	public String getFeeDesc() {
		return this.feeDesc;
	}

	public void setFeeDesc(String feeDesc) {
		this.feeDesc = feeDesc;
	}

}
