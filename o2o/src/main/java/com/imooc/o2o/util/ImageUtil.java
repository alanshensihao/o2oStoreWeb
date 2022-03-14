package com.imooc.o2o.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {

    // get current path in the current thread
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    // set date format 
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    
    // set random number
    private static final Random r = new Random();

    public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr) {

        // retrieve file from each addr and name
        // target file name
        String realFileName = getRandomFileName();
        //target extension
        String extension = getFileExtension(thumbnail);
        // target address
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + readFileName + extension;
        File dest = new File(PathUtil.getImageBasePath() + relativeAddr);

        try {
            Thumbnails.of(thumbnail.getInputStream()).size(200,200)
            .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
            .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * generate random file name, based on current date time + 5 random num
     * @return
     */
    private static String getRandomFileName() {
        // get a random 5 digit num
        // 0 - 99999
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());

        return nowTimeStr + rannum;
    }



    public static void main(String[] args) throws IOException {
        

        System.out.println(basePath);
        // test file locaiton
        Thumbnails.of(new File("B://VS_Project/Java/eCommerce/o2o/src/main/resources/image/ThumbnailsTest.jpg"))
        .size(200,200)
        .watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
        .outputQuality(0.8f)
        .toFile("B://VS_Project/Java/eCommerce/o2o/src/main/resources/image/ThumbnailsTestCopy.jpg");
    }
}
