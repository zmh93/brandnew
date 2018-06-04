package com.brandnew.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class FileOperateUtil {

    /**
     * 将某文件夹下所有有关的文件copy到指定位置
     *
     * @createDate 2018/5/30
     */
    public static void inspectSomeFile(String fromDir,String reg,String aimDir) {
        inspectMd(new File(fromDir),reg,new File(aimDir));
    }

    private static void inspectMd(File inspctFile, String reg, File aimDir) {
        if (inspctFile.isDirectory()) {
            File[] files = inspctFile.listFiles();
            if (files != null && files.length > 0) {
                Arrays.stream(files).forEach(file -> inspectMd(file, reg, aimDir));
            }
        } else {
            if (inspctFile.getName().endsWith(reg)) {
                try {
                    FileCopyUtils.copy(inspctFile, new File(aimDir, inspctFile.getName()));
                } catch (IOException e) {
                    log.error("copy inspctFile failed...,inspctFileName:{},exceptionInfo:{}", inspctFile.getName(), e.getMessage());
                }
            }
        }
    }

    /**
     *  文件夹批量删除操作
     * @createDate 2018/6/4
     */
    public static void deleteSpecDir(File file, List<String> reg) {
        String absolutePath = file.getAbsolutePath();
        if (checkFileName(file.getName(),reg)) {
            FileSystemUtils.deleteRecursively(file);
            log.warn("delete {} successive",absolutePath);
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files!=null && files.length > 0) {
                Arrays.stream(files).forEach(f -> deleteSpecDir(f,reg));
            }
        }
    }

    private static boolean checkFileName(String name, List<String> reg) {
        for (String s : reg) {
            if (name.equals(s)) {
                return true;
            }
        }
        return false;
    }
}
