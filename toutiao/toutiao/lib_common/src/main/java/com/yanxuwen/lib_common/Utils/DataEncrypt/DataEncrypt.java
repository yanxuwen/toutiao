package com.yanxuwen.lib_common.Utils.DataEncrypt;

import android.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by babyt on 2017/5/11.
 * 数据加密
 */
public class DataEncrypt {
    //MD5加密
    public static String getMd5(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }

    //SHA1 加密实例
    public static String encryptToSHA(String info) {
        MessageDigest md = null;
        String strDes = null;
        byte[] bt = info.getBytes();
        try {
            md = MessageDigest.getInstance("SHA-1");// 将此换成SHA-1、SHA-512、SHA-384等参数
            md.update(bt);
            strDes = byte2hex(md.digest());
            //加密后并转换为Base64
            strDes =Base64(strDes,true);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }

    private static String byte2hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
    /**
     * Base64的转换
     * is16 是否是16进制
     */
    public static String Base64(String str,boolean is16) {
        String  base64 =null;
        try{
            base64 = new String(Base64.encode(is16?(HexStr.hexStringToBytes(str)):str.getBytes(), Base64.NO_WRAP));
        }catch (Exception E){}
        return base64;
    }

    /**
     * Base64解密
     */
    public static String Base64ToString(String str) {
        String enToStr = Base64.encodeToString(str.getBytes(), Base64.NO_WRAP);
        return enToStr;
    }

}
