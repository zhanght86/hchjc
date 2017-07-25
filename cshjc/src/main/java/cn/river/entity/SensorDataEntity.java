package cn.river.entity;

/**
 * Created by Guide on 2017/2/6.
 */
public class SensorDataEntity {
	private String DeviceID;
	private BlaRriDataEntity BlaRriData;
    private String Version;	//COD值
    private String Quanity;	//DO百分比
    private String Timestamp;//DO值

	public SensorDataEntity() {}

	public SensorDataEntity(String deviceID,BlaRriDataEntity blaRriData, String version, String quanity,
			String timestamp) {
		super();
		DeviceID = deviceID;
		Version = version;
		Quanity = quanity;
		Timestamp = timestamp;
		BlaRriData = blaRriData;
	}

	/**
	 * @return the deviceID
	 */
	public String getDeviceID() {
		return DeviceID;
	}

	/**
	 * @param deviceID the deviceID to set
	 */
	public void setDeviceID(String deviceID) {
		DeviceID = deviceID;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return Version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		Version = version;
	}

	/**
	 * @return the quanity
	 */
	public String getQuanity() {
		return Quanity;
	}

	/**
	 * @param quanity the quanity to set
	 */
	public void setQuanity(String quanity) {
		Quanity = quanity;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return Timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		Timestamp = timestamp;
	}

	/**
	 * @return the blaRriData
	 */
	public BlaRriDataEntity getBlaRriData() {
		return BlaRriData;
	}

	/**
	 * @param blaRriData the blaRriData to set
	 */
	public void setBlaRriData(BlaRriDataEntity blaRriData) {
		BlaRriData = blaRriData;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SensorDataEntity [DeviceID=" + DeviceID + ", Version="
				+ Version + ", Quanity=" + Quanity + ", Timestamp=" + Timestamp
				+ ", BlaRriData=" + BlaRriData + "]";
	}

	
	
}
