// default package
// Generated 29-Aug-2017 10:13:16 AM by Hibernate Tools 5.2.5.Final

/**
 * Regions generated by hbm2java
 */
public class Regions implements java.io.Serializable {

	private String regionId;
	private String regionName;

	public Regions() {
	}

	public Regions(String regionId) {
		this.regionId = regionId;
	}

	public Regions(String regionId, String regionName) {
		this.regionId = regionId;
		this.regionName = regionName;
	}

	public String getRegionId() {
		return this.regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

}