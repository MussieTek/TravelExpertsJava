// default package
// Generated 29-Aug-2017 10:13:16 AM by Hibernate Tools 5.2.5.Final

/**
 * Agencies generated by hbm2java
 */
public class Agencies implements java.io.Serializable {

	private Integer agencyId;
	private String agncyAddress;
	private String agncyCity;
	private String agncyProv;
	private String agncyPostal;
	private String agncyCountry;
	private String agncyPhone;
	private String agncyFax;

	public Agencies() {
	}

	public Agencies(String agncyAddress, String agncyCity, String agncyProv, String agncyPostal, String agncyCountry,
			String agncyPhone, String agncyFax) {
		this.agncyAddress = agncyAddress;
		this.agncyCity = agncyCity;
		this.agncyProv = agncyProv;
		this.agncyPostal = agncyPostal;
		this.agncyCountry = agncyCountry;
		this.agncyPhone = agncyPhone;
		this.agncyFax = agncyFax;
	}

	public Integer getAgencyId() {
		return this.agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}

	public String getAgncyAddress() {
		return this.agncyAddress;
	}

	public void setAgncyAddress(String agncyAddress) {
		this.agncyAddress = agncyAddress;
	}

	public String getAgncyCity() {
		return this.agncyCity;
	}

	public void setAgncyCity(String agncyCity) {
		this.agncyCity = agncyCity;
	}

	public String getAgncyProv() {
		return this.agncyProv;
	}

	public void setAgncyProv(String agncyProv) {
		this.agncyProv = agncyProv;
	}

	public String getAgncyPostal() {
		return this.agncyPostal;
	}

	public void setAgncyPostal(String agncyPostal) {
		this.agncyPostal = agncyPostal;
	}

	public String getAgncyCountry() {
		return this.agncyCountry;
	}

	public void setAgncyCountry(String agncyCountry) {
		this.agncyCountry = agncyCountry;
	}

	public String getAgncyPhone() {
		return this.agncyPhone;
	}

	public void setAgncyPhone(String agncyPhone) {
		this.agncyPhone = agncyPhone;
	}

	public String getAgncyFax() {
		return this.agncyFax;
	}

	public void setAgncyFax(String agncyFax) {
		this.agncyFax = agncyFax;
	}

}
