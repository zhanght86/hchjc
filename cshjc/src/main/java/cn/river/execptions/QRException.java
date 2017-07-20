package cn.river.execptions;

/**
 * Created by Guide on 2016/12/10.
 */
public class QRException extends RiverException {
    public QRException(String message) {
        super(message);
    }

    public QRException(String message, Throwable cause) {
        super(message, cause);
    }
}
