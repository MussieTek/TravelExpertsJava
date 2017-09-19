/**
 * 
 */
package Models;

/**
 * @author 758111
 *
 */

public class Product implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer productId;
	private String prodName;

	public Product() {
	}

	public Product(String prodName) {
		this.prodName = prodName;
	}

	public Product(Integer productId, String prodName) {
		
		this.productId = productId;
		this.prodName = prodName;
	}
	
	
	//getters and setters
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@Override
	public String toString() {
		return productId + " " + prodName;
	}
	
}