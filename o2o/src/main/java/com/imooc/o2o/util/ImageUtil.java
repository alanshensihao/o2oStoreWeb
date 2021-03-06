package com.imooc.o2o.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    // logger
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);


    /**
     * convert commonsultipartfile to java file!!
     * @param cFile
     * @return File
     */
    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile) {
        File newFile = new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        } catch (IllegalStateException e) {
            logger.error(e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return newFile;
    }

    /**
     * process compressed pic, and return new relative path of the pic
     * @param thumbnail
     * @param targetAddr
     * @return
     */
    public static String generateThumbnail(InputStream thumbnailInputStream, String fileName, String targetAddr) {

        // retrieve file from each addr and name
        // target file name
        String realFileName = getRandomFileName();
        //target extension
        String extension = getFileExtension(fileName);
        // target address
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;

        logger.debug("current relativeAddr is: " + relativeAddr);
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        logger.debug("current complete addr is: " + PathUtil.getImgBasePath() + relativeAddr);

        try {
            Thumbnails.of(thumbnailInputStream).size(200,200)
            .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
            .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }

        // return relative image addr and saved to sql
        return relativeAddr;
    }

    /**
     * retrieve file stream extension 
     * @param thumbnail
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * generate random file name, based on current date time + 5 random num
     * @return
     */
    public static String getRandomFileName() {
        // get a random 5 digit num
        // 0 - 99999
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());

        return nowTimeStr + rannum;
    }

    /**
     * generate target addr
     * example: /home/work/alan/xxx.jpg
     * make it as the current path
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if(!dirPath.exists()) {
            dirPath.mkdirs();
        }
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
