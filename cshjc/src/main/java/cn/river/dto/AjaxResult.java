package cn.river.dto;

/**
 * Created by Guide on 2017/2/3.
 */
public class AjaxResult {
    private int state;
    private String message;
    private Object data;

    @Override
    public String toString() {
        return "AjaxResult{" +
                "state=" + state +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public AjaxResult() {
    }

    public AjaxResult(int state, String message) {
        this.state = state;
        this.message = message;
    }

    public AjaxResult(int state, String message, Object data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
