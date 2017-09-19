/**
 * 
 */
package Models;

/**
 * @author 758111
 *
 */

public class Customer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer customerId;
	private String custFirstName;
	private String custLastName;
	private String custAddress;
	private String custCity;
	private String custProv;
	private String custPostal;
	private String custCountry;
	private String custHomePhone;
	private String custBusPhone;
	private String custEmail;
	private Integer agentId;
	

	public Customer(String custFirstName, String custEmail, String custHomePhone, String custCity) {
		this.custFirstName = custFirstName;
		this.custEmail = custEmail;
		this.custHomePhone = custHomePhone;
		this.custCity = custCity;
		
	}

	public Customer(String custFirstName, String custLastName, String custAddress, String custCity, String custProv,
			String custPostal, String custBusPhone, String custEmail) {
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custAddress = custAddress;
		this.custCity = custCity;
		this.custProv = custProv;
		this.custPostal = custPostal;
		this.custBusPhone = custBusPhone;
		this.custEmail = custEmail;
	}

	public Customer(String custFirstName, String custLastName, String custAddress, String custCity, String custProv,
			String custPostal, String custCountry, String custHomePhone, String custBusPhone, String custEmail,
			Integer agentId) {
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custAddress = custAddress;
		this.custCity = custCity;
		this.custProv = custProv;
		this.custPostal = custPostal;
		this.custCountry = custCountry;
		this.custHomePhone = custHomePhone;
		this.custBusPhone = custBusPhone;
		this.custEmail = custEmail;
		this.agentId = agentId;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustFirstName() {
		return this.custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getCustLastName() {
		return this.custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	public String getCustAddress() {
		return this.custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustCity() {
		return this.custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}

	public String getCustProv() {
		return this.custProv;
	}

	public void setCustProv(String custProv) {
		this.custProv = custProv;
	}

	public String getCustPostal() {
		return this.custPostal;
	}

	public void setCustPostal(String custPostal) {
		this.custPostal = custPostal;
	}

	public String getCustCountry() {
		return this.custCountry;
	}

	public void setCustCountry(String custCountry) {
		this.custCountry = custCountry;
	}

	public String getCustHomePhone() {
		return this.custHomePhone;
	}

	public void setCustHomePhone(String custHomePhone) {
		this.custHomePhone = custHomePhone;
	}

	public String getCustBusPhone() {
		return this.custBusPhone;
	}

	public void setCustBusPhone(String custBusPhone) {
		this.custBusPhone = custBusPhone;
	}

	public String getCustEmail() {
		return this.custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public Integer getAgentId() {
		return this.agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public boolean getIsDefault() {
		// TODO Auto-generated method stub
		return false;
	}

}