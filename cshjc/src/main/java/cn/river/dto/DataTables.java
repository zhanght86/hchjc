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
    private String minmonth;
    private String maxmonth;
    private String dimension;
//    后来添加的搜索
    private String Shot;    //all,是,否
    private String Stop;    //all,未上榜,上榜
    private Double Sscorefrom;  //评分下限
    private Double Sscoreto;  //评分上限
    private String Shome;   //all,已推荐,未推荐
    private String Sshow;   //all,已发布,已下线
    private String Sdatefrom; //发布日期下限
    private String Sdateto; //发布日期上限
    private String Stagtype;    //all,H5案例标签 等
    private String Stagclass;   //all,id值
    private String Steamtype;   //all,一级品牌主,二级品牌主,创意代理商
    private String Steamlevel;  //all,推荐团队,普通团队
    private Integer SisOk;


    public DataTables(Integer draw, Integer start, Integer length, Integer colsNum, String[] colums, String searchWord, Integer searchCol, String order, Integer sortingCol, String minmonth, String maxmonth, String dimension) {
        this.draw = draw;
        this.start = start;
        this.length = length;
        this.colsNum = colsNum;
        this.colums = colums;
        this.searchWord = searchWord;
        this.searchCol = searchCol;
        this.order = order;
        this.sortingCol = sortingCol;
        this.minmonth = minmonth;
        this.maxmonth = maxmonth;
        this.dimension = dimension;
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

    public Integer getSisOk() {
        return SisOk;
    }

    public void setSisOk(Integer sisOk) {
        SisOk = sisOk;
    }

    public String getShot() {
        return Shot;
    }

    public void setShot(String shot) {
        Shot = shot;
    }

    public String getStop() {
        return Stop;
    }

    public void setStop(String stop) {
        Stop = stop;
    }

    public Double getSscorefrom() {
        return Sscorefrom;
    }

    public void setSscorefrom(Double sscorefrom) {
        Sscorefrom = sscorefrom;
    }

    public Double getSscoreto() {
        return Sscoreto;
    }

    public void setSscoreto(Double sscoreto) {
        Sscoreto = sscoreto;
    }

    public String getShome() {
        return Shome;
    }

    public void setShome(String shome) {
        Shome = shome;
    }

    public String getSshow() {
        return Sshow;
    }

    public void setSshow(String sshow) {
        Sshow = sshow;
    }

    public String getSdatefrom() {
        return Sdatefrom;
    }

    public void setSdatefrom(String sdatefrom) {
        Sdatefrom = sdatefrom;
    }

    public String getSdateto() {
        return Sdateto;
    }

    public void setSdateto(String sdateto) {
        Sdateto = sdateto;
    }

    public String getStagtype() {
        return Stagtype;
    }

    public void setStagtype(String stagtype) {
        Stagtype = stagtype;
    }

    public String getStagclass() {
        return Stagclass;
    }

    public void setStagclass(String stagclass) {
        Stagclass = stagclass;
    }

    public String getSteamtype() {
        return Steamtype;
    }

    public void setSteamtype(String steamtype) {
        Steamtype = steamtype;
    }

    public String getSteamlevel() {
        return Steamlevel;
    }

    public void setSteamlevel(String steamlevel) {
        Steamlevel = steamlevel;
    }

    public String getMinmonth() {
        return minmonth;
    }

    public void setMinmonth(String minmonth) {
        this.minmonth = minmonth;
    }

    public String getMaxmonth() {
        return maxmonth;
    }

    public void setMaxmonth(String maxmonth) {
        this.maxmonth = maxmonth;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getColsNum() {
        return colsNum;
    }

    public void setColsNum(Integer colsNum) {
        this.colsNum = colsNum;
    }

    public String[] getColums() {
        return colums;
    }

    public void setColums(String[] colums) {
        this.colums = colums;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public Integer getSearchCol() {
        return searchCol;
    }

    public void setSearchCol(Integer searchCol) {
        this.searchCol = searchCol;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getSortingCol() {
        return sortingCol;
    }

    public void setSortingCol(Integer sortingCol) {
        this.sortingCol = sortingCol;
    }

    @Override
    public String toString() {
        return "DataTables{" +
                "draw=" + draw +
                ", start=" + start +
                ", length=" + length +
                ", colsNum=" + colsNum +
                ", colums=" + Arrays.toString(colums) +
                ", searchWord='" + searchWord + '\'' +
                ", searchCol=" + searchCol +
                ", order='" + order + '\'' +
                ", sortingCol=" + sortingCol +
                ", minmonth='" + minmonth + '\'' +
                ", maxmonth='" + maxmonth + '\'' +
                ", dimension='" + dimension + '\'' +
                ", Shot='" + Shot + '\'' +
                ", Stop='" + Stop + '\'' +
                ", Sscorefrom=" + Sscorefrom +
                ", Sscoreto=" + Sscoreto +
                ", Shome='" + Shome + '\'' +
                ", Sshow='" + Sshow + '\'' +
                ", Sdatefrom='" + Sdatefrom + '\'' +
                ", Sdateto='" + Sdateto + '\'' +
                ", Stagtype='" + Stagtype + '\'' +
                ", Stagclass='" + Stagclass + '\'' +
                ", Steamtype='" + Steamtype + '\'' +
                ", Steamlevel='" + Steamlevel + '\'' +
                ", SisOk=" + SisOk +
                '}';
    }
}
