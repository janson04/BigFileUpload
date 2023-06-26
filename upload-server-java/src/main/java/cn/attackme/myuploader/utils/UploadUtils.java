package cn.attackme.myuploader.utils;

import java.util.HashMap;
import java.util.Map;

import static cn.attackme.myuploader.utils.FileUtils.generateFileName;

/**
 * 分塊上傳工具類
 */
public class UploadUtils {
    /**
     * 內部類記錄分塊上傳檔案訊息
     */
    private static class Value {
        String name;
        boolean[] status;

        Value(int n) {
            this.name = generateFileName();
            this.status = new boolean[n];
        }
    }

    private static Map<String, Value> chunkMap = new HashMap<>();

    /**
     * 判斷檔案所有分塊是否已上傳
     * @param key
     * @return
     */
    public static boolean isUploaded(String key) {
        if (isExist(key)) {
            for (boolean b : chunkMap.get(key).status) {
                if (!b) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 判斷檔案是否有分塊已上傳
     * @param key
     * @return
     */
    private static boolean isExist(String key) {
        return chunkMap.containsKey(key);
    }

    /**
     * 為檔案添加上傳分塊記錄
     * @param key
     * @param chunk
     */
    public static void addChunk(String key, int chunk) {
        chunkMap.get(key).status[chunk] = true;
    }

    /**
     * 從map中刪除鍵為key的鍵值對
     * @param key
     */
    public static void removeKey(String key) {
        if (isExist(key)) {
            chunkMap.remove(key);
        }
    }

    /**
     * 獲取隨機生成的檔案名
     * @param key
     * @param chunks
     * @return
     */
    public static String getFileName(String key, int chunks) {
        if (!isExist(key)) {
            synchronized (UploadUtils.class) {
                if (!isExist(key)) {
                    chunkMap.put(key, new Value(chunks));
                }
            }
        }
        return chunkMap.get(key).name;
    }
}
