package cn.attackme.myuploader.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.attackme.myuploader.utils.LogUtils.logToFile;

/**
 * 測試日誌功能
 */
@RestController
@RequestMapping("/Ex")
public class TestExceptionController {
    /**
     * 測試日誌切面
     * @return
     */
    @GetMapping("/aspect")
    public int aspect() {
        int i = 1 / 0;
        return i;
    }

    /**
     * 測試日誌util
     */
    @GetMapping("/util")
    public void util() {
        try {
            System.out.println(1/0);
        } catch (Exception e) {
            logToFile(e);
        }
    }
}
