package cn.river.dto;

import java.util.List;
/**
 * Created by Guide on 2016/12/11.
 */
public class DataTablesResult<T> {
    private Integer draw;
    private Integer recordsTotal;
    private Integer recordsFiltered;
    private List<T> data;
    private String error;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public DataTablesResult(Integer draw, Integer recordsTotal, Integer recordsFiltered, List<T> data, String error) {
        this.draw = draw;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
        this.error = error;
    }

    public DataTablesResult() {
    }

    @Override
    public String toString() {
        return "DataTablesResult{" +
                "draw=" + draw +
                ", recordsTotal=" + recordsTotal +
                ", recordsFiltered=" + recordsFiltered +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }
}
