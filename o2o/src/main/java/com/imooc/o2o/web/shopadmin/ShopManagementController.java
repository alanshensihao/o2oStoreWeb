package com.imooc.o2o.web.shopadmin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.service.ShopService;
import com.imooc.o2o.util.HttpServletRequestUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
    @Autowired
    private ShopService shopService;

    @RequestMapping("/registershop, method = RequestMethod.POST")
    @ResponseBody
    private Map<String, Object> registerShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        // 1. receive data and convert to parameters, including shop info and pictures
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        try {
            shop = mapper.readValue(shopStr, Shop.class);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }

        // image
        // file upload
        CommonsMultipartFile shopImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
            request.getSession().getServletContext());

        if (commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "uploaded picture cannot be empty");
            return modelMap;
        }

        // 2. register shop
        if (shop != null && shopImg != null) {
            PersonInfo owner = new PersonInfo();
            // TODO: owner 
            owner.setUserId(1L);
            shop.setOwner(owner);
            
            // File shopImgFile = new File(PathUtil.getImgBasePath() + ImageUtil.getRandomFileName());
            // try {
            //     shopImgFile.createNewFile();
            // } catch (IOException e) {
            //     modelMap.put("success", false);
            //     modelMap.put("errMsg", e.getMessage());
            //     return modelMap;
            // }
            
            // try {
            //     inputStreamToFile(shopImg.getInputStream(), shopImgFile);
            // } catch (IOException e) {
            //     modelMap.put("success", false);
            //     modelMap.put("errMsg", e.getMessage());
            //     return modelMap;                
            // }

            ShopExecution se;
            try {
                se = shopService.addShop(shop, shopImg.getInputStream(), shopImg.getOriginalFilename());
                if (se.getState() == ShopStateEnum.CHECK.getState()) {
                    modelMap.put("success", true);
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", se.getStateInfo());
                }
            } catch (IOException e) {
                modelMap.put("success", false);
                e.printStackTrace();
            }
            return modelMap;
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "please enter shop info and upload pictures");
            return modelMap;          
        }

        // 3. return results
    }

    // private static void inputStreamToFile(InputStream ins, File file) {
    //     OutputStream os = null;
    //     try {
    //         os = new FileOutputStream(file);
    //         int bytesRead = 0;
    //         byte[] buffer = new byte[1024];
    //         while ((bytesRead = ins.read(buffer)) != -1) {
    //             os.write(buffer, 0, bytesRead);
    //         }
    //     } catch (Exception e) {
    //         throw new RuntimeException("inputStreamToFile exception: " + e.getMessage());
    //     } finally {
    //         try {
    //             if (os != null) {
    //                 os.close();
    //             }
    //             if (ins != null) {
    //                 ins.close();
    //             }
    //         } catch (IOException e) {
    //             throw new RuntimeException("inputStreamtoFile exception when close: " + e.getMessage());
    //         }
    //     }
    // }
}
