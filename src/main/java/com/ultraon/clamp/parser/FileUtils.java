package com.ultraon.clamp.parser;

import java.io.File;

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

}
