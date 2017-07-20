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
    PATH_IMAGES_VISIT("http://www.faceh5.com/h5resources/wechathead"),
    PATH_QR_LOGO("/var/www/html/h5resources/qrimages/QRlogo.png"),
    PATH_READ_HEADIMAGE("/var/www/html/h5resources/"),
        PATH_QR_SAVE("/var/www/html/h5resources/qrimages/"),
    PATH_QR_VISIT("http://www.faceh5.com/h5resources/qrimages/"),
    BANDAGE_HOT("http://www.faceh5.com/h5resources/qrimages/QRlogo.png"),
    BANDAGE_MOVIE("http://www.faceh5.com/h5resources/qrimages/QRlogo.png");

    private String desc;

    DataEnums(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
