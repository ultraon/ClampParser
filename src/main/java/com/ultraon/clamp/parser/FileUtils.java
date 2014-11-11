package com.ultraon.clamp.parser;

import java.io.File;
import java.io.IOException;

/**
 * Created by vitaliypopov on 10.11.14.
 */
public class FileUtils {
    public static boolean isExistFile(final String filePath) {
        return new File(filePath).isFile();
    }

    public static boolean isExistDir(final String dirPath) {
        return new File(dirPath).isDirectory();
    }

    public static boolean mkdir(final String dirPath) {
        return new File(dirPath).mkdirs();
    }


    public static void deleteDirectory(final String dirPath) throws IOException {
        org.apache.commons.io.FileUtils.deleteDirectory(new File(dirPath));
    }
}
