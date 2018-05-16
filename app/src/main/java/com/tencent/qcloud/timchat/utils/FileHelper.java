package com.tencent.qcloud.timchat.utils;

/**
 * Created by gdboy on 2018/1/5.
 */

import android.content.Context;
import android.content.res.AssetManager;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Created by Lin on 2016/7/2.
 */
public class FileHelper
{
    public static boolean isFileExists(String path)
    {
        File file = new File(path);
        return file.exists() && file.isFile();
    }

    public static boolean isDirectoryExists(String path)
    {
        File file = new File(path);
        return file.exists() && file.isDirectory();
    }

    public static void deleteFile(String path)
    {
        if(isFileExists(path))
            new File(path).delete();
    }

    public static void deleteDirectory(String path)
    {
        if(isDirectoryExists(path))
            deleteRecursive(new File(path));
    }

    private static void deleteRecursive(File fileOrDirectory)
    {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                deleteRecursive(child);

        fileOrDirectory.delete();
    }

    public static  boolean createDirectory(String path)
    {
        File file = new File(path);
        return file.mkdirs();
    }

    public static String readFileToString(String path)
    {
        return readFileToString(new File(path));
    }

    public static String readFileToString(File file)
    {
        try
        {
            return FileUtils.readFileToString(file, "utf-8");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return "";
    }

    public static byte[] readFileToByteArray(String path)
    {
        return readFileToByteArray(new File(path));
    }

    public static byte[] readFileToByteArray(File file)
    {
        try
        {
            return FileUtils.readFileToByteArray(file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static void writeStringToFile(String path, String data)
    {
        writeStringToFile(new File(path), data);
    }

    public static void writeStringToFile(File file, String data)
    {
        try
        {
            FileUtils.writeStringToFile(file, data);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void writeByteArrayToFile(String path, byte[] data)
    {
        writeByteArrayToFile(new File(path), data);
    }

    public static void writeByteArrayToFile(File file, byte[] data)
    {
        try
        {
            FileUtils.writeByteArrayToFile(file, data);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
