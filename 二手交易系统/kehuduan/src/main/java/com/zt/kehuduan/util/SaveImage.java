package com.zt.kehuduan.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class SaveImage {

    public static String saveGoodsImage(MultipartFile file, String goods_id) throws IOException {
        String filename = file.getOriginalFilename();

        filename = goods_id + filename.substring(filename.lastIndexOf("."), filename.length());
        //写入本地磁盘
        InputStream is = file.getInputStream();
        //不超过10M
        byte[] bs = new byte[1024*1024*10];
        int len = 0;
        OutputStream os = new FileOutputStream(new File("src/main/resources/static/goods/" + filename));
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        os.close();
        is.close();
        return "/static/goods/" +filename;
    }

    public static String saveUserImage(MultipartFile file, String user_id) throws IOException {
        String filename = file.getOriginalFilename();

        filename = user_id + filename.substring(filename.lastIndexOf("."), filename.length());
        //写入本地磁盘
        InputStream is = file.getInputStream();
        //不超过10M
        byte[] bs = new byte[1024*1024*10];
        int len = 0;
        OutputStream os = new FileOutputStream(new File("src/main/resources/static/user/" + filename));
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        os.close();
        is.close();
        return "/static/user/" +filename;
    }

    public static boolean deleteUserImage(String imagePath) {
        imagePath = "src/main/resources"+imagePath;
        File file = new File(imagePath);

        if(file.exists()) {
            file.delete();
            return true;
        }
        return false;
    }

    public static boolean deleteGoodsImage(String imagePath) {
        imagePath = "src/main/resources"+imagePath;

        File file = new File(imagePath);

        if(file.exists()) {
            file.delete();
            return true;
        }
        return false;
    }
}
