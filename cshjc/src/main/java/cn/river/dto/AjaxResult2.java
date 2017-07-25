package cn.river.dto;

/**
 * Created by Guide on 2017/2/3.
 */
public class AjaxResult2 {
    private int errcode;
    private String errmsg;
    
	public AjaxResult2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AjaxResult2(int errcode, String errmsg) {
		this.errcode = errcode;
		this.errmsg = errmsg;
	}
	
	/**
	 * @return the errcode
	 */
	public int getErrcode() {
		return errcode;
	}
	/**
	 * @param errcode the errcode to set
	 */
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	/**
	 * @return the errmsg
	 */
	public String getErrmsg() {
		return errmsg;
	}
	/**
	 * @param errmsg the errmsg to set
	 */
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AjaxResult2 [errcode=" + errcode + ", errmsg=" + errmsg + "]";
	}
    
    
	

}
