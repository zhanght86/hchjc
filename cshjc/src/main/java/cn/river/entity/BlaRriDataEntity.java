package cn.river.entity;

/**
 * Created by Guide on 2017/2/6.
 */
public class BlaRriDataEntity {
    private String Cod;	//COD值
    private String DoPer;	//DO百分比
    private String DoVal;//DO值
    private String NH4;//氨氮值
    private String Temp;//水温
    private String ORP;//氧化还原电位
    private String ZS;//浊度
    
	public BlaRriDataEntity() {
	}

	public BlaRriDataEntity(String cod, String doPer, String doVal, String nH4,
			String temp, String oRP, String zS) {
		super();
		Cod = cod;
		DoPer = doPer;
		DoVal = doVal;
		NH4 = nH4;
		Temp = temp;
		ORP = oRP;
		ZS = zS;
	}

	/**
	 * @return the cod
	 */
	public String getCod() {
		return Cod;
	}

	/**
	 * @param cod the cod to set
	 */
	public void setCod(String cod) {
		Cod = cod;
	}

	/**
	 * @return the doPer
	 */
	public String getDoPer() {
		return DoPer;
	}

	/**
	 * @param doPer the doPer to set
	 */
	public void setDoPer(String doPer) {
		DoPer = doPer;
	}

	/**
	 * @return the doVal
	 */
	public String getDoVal() {
		return DoVal;
	}

	/**
	 * @param doVal the doVal to set
	 */
	public void setDoVal(String doVal) {
		DoVal = doVal;
	}

	/**
	 * @return the nH4
	 */
	public String getNH4() {
		return NH4;
	}

	/**
	 * @param nH4 the nH4 to set
	 */
	public void setNH4(String nH4) {
		NH4 = nH4;
	}

	/**
	 * @return the temp
	 */
	public String getTemp() {
		return Temp;
	}

	/**
	 * @param temp the temp to set
	 */
	public void setTemp(String temp) {
		Temp = temp;
	}

	/**
	 * @return the oRP
	 */
	public String getORP() {
		return ORP;
	}

	/**
	 * @param oRP the oRP to set
	 */
	public void setORP(String oRP) {
		ORP = oRP;
	}

	/**
	 * @return the zS
	 */
	public String getZS() {
		return ZS;
	}

	/**
	 * @param zS the zS to set
	 */
	public void setZS(String zS) {
		ZS = zS;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BlaRriDataEntity [Cod=" + Cod + ", DoPer=" + DoPer + ", DoVal="
				+ DoVal + ", NH4=" + NH4 + ", Temp=" + Temp + ", ORP=" + ORP
				+ ", ZS=" + ZS + "]";
	}

	
	
}
