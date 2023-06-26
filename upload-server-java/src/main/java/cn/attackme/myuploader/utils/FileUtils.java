package cn.attackme.myuploader.utils;


import java.io.*;
import java.util.UUID;

/**
 * 檔案操作工具類
 */
public class FileUtils {

    /**
     * 寫入檔案
     * @param target
     * @param src
     * @throws IOException
     */
    public static void write(String target, InputStream src) throws IOException {
        OutputStream os = new FileOutputStream(target);
        byte[] buf = new byte[1024];
        int len;
        while (-1 != (len = src.read(buf))) {
            os.write(buf,0,len);
        }
        os.flush();
        os.close();
    }

    /**
     * 分塊寫入檔案
     * @param target
     * @param targetSize
     * @param src
     * @param srcSize
     * @param chunks
     * @param chunk
     * @throws IOException
     */
    public static void writeWithBlok(String target, Long targetSize, InputStream src, Long srcSize, Integer chunks, Integer chunk) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(target,"rw");
        randomAccessFile.setLength(targetSize);
        if (chunk == chunks - 1) {
            randomAccessFile.seek(targetSize - srcSize);
        } else {
            randomAccessFile.seek(chunk * srcSize);
        }
        byte[] buf = new byte[1024];
        int len;
        while (-1 != (len = src.read(buf))) {
            randomAccessFile.write(buf,0,len);
        }
        randomAccessFile.close();
    }

    /**
     * 生成隨機檔案名
     * @return
     */
    public static String generateFileName() {
        return UUID.randomUUID().toString();
    }
}
