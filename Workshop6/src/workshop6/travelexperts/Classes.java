package travelexperts;
// default package
// Generated 29-Aug-2017 10:13:16 AM by Hibernate Tools 5.2.5.Final

/**
 * Classes generated by hbm2java
 */
public class Classes implements java.io.Serializable {

	private String classId;
	private String className;
	private String classDesc;

	public Classes() {
	}

	public Classes(String classId, String className) {
		this.classId = classId;
		this.className = className;
	}

	public Classes(String classId, String className, String classDesc) {
		this.classId = classId;
		this.className = className;
		this.classDesc = classDesc;
	}

	public String getClassId() {
		return this.classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassDesc() {
		return this.classDesc;
	}

	public void setClassDesc(String classDesc) {
		this.classDesc = classDesc;
	}

}
