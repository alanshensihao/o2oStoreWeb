package com.imooc.o2o.util;

public class PathUtil {
    private static String separator = System.getProperty("file.separator");

    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        // usually images are saved on another server and retreived using url
        // here it is a sample project
        if(os.toLowerCase().startsWith("win")) {
            basePath = "B://VS_Project/Java/eCommerce/image";
        } else {
            basePath = "/home/alan/image/";
        }

        basePath = basePath.replace("/", separator);
        return basePath;
    }

    public static String getShopImagePath(long shopId) {
        String imagePath = "/upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", separator);
    }
}
