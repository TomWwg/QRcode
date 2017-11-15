package com.wwg.zxing;

import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;
import com.sun.media.jfxmedia.track.Track;
import com.wwg.utils.BufferedImageLuminanceSource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by wwg on 2017/11/15.
 */
public class ReadQRCode {

    public static void main(String[] args) {
        try {
            MultiFormatReader formatReader = new MultiFormatReader();
            File file = new File("C:/Users/admin/Desktop/img1.png");
            BufferedImage image = ImageIO.read(file);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            HashMap hints = new HashMap();
            //定义二维码的参数
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            Result result = formatReader.decode(binaryBitmap, hints);
            System.out.println("解析结果：" + result.toString());
            System.out.println("二维码格式类型：" + result.getBarcodeFormat());
            System.out.println("二维码文本内容：" + result.getText());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

    }
}
