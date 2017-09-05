package travelexperts;

// default package
// Generated 29-Aug-2017 10:13:16 AM by Hibernate Tools 5.2.5.Final

import java.math.BigDecimal;
import java.util.Date;

/**
 * Packages generated by hbm2java
 */
public class Packages implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer packageId;
	private String pkgName;
	private Date pkgStartDate;
	private Date pkgEndDate;
	private String pkgDesc;
	private BigDecimal pkgBasePrice;
	private BigDecimal pkgAgencyCommission;

	public Packages() {
	}

	public Packages(String pkgName, BigDecimal pkgBasePrice) {
		this.pkgName = pkgName;
		this.pkgBasePrice = pkgBasePrice;
	}

	public Packages(String pkgName, Date pkgStartDate, Date pkgEndDate, String pkgDesc, BigDecimal pkgBasePrice,
			BigDecimal pkgAgencyCommission) {
		this.pkgName = pkgName;
		this.pkgStartDate = pkgStartDate;
		this.pkgEndDate = pkgEndDate;
		this.pkgDesc = pkgDesc;
		this.pkgBasePrice = pkgBasePrice;
		this.pkgAgencyCommission = pkgAgencyCommission;
	}

	public Integer getPackageId() {
		return this.packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getPkgName() {
		return this.pkgName;
	}

	public void setPkgName(String pkgName) {
		this.pkgName = pkgName;
	}

	public Date getPkgStartDate() {
		return this.pkgStartDate;
	}

	public void setPkgStartDate(Date pkgStartDate) {
		this.pkgStartDate = pkgStartDate;
	}

	public Date getPkgEndDate() {
		return this.pkgEndDate;
	}

	public void setPkgEndDate(Date pkgEndDate) {
		this.pkgEndDate = pkgEndDate;
	}

	public String getPkgDesc() {
		return this.pkgDesc;
	}

	public void setPkgDesc(String pkgDesc) {
		this.pkgDesc = pkgDesc;
	}

	public BigDecimal getPkgBasePrice() {
		return this.pkgBasePrice;
	}

	public void setPkgBasePrice(BigDecimal pkgBasePrice) {
		this.pkgBasePrice = pkgBasePrice;
	}

	public BigDecimal getPkgAgencyCommission() {
		return this.pkgAgencyCommission;
	}

	public void setPkgAgencyCommission(BigDecimal pkgAgencyCommission) {
		this.pkgAgencyCommission = pkgAgencyCommission;
	}

}