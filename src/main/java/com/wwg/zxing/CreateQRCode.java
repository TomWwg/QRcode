package com.wwg.zxing;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * 生成二维码
 * Created by wwg on 2017/11/8.
 */
public class CreateQRCode {

    public static void main(String[] args) {
        int width = 300;
        int hight = 300;
        String format = "png";
        //扫描二维码时产生的链接
        String contents = "http://write.blog.csdn.net/postlist";

        //HashMap的默认大小为16，新建Map时候根据阿里规范，需要写上大小
        HashMap hints = new HashMap(16);
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        //设置二维码的容错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        //设置边距
        hints.put(EncodeHintType.MARGIN, 2);

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, hight, hints);
            //保存的路径
            File file = new File("C:/Users/admin/Desktop/img.png");
            MatrixToImageWriter.writeToFile(bitMatrix, format, file);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
