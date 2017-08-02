package cn.river.datas;

/**
 * Created by Guide on 2017/3/20.
 *
 */
public enum DataEnums {
    SUCCESS("成功"),
    FAIL("失败"),
    PATH_BASE("/error/danger.jsp"),
    PATH_IMAGES("/var/www/html/h5resources/wechathead"),
    PATH_IMAGES_VISIT("http://cshjc.link-go.cn:8080/h5resources/wechathead"),
    PATH_READ_HEADIMAGE("/var/www/html/h5resources/");

    private String desc;

    DataEnums(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
