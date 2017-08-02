package cn.river.entity;

public class DevicesEntity {
	private Integer id;
	private String deviceId;
	private Integer spotId;
	private String deviceName;
	private String gps;
	private boolean updateParamFlag;
	private boolean updateFileFlag;
	private String authorCode;
	private boolean used;
	private String stateCode;
	private String stateMsg;
	private String installTime;
	private String addTime;
	private String updateTime;
	private int perSet;
	private int reset;
	private int request;
	public DevicesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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
	 * @return the spotId
	 */
	public Integer getSpotId() {
		return spotId;
	}
	/**
	 * @param spotId the spotId to set
	 */
	public void setSpotId(Integer spotId) {
		this.spotId = spotId;
	}
	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}
	/**
	 * @param deviceName the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	/**
	 * @return the gps
	 */
	public String getGps() {
		return gps;
	}
	/**
	 * @param gps the gps to set
	 */
	public void setGps(String gps) {
		this.gps = gps;
	}
	/**
	 * @return the updateParamFlag
	 */
	public boolean isUpdateParamFlag() {
		return updateParamFlag;
	}
	/**
	 * @param updateParamFlag the updateParamFlag to set
	 */
	public void setUpdateParamFlag(boolean updateParamFlag) {
		this.updateParamFlag = updateParamFlag;
	}
	/**
	 * @return the updateFileFlag
	 */
	public boolean isUpdateFileFlag() {
		return updateFileFlag;
	}
	/**
	 * @param updateFileFlag the updateFileFlag to set
	 */
	public void setUpdateFileFlag(boolean updateFileFlag) {
		this.updateFileFlag = updateFileFlag;
	}
	/**
	 * @return the authorCode
	 */
	public String getAuthorCode() {
		return authorCode;
	}
	/**
	 * @param authorCode the authorCode to set
	 */
	public void setAuthorCode(String authorCode) {
		this.authorCode = authorCode;
	}
	/**
	 * @return the used
	 */
	public boolean isUsed() {
		return used;
	}
	/**
	 * @param used the used to set
	 */
	public void setUsed(boolean used) {
		this.used = used;
	}
	/**
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}
	/**
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	/**
	 * @return the stateMsg
	 */
	public String getStateMsg() {
		return stateMsg;
	}
	/**
	 * @param stateMsg the stateMsg to set
	 */
	public void setStateMsg(String stateMsg) {
		this.stateMsg = stateMsg;
	}
	/**
	 * @return the installTime
	 */
	public String getInstallTime() {
		return installTime;
	}
	/**
	 * @param installTime the installTime to set
	 */
	public void setInstallTime(String installTime) {
		this.installTime = installTime;
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
	/**
	 * @return the updateTime
	 */
	public String getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * @return the perSet
	 */
	public int getPerSet() {
		return perSet;
	}
	/**
	 * @param perSet the perSet to set
	 */
	public void setPerSet(int perSet) {
		this.perSet = perSet;
	}
	/**
	 * @return the reset
	 */
	public int getReset() {
		return reset;
	}
	/**
	 * @param reset the reset to set
	 */
	public void setReset(int reset) {
		this.reset = reset;
	}
	/**
	 * @return the request
	 */
	public int getRequest() {
		return request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(int request) {
		this.request = request;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DevicesEntity [id=" + id + ", deviceId=" + deviceId
				+ ", spotId=" + spotId + ", deviceName=" + deviceName
				+ ", gps=" + gps + ", updateParamFlag=" + updateParamFlag
				+ ", updateFileFlag=" + updateFileFlag + ", authorCode="
				+ authorCode + ", used=" + used + ", stateCode=" + stateCode
				+ ", stateMsg=" + stateMsg + ", installTime=" + installTime
				+ ", addTime=" + addTime + ", updateTime=" + updateTime
				+ ", perSet=" + perSet + ", reset=" + reset + ", request="
				+ request + "]";
	}
	
}
