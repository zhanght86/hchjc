package cn.river.dto;

import java.util.Arrays;
/**
 * Created by Guide on 2016/12/15.
 */
public class GetByPage {
    private String[] cols;
    private Integer start;
    private Integer length;
    private String order;
    private String orderCol;
    private String[] searchCols;
    private String searchWord;
    //    后来添加的搜索
    private String Shot;    //all,是,否
    private int used;    //all,使用,停用
    private String SinstallTime;
	/**
	 * @return the cols
	 */
	public String[] getCols() {
		return cols;
	}
	/**
	 * @param cols the cols to set
	 */
	public void setCols(String[] cols) {
		this.cols = cols;
	}
	/**
	 * @return the start
	 */
	public Integer getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(Integer start) {
		this.start = start;
	}
	/**
	 * @return the length
	 */
	public Integer getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(Integer length) {
		this.length = length;
	}
	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}
	/**
	 * @return the orderCol
	 */
	public String getOrderCol() {
		return orderCol;
	}
	/**
	 * @param orderCol the orderCol to set
	 */
	public void setOrderCol(String orderCol) {
		this.orderCol = orderCol;
	}
	/**
	 * @return the searchCols
	 */
	public String[] getSearchCols() {
		return searchCols;
	}
	/**
	 * @param searchCols the searchCols to set
	 */
	public void setSearchCols(String[] searchCols) {
		this.searchCols = searchCols;
	}
	/**
	 * @return the searchWord
	 */
	public String getSearchWord() {
		return searchWord;
	}
	/**
	 * @param searchWord the searchWord to set
	 */
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	/**
	 * @return the shot
	 */
	public String getShot() {
		return Shot;
	}
	/**
	 * @param shot the shot to set
	 */
	public void setShot(String shot) {
		Shot = shot;
	}
	/**
	 * @return the used
	 */
	public int getUsed() {
		return used;
	}
	/**
	 * @param used the used to set
	 */
	public void setUsed(int used) {
		this.used = used;
	}
	/**
	 * @return the sdatefrom
	 */
	public String getSinstallTime() {
		return SinstallTime;
	}
	/**
	 * @param sdatefrom the sdatefrom to set
	 */
	public void setSinstallTime(String sinstallTime) {
		SinstallTime = sinstallTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GetByPage [cols=" + Arrays.toString(cols) + ", start=" + start
				+ ", length=" + length + ", order=" + order + ", orderCol="
				+ orderCol + ", searchCols=" + Arrays.toString(searchCols)
				+ ", searchWord=" + searchWord + ", Shot=" + Shot + ", used="
				+ used + ", SinstallTime=" + SinstallTime + "]";
	}

}
