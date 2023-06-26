package cn.attackme.myuploader.dao;

import cn.attackme.myuploader.model.File;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileDao {
    /**
     * 通過主鍵獲取一行數據
     * @return
     */
    File getById(Long id);

    /**
     * 插入一行數據
     * @param file
     * @return
     */
    int save(File file);

    /**
     * 更新一行數據
     * @param file
     * @return
     */
    int update(File file);

    /**
     * 刪除一行數據
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根據一個或多個屬性獲取File
     * @param file
     * @return
     */
    File getByFile(File file);
}
