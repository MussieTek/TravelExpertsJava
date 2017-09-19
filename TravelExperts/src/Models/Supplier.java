package Models;

import java.io.Serializable;


/**
 * @author 754967
 * 
 */

public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	private int supplierId;

	private String supName;

	public Supplier() {
	}

	/**
	 * @param supName
	 */
	public Supplier(String supName) {
		super();
		this.supName = supName;
	}

	/**
	 * @param supplierId
	 */
	public Supplier(int supplierId) {
		super();
		this.supplierId = supplierId;
	}

	/**
	 * @param supplierId
	 * @param supName
	 */
	public Supplier(int supplierId, String supName) {
		super();
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

	@Override
	public String toString() {
		return supplierId + " " + supName;
	}
	
	

}