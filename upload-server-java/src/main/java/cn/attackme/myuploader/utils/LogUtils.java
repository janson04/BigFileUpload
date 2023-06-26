package cn.attackme.myuploader.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

import java.util.Date;

/**
 * 日志工具类
 */
@Slf4j
public class LogUtils {

    /**
     * 日誌輸出到檔案
     * @param ex
     */
    public static void logToFile(Exception ex) {
        StackTraceElement stackTraceElement = ex.getStackTrace()[0];
        //出错行
        int lineNumber = stackTraceElement.getLineNumber();
        //类名
        String className = stackTraceElement.getClassName();
        //方法名
        String methodName = stackTraceElement.getMethodName();
        log.error("方法:" + className + "." + methodName + " | " +
                "參數:" + stackTraceElement + " | " + "錯誤行：" + lineNumber + " | " +
                "時間:" + " | " + new Date() + " | " + "異常內容:" + ex.toString()
        );
    }

    /**
     * 日誌輸出到檔案，提供給日誌切面
     * @param joinPoint
     * @param ex
     */
    public static void logToFile(JoinPoint joinPoint, Throwable ex) {
        //出错行
        int lineNumber = ex.getStackTrace()[0].getLineNumber();
        //方法签名
        Signature signature = joinPoint.getSignature();
        //参数
        Object[] args = joinPoint.getArgs();
        StringBuilder builder = new StringBuilder();
        if (args.length > 0) {
            for (Object o : args) {
                builder.append(o);
            }
        }
        log.error("方法:" + signature + " | " + "參數:" + builder.toString() +
                " | " + "錯誤行：" + lineNumber + " | " + "時間:" + new Date() +
                " | " + "異常內容:" + ex.toString()
        );
    }
}
