package com.jun.utils;


import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SysUtils {

    static final String salt = "a1873d7d37216cb6";
    private static Logger logger = LoggerFactory.getLogger(SysUtils.class);


    /**
     * 对密码进行摘要加密
     * @param plainPassword
     * @return
     */
    public static String encryptPassword(String plainPassword) {
        return md5(plainPassword + salt);
    }

    public static String md5(String src) {
        byte[] md5 = DigestUtils.md5((src).getBytes());
        if (md5 == null) {
            return null;
        }
        return new String(Hex.encodeHex(md5));
    }

    public static String getSysParam(String key) {
        String ret = System.getenv(key);
        if (StringUtils.isBlank(ret)) {
            ret = System.getProperty(key);
        }
        return ret;
    }



    /**
     * 得到当前年
     *
     * @return
     * @deprecated
     */
    public static Integer getCurrnentYear() {
        Calendar cal = Calendar.getInstance();//使用日历类
        return cal.get(Calendar.YEAR);//得到年
    }

    /**
     * 得到当前月
     *
     * @return
     * @deprecated
     */
    public static Integer getCurrnentMonth() {
        Calendar cal = Calendar.getInstance();//使用日历类
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 字符串转码成ISO-8859-1
     *
     * @param str
     * @return
     */
    public static String parseGBK(String str) {
        if (StringUtils.isAnyBlank(str)) {
            return str;
        }
        try {
            return new String(str.getBytes("GBK"), "ISO-8859-1");
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /**
     * 字符串转码成ISO-8859-1
     *
     * @param str
     * @return
     */
    public static String parseEncoding(String str, String charset) {
        try {
            return new String(str.getBytes(charset), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }






    /**
     * @param from
     * @param to
     * @param isFrom
     * @return MM.dd
     */
    public static String getCheckOnWorkStr(String from, String to, boolean isFrom, int num, String dateFormat) {
        int fromDay = Integer.parseInt(from);
        int toDay = Integer.parseInt(to);

        Calendar calendar = Calendar.getInstance();
        if (num != 0) {
            calendar.add(Calendar.MONTH, num);
        }
        if (999 == toDay) {
            if (isFrom) {
                calendar.set(Calendar.DAY_OF_MONTH, 1);
            } else {
                int day = calendar.getActualMaximum(Calendar.DATE);
                calendar.set(Calendar.DAY_OF_MONTH, day);
            }
        } else {
            Calendar c = Calendar.getInstance();
            c.get(Calendar.DATE);
            int currentDay = c.get(Calendar.DATE);
            if (currentDay >= fromDay) {
                if (isFrom) {
                    calendar.set(Calendar.DAY_OF_MONTH, fromDay);
                } else {
                    calendar.add(Calendar.MONTH, 1);
                    calendar.set(Calendar.DAY_OF_MONTH, toDay);
                }
            } else {
                if (isFrom) {
                    calendar.add(Calendar.MONTH, -1);
                    calendar.set(Calendar.DAY_OF_MONTH, fromDay);
                } else {
                    calendar.set(Calendar.DAY_OF_MONTH, toDay);
                }
            }
        }

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        SimpleDateFormat tempFormat = new SimpleDateFormat(dateFormat);
        return tempFormat.format(calendar.getTime());
    }


    public static String truncValue(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        return str;
    }

    public static String getFixLengthStr(String resource,int length){
        try {
            if (StringUtils.isBlank(resource)) {
                return null;
            }
            if (resource.length() > length) {
                return resource.substring(0, length);
            } else {
                return resource;
            }
        }catch(Exception e){
            return null;
        }
    }


    public static Boolean checkParam(Object... params) {
        for (Object param : params) {
            if (null == param || StringUtils.isAnyBlank(param.toString())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符集转化
     * @param sourceCode
     * @param targetCode
     * @return
     */
    public static String parseCode(String msg,String sourceCode,String targetCode){
        try {
            byte[] unicode = msg.getBytes(sourceCode);
            String ss = new String(unicode,targetCode);
            return ss;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] getBytes(String filePath){
        byte[] buffer = null;
        FileInputStream fis = null;
        ByteArrayOutputStream bos = null;
        try {
            fis = new FileInputStream(new File(filePath));
            bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (bos != null) {
                    bos.flush();
                    fis.close();
                }
            }catch (Exception e){

            }
        }
        return buffer;
    }

    public static int compareString(String version,String standardVersion,String splitStr){
        if(StringUtils.isBlank(version) || StringUtils.isBlank(standardVersion)){
            return 0;
        }
        String[] versions = version.split(splitStr);
        String[] standardVersions = standardVersion.split(splitStr);

        if(versions.length>standardVersions.length){
            for(int i=0;i<standardVersions.length;i++){
                if(Integer.valueOf(versions[i]).intValue() > Integer.valueOf(standardVersions[i]).intValue()){//当前版本的该位置大于标准版本的该位置
                    return 1;
                }
                if(Integer.valueOf(versions[i]).intValue() < Integer.valueOf(standardVersions[i]).intValue()){//当前版本的该位置小于标准版本的该位置
                    return -1;
                }
            }
            return 1;
        }else if(versions.length < standardVersions.length){
            for(int i=0;i<versions.length;i++){
                if(Integer.valueOf(versions[i]).intValue() > Integer.valueOf(standardVersions[i]).intValue()){//当前版本的该位置大于标准版本的该位置
                    return 1;
                }
                if(Integer.valueOf(versions[i]).intValue() < Integer.valueOf(standardVersions[i]).intValue()){//当前版本的该位置小于标准版本的该位置
                    return -1;
                }
            }
            return -1;
        }else{
            for(int i=0;i<versions.length;i++){
                if(Integer.valueOf(versions[i]).intValue() > Integer.valueOf(standardVersions[i]).intValue()){//当前版本的该位置大于标准版本的该位置
                    return 1;
                }
                if(Integer.valueOf(versions[i]).intValue() < Integer.valueOf(standardVersions[i]).intValue()){//当前版本的该位置小于标准版本的该位置
                    return -1;
                }
            }
            return 0;
        }
    }



    public static String generateListImgStr(String img) {
        return StringUtils.isEmpty(img) ? "" : String.format("<img src='%s' style='width:100px;height:100px;'>", img);
    }

    public static String getStringEndWith(String msg,String split) {
        try {
            if (StringUtils.isBlank(msg)) {
                return "";
            }
            String[] ss = msg.split(split);
            return ss[0];
        }catch (Exception e){
            logger.error("generateListImgStr error",e);
            return "";
        }
    }


}