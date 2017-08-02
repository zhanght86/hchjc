package cn.river.entity;

public class CollectionSpotsEntity {
	private Integer spotId;
	private String spotName;
	private String gps;
	private String addTime;
	private String updateTime;
	public CollectionSpotsEntity() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the spotName
	 */
	public String getSpotName() {
		return spotName;
	}
	/**
	 * @param spotName the spotName to set
	 */
	public void setSpotName(String spotName) {
		this.spotName = spotName;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CollectionSpotsEntity [spotId=" + spotId + ", spotName="
				+ spotName + ", gps=" + gps + ", addTime=" + addTime
				+ ", updateTime=" + updateTime + "]";
	}
	
	
	
}
