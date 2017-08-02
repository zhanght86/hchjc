package cn.river.dto;


import java.util.Arrays;

/**
 * Created by Guide on 2016/12/11.
 */
public class DataTables {
    private Integer draw;
    private Integer start;
    private Integer length;
    private Integer colsNum;
    private String[] colums;
    private String searchWord;
    private Integer searchCol;
    private String order;
    private Integer sortingCol;
//  后来添加的搜索
    private String Shot;    //all,是,否
    private int used;    //all,使用,停用
    private String SinstallTime;
	public DataTables(Integer draw, Integer start, Integer length,
			Integer colsNum, String[] colums, String searchWord,
			Integer searchCol, String order, Integer sortingCol, String shot,
			int used, String sinstallTime) {
		super();
		this.draw = draw;
		this.start = start;
		this.length = length;
		this.colsNum = colsNum;
		this.colums = colums;
		this.searchWord = searchWord;
		this.searchCol = searchCol;
		this.order = order;
		this.sortingCol = sortingCol;
		this.Shot = shot;
		this.used = used;
		SinstallTime = sinstallTime;
	}
	public DataTables(Integer draw, Integer start, Integer length, Integer colsNum, String[] colums, String searchWord, Integer searchCol, String order, Integer sortingCol) {
        this.draw = draw;
        this.start = start;
        this.length = length;
        this.colsNum = colsNum;
        this.colums = colums;
        this.searchWord = searchWord;
        this.searchCol = searchCol;
        this.order = order;
        this.sortingCol = sortingCol;
    }
	public DataTables() {
    }
	
	/**
	 * @return the draw
	 */
	public Integer getDraw() {
		return draw;
	}
	/**
	 * @param draw the draw to set
	 */
	public void setDraw(Integer draw) {
		this.draw = draw;
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
	 * @return the colsNum
	 */
	public Integer getColsNum() {
		return colsNum;
	}
	/**
	 * @param colsNum the colsNum to set
	 */
	public void setColsNum(Integer colsNum) {
		this.colsNum = colsNum;
	}
	/**
	 * @return the colums
	 */
	public String[] getColums() {
		return colums;
	}
	/**
	 * @param colums the colums to set
	 */
	public void setColums(String[] colums) {
		this.colums = colums;
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
	 * @return the searchCol
	 */
	public Integer getSearchCol() {
		return searchCol;
	}
	/**
	 * @param searchCol the searchCol to set
	 */
	public void setSearchCol(Integer searchCol) {
		this.searchCol = searchCol;
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
	 * @return the sortingCol
	 */
	public Integer getSortingCol() {
		return sortingCol;
	}
	/**
	 * @param sortingCol the sortingCol to set
	 */
	public void setSortingCol(Integer sortingCol) {
		this.sortingCol = sortingCol;
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
	 * @return the sinstallTime
	 */
	public String getSinstallTime() {
		return SinstallTime;
	}
	/**
	 * @param sinstallTime the sinstallTime to set
	 */
	public void setSinstallTime(String sinstallTime) {
		SinstallTime = sinstallTime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DataTables [draw=" + draw + ", start=" + start + ", length="
				+ length + ", colsNum=" + colsNum + ", colums="
				+ Arrays.toString(colums) + ", searchWord=" + searchWord
				+ ", searchCol=" + searchCol + ", order=" + order
				+ ", sortingCol=" + sortingCol + ", Shot=" + Shot + ", used="
				+ used + ", SinstallTime=" + SinstallTime + "]";
	}

    
}
