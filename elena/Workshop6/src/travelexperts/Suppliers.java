package travelexperts;

// default package
// Generated 29-Aug-2017 10:13:16 AM by Hibernate Tools 5.2.5.Final

/**
 * Suppliers generated by hbm2java
 */
public class Suppliers implements java.io.Serializable {

	private int supplierId;
	private String supName;

	public Suppliers() {
	}

	public Suppliers(int supplierId) {
		this.supplierId = supplierId;
	}

	public Suppliers(int supplierId, String supName) {
		this.supplierId = supplierId;
		this.supName = supName;
	}

	public int getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupName() {
		return this.supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

}
