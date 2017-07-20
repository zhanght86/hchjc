package cn.river.execptions;

/**
 * Created by Guide on 2016/12/10.
 */
public class RiverException extends RuntimeException {
    public RiverException(String message) {
        super(message);
    }

    public RiverException(String message, Throwable cause) {
        super(message, cause);
    }
}
