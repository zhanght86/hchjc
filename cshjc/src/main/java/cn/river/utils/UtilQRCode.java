package cn.river.utils;

import cn.river.execptions.QRException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * 生成二维码
 * Created by Guide on 2016/12/10.
 */
public class UtilQRCode {
    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    /**
     * 最终调用该方法生成二维码图片
     *
     * @param url      要生成二维码的url
     * @param imgPath  二维码生成的绝对路径
     * @param logoPath 二维码中间logo绝对地址
     */
    public static void get2CodeImage(String url, String imgPath, String logoPath) throws Exception {
        try {
            String format = "jpg";
            Hashtable hints = new Hashtable();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 500, 500, hints);

            int margin = 10;  //自定义白边边框宽度  15px
            bitMatrix = updateBit(bitMatrix, margin);  //生成新的bitMatrix

            File qrcodeFile = new File(imgPath);
            UtilQRCode.writeToFile(bitMatrix, format, qrcodeFile, logoPath);
        } catch (Exception e) {
            throw new QRException("创建二维码失败");
        }
    }

    private static BitMatrix updateBit(BitMatrix matrix, int margin) {
        int tempM = margin * 2;
        int[] rec = matrix.getEnclosingRectangle(); // 获取二维码图案的属性
        int resWidth = rec[2] + tempM;
        int resHeight = rec[3] + tempM;
        BitMatrix resMatrix = new BitMatrix(resWidth, resHeight); // 按照自定义边框生成新的BitMatrix
        resMatrix.clear();
        for (int i = margin; i < resWidth - margin; i++) { // 循环，将二维码图案绘制到新的bitMatrix中
            for (int j = margin; j < resHeight - margin; j++) {
                if (matrix.get(i - margin + rec[0], j - margin + rec[1])) {
                    resMatrix.set(i, j);
                }
            }
        }
        return resMatrix;
    }


    /**
     * 图片放大缩小
     */

    public static BufferedImage zoomInImage(BufferedImage originalImage, int width, int height) {
        BufferedImage newImage = new BufferedImage(width, height, originalImage.getType());
        Graphics g = newImage.getGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        return newImage;

    }

    /**
     * @param matrix   二维码矩阵相关
     * @param format   二维码图片格式
     * @param file     二维码图片文件
     * @param logoPath logo路径
     */
    private static void writeToFile(BitMatrix matrix, String format, File file, String logoPath) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        Graphics2D gs = image.createGraphics();

        gs.setColor(Color.WHITE);
        gs.fillRect(183,198,124,124);
        //载入logo
        Image img = ImageIO.read(new File(logoPath));
//        缩放logo
        img = zoomInImage((BufferedImage) img,120,120);

        gs.drawImage(img, 185, 200, null);
        gs.dispose();
        img.flush();
        if (!ImageIO.write(image, format, file)) {
            throw new IOException("创建二维码失败");
        }
    }

    private static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        image = zoomInImage(image,500,500);
        return image;
    }

    public static void main(String[] args){


        try {
//            F:/1492954689527065364.jpg
//            F:/1493107419942098882.png
            UtilQRCode.get2CodeImage("https://c.m.163.com/nc/qa/activity/20170308/index.html", "F:/code.jpg", "F:/1493107419942098882.png");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
