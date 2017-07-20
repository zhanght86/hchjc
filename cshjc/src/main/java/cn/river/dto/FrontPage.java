package cn.river.dto;

/**
 * Created by Guide on 2017/4/24.
 */
public class FrontPage {
    private Integer totalNums;
    private Integer pageNums;
    private Integer currentPage;
    private Integer pageSize;
    private Integer startNum;
    private String order;
    private String year;
    private String month;
    private String level;
    private Integer ownerId;
    private Integer authorId;
    private String dimension;
    private String status;
    private String type;
    private String city;
    private String tagId;
    private String keywords;
    private boolean hasNextPage;
    private boolean hasPrePage;
    private Integer identity;

    @Override
    public String toString() {
        return "FrontPage{" +
                "totalNums=" + totalNums +
                ", pageNums=" + pageNums +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", startNum=" + startNum +
                ", order='" + order + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", level='" + level + '\'' +
                ", ownerId=" + ownerId +
                ", authorId=" + authorId +
                ", dimension='" + dimension + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", city='" + city + '\'' +
                ", tagId='" + tagId + '\'' +
                ", keywords='" + keywords + '\'' +
                ", hasNextPage=" + hasNextPage +
                ", hasPrePage=" + hasPrePage +
                ", identity=" + identity +
                '}';
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Integer getTotalNums() {
        return totalNums;
    }

    public void setTotalNums(Integer totalNums) {
        this.totalNums = totalNums;
    }

    public Integer getPageNums() {
        return pageNums;
    }

    public void setPageNums(Integer pageNums) {
        this.pageNums = pageNums;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public boolean isHasPrePage() {
        return hasPrePage;
    }

    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }
}
