package com.finance.util;

import com.finance.exception.utils.FileUtilsException;

import java.io.File;
import java.io.IOException;

/**
 * File utils.
 */
public class FileUtils {
    public static void createDirectory(String directoryPath) throws IOException {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            boolean success = directory.mkdirs();
            if (!success) {
                throw new FileUtilsException("Failed to create directory: " + directoryPath);
            }
        }
    }

    public static void deleteDirectory(String directoryPath) throws IOException {
        File directory = new File(directoryPath);
        if (directory.exists()) {
            deleteFileOrDirectory(directory);
        }
    }

    private static void deleteFileOrDirectory(File file) throws IOException {
        if (file.isDirectory()) {
            for (File subFile : file.listFiles()) {
                deleteFileOrDirectory(subFile);
            }
        }
        boolean success = file.delete();
        if (!success) {
            throw new FileUtilsException("Failed to delete file or directory: " + file.getAbsolutePath());
        }
    }

    public static void copyFile(String sourceFilePath, String destinationFilePath) throws IOException {
        File sourceFile = new File(sourceFilePath);
        File destinationFile = new File(destinationFilePath);
        java.nio.file.Files.copy(sourceFile.toPath(), destinationFile.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
    }
}
