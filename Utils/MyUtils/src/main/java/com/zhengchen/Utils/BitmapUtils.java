package com.zhengchen.Utils;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Environment;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yanxuwen on 2017/6/5.
 */

public class BitmapUtils {
    /**
     * 将压缩的bitmap保存到SDCard卡临时文件夹，用于上传
     * 默认压缩为该控件大小
     */
    public static File saveMyBitmap(String path,String name, Bitmap bit,View v) {
       return saveMyBitmap(path,name,bit,v,1);
    }

    public static File saveMyBitmap(String path,String name, Bitmap bit) {
        return saveMyBitmap(path,name,bit,null,1);
    }
    /**
     * 将压缩的bitmap保存到SDCard卡临时文件夹，用于上传
     * @param bit
     * @param scale 压缩大小为该控件大小的的N倍，主要用于放大后不失真
     */
    public static File saveMyBitmap(String path,String name, Bitmap bit,View v,int scale) {
        File file=new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        String picName=name;
        final File f = new File(file.getPath(), picName);
        Bitmap compress_bm = bit;
        if(v!=null){
            compress_bm=ThumbnailUtils.extractThumbnail(bit, v.getWidth()*scale, v.getHeight()*scale);
        }
        try {
            FileOutputStream fOut = null;
            fOut = new FileOutputStream(f);
            compress_bm.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return f;
    }
    public static File saveMyBitmap(String path,String name, Bitmap bit,int width, int height) {
        File file=new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        String picName=name;
        final File f = new File(file.getPath(), picName);
        Bitmap compress_bm = bit;
        compress_bm=ThumbnailUtils.extractThumbnail(bit, width, height);
        try {
            FileOutputStream fOut = null;
            fOut = new FileOutputStream(f);
            compress_bm.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return f;
    }
    /**
     * @param file 删除文件以及删除文件夹
     */
    public static void deleteFile(File file) {
        if (file.exists()) { // 判断文件是否存在
            if (file.isFile()) { // 判断是否是文件
                file.delete(); // delete()方法 你应该知道 是删除的意思;
            } else if (file.isDirectory()) { // 否则如果它是一个目录
                File files[] = file.listFiles(); // 声明目录下所有的文件 files[];
                for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
                    deleteFile(files[i]); // 把每个文件 用这个方法进行迭代
                }
            }
            file.delete();
        } else {
        }
    }
//    /**
//     * 压缩上传路径
//     * @param path
//     * @return
//     */
//    public static String compressImageUpload(String path) {
//        String filename = path.substring(path.lastIndexOf("/") + 1);
//        Bitmap image = getImage(path);
//        return saveMyBitmap(filename, image);
//    }


    /**
     * 清除缓存文件
     */
    public static void deleteCacheFile(){
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/laopai/");
        RecursionDeleteFile(file);
    }
    /**
     * 递归删除
     */
    private static void RecursionDeleteFile(File file){
        if(file.isFile()){
            file.delete();
            return;
        }
        if(file.isDirectory()){
            File[] childFile = file.listFiles();
            if(childFile == null || childFile.length == 0){
                file.delete();
                return;
            }
            for(File f : childFile){
                RecursionDeleteFile(f);
            }
            file.delete();
        }
    }
}
