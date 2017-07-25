package cn.river.entity;

public class DevicesDataEntity {
	private int id;
	private String deviceId;
	private String cod;
	private String doPer;
	private String doVal;
	private String nh4;
	private String temp;
	private String orp;
	private String zs;
	private String version;
	private String quanity;
	private String devicePostTime;
	private String addTime;
	
	public DevicesDataEntity() {}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}

	/**
	 * @param cod the cod to set
	 */
	public void setCod(String cod) {
		this.cod = cod;
	}

	/**
	 * @return the doPer
	 */
	public String getDoPer() {
		return doPer;
	}

	/**
	 * @param doPer the doPer to set
	 */
	public void setDoPer(String doPer) {
		this.doPer = doPer;
	}

	/**
	 * @return the doVal
	 */
	public String getDoVal() {
		return doVal;
	}

	/**
	 * @param doVal the doVal to set
	 */
	public void setDoVal(String doVal) {
		this.doVal = doVal;
	}

	/**
	 * @return the nh4
	 */
	public String getNh4() {
		return nh4;
	}

	/**
	 * @param nh4 the nh4 to set
	 */
	public void setNh4(String nh4) {
		this.nh4 = nh4;
	}

	/**
	 * @return the temp
	 */
	public String getTemp() {
		return temp;
	}

	/**
	 * @param temp the temp to set
	 */
	public void setTemp(String temp) {
		this.temp = temp;
	}

	/**
	 * @return the orp
	 */
	public String getOrp() {
		return orp;
	}

	/**
	 * @param orp the orp to set
	 */
	public void setOrp(String orp) {
		this.orp = orp;
	}

	/**
	 * @return the zs
	 */
	public String getZs() {
		return zs;
	}

	/**
	 * @param zs the zs to set
	 */
	public void setZs(String zs) {
		this.zs = zs;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the quanity
	 */
	public String getQuanity() {
		return quanity;
	}

	/**
	 * @param quanity the quanity to set
	 */
	public void setQuanity(String quanity) {
		this.quanity = quanity;
	}

	/**
	 * @return the devicePostTime
	 */
	public String getDevicePostTime() {
		return devicePostTime;
	}

	/**
	 * @param devicePostTime the devicePostTime to set
	 */
	public void setDevicePostTime(String devicePostTime) {
		this.devicePostTime = devicePostTime;
	}

	/**
	 * @return the addTime
	 */
	public String getAddTime() {
		return addTime;
	}

	/**
	 * @param addTime the addTime to set
	 */
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DevicesDataEntity [id=" + id + ", deviceId=" + deviceId
				+ ", cod=" + cod + ", doPer=" + doPer + ", doVal=" + doVal
				+ ", nh4=" + nh4 + ", temp=" + temp + ", orp=" + orp + ", zs="
				+ zs + ", version=" + version + ", quanity=" + quanity
				+ ", devicePostTime=" + devicePostTime + ", addTime=" + addTime
				+ "]";
	}

	
	
}
