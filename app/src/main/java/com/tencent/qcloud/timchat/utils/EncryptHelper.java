package com.tencent.qcloud.timchat.utils;

/**
 * Created by gdboy on 2018/1/5.
 */

public class EncryptHelper {

    private static byte[] key = "3B950A52-C7CC-41AD-88F2-36EB31820A10".getBytes();

    public static String encryption(String text){
        return xor(text);
    }

    public static String decryption(String text){
        return xor(text);
    }

    public static byte[] encryption(byte[] data){
        return xor(data);
    }

    public static byte[] decryption(byte[] data){
        return xor(data);
    }

    public static String xor(String text){

        if(text == null || text.length() == 0)
            return text;

        byte[] data = xor(text.getBytes());
        return new String(data);
    }

    public static byte[] xor(byte[] data){

        if(data == null || data.length == 0)
            return data;

        byte[] result = new byte[data.length];

        for (int i = 0; i < data.length; i++) {
            byte b = (byte)(data[i] ^ key[i % key.length]);
            if (b != 0)
                result[i] = b;
            else
                result[i] = data[i];
        }

        return result;
    }
}
