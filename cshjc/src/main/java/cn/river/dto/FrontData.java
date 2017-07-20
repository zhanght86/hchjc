package cn.river.dto;

import java.util.List;

/**
 * Created by Guide on 2017/4/24.
 */
public class FrontData<T> {
    private List<T> data;
    private FrontPage page;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public FrontPage getPage() {
        return page;
    }

    public void setPage(FrontPage page) {
        this.page = page;
    }

    public FrontData() {
    }

    public FrontData(List<T> data, FrontPage page) {
        this.data = data;
        this.page = page;
    }

    @Override
    public String toString() {
        return "FrontData{" +
                "data=" + data +
                ", page=" + page +
                '}';
    }
}
