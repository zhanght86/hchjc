package cn.river.entity;

import cn.river.dao.AuthoritiesDao;
import cn.river.utils.UtilMD5;

/**
 * Created by Guide on 2017/2/6.
 */
public class AdminsEntity {
    private Integer id;
    private String username;
    private String password;
    private String headImg;
    private String email;
    private String description;
    private String setDate;
    private String updateDate;
    private Integer authorityId;

    private AuthoritiesEntity authority;
    
    
    public AdminsEntity(){}
    
    public AdminsEntity(String username, String password) {
        this.username = username;
        this.password = UtilMD5.getMD5Code(password);
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the headImg
	 */
	public String getHeadImg() {
		return headImg;
	}

	/**
	 * @param headImg the headImg to set
	 */
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the setDate
	 */
	public String getSetDate() {
		return setDate;
	}

	/**
	 * @param setDate the setDate to set
	 */
	public void setSetDate(String setDate) {
		this.setDate = setDate;
	}

	/**
	 * @return the updateDate
	 */
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the authorityId
	 */
	public Integer getAuthorityId() {
		return authorityId;
	}

	/**
	 * @param authorityId the authorityId to set
	 */
	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	/**
	 * @return the authority
	 */
	public AuthoritiesEntity getAuthority() {
		return authority;
	}

	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(AuthoritiesEntity authority) {
		this.authority = authority;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AdminsEntity [id=" + id + ", username=" + username
				+ ", password=" + password + ", headImg=" + headImg
				+ ", email=" + email + ", description=" + description
				+ ", setDate=" + setDate + ", updateDate=" + updateDate
				+ ", authorityId=" + authorityId + ", authority=" + authority
				+ "]";
	}

    
}
