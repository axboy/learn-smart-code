package cn.axboy.smart.chapter4.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/20 11:19
 * URL编码、解码工具类
 */
public final class CodecUtil {

    /**
     * 将url编码
     */
    public static String encodeURL(String source) {
        try {
            return URLEncoder.encode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将url解码
     */
    public static String decodeURL(String source) {
        try {
            return URLDecoder.decode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将字符串md5加密
     */
    public static String md5(String source){
        return md5(source.getBytes());
    }

    /**
     * 获取md5值
     */
    public static String md5(byte[] bytes) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(bytes, 0, bytes.length);
        BigInteger bigInt = new BigInteger(1, digest.digest());
        return bigInt.toString(16);
    }
}
