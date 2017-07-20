package cn.river.entity;

/**
 * Created by Guide on 2017/3/20.
 */
public class AuthoritiesEntity {
    private Integer id;
    private String items;
    private String title;
    private String setDate;
    private String updateDate;

   
	@Override
	public String toString() {
		return "AuthoritiesEntity [id=" + id + ", items=" + items + ", title="
				+ title + ", setDate=" + setDate + ", updateDate=" + updateDate
				+ "]";
	}

	public String getSetDate() {
        return setDate;
    }

    public void setSetDate(String setDate) {
        this.setDate = setDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
