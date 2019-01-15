package com.Utils;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Utils for file system operations.
 */
public class FileSystem {

    private static Logger logger = LogManager.getLogger(FileSystem.class);

    public static void downloadDriver(){
        String fromFile="https://chromedriver.storage.googleapis.com/2.45/chromedriver_win32.zip";
        String toFile = "Driver/chromedriver.zip";
        try {
            FileUtils.copyURLToFile(new URL(fromFile), new File(toFile), 10000, 10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void unzip(){
        String source = "Driver/chromedriver.zip";
        String destination = "Driver";

        try {
            ZipFile zipFile = new ZipFile(source);
            zipFile.extractAll(destination);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete file path.
     *
     * @param path Path to file for folder.
     * @throws IOException When fail to delete it.
     */
    public static void deletePath(String path) throws IOException {
        try {
            File file = new File(path);
            if (file.isDirectory()) {
                FileUtils.deleteDirectory(file);
            } else {
                file.delete();
            }
            logger.info("Delete " + path);
        } catch (Exception e) {
            String errorMessage = "Failed to delete " + path;
            logger.fatal(errorMessage);
            throw new IOException(errorMessage);
        }
    }

    /**
     * Read content of file.
     *
     * @param filePath File path as String.
     * @return Content of file as String.
     * @throws IOException When fail to read file.
     */
    public static String readFile(String filePath) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(filePath));
        return new String(encoded, Charset.defaultCharset());
    }

    /**
     * Append content of String to file.
     *
     * @param filePath File path as String.
     * @param text     Content to be written in file.
     * @throws IOException When fail to write in file.
     */
    public static void appendFile(String filePath, String text) throws IOException {
        FileUtils.writeStringToFile(new File(filePath), text, "UTF-8",true);
    }

    /**
     * Write content of String to file.
     *
     * @param filePath File path as String.
     * @param text     Content to be written in file.
     * @throws IOException When fail to write in file.
     */
    public static void writeFile(String filePath, String text) throws IOException {
        FileUtils.writeStringToFile(new File(filePath), text,"UTF-8");
    }

    /**
     * Check if path exists.
     *
     * @param path Path as String.
     * @return True if path exists. False if path does not exist.
     */
    public static boolean exist(String path) {
        File file = new File(path);
        return file.exists();
    }

    /**
     * Ensure path exists (create if does not exists).
     *
     * @param directory Path to directory.
     */
    public static void ensureFolderExists(String directory) {
        File file = new File(directory);
        if (!file.exists()) {
            boolean result = file.mkdirs();
            if (!result) {
                logger.error("Failed to create folder: " + directory);
            }
        }
    }

    /**
     * Get size of file.
     *
     * @param path Path to file.
     * @return Size of file in kB.
     */
    public static long getFileSize(String path) {
        File file;
        long size = 0;
        file = new File(path);
        if (file.exists()) {
            size = file.length() / 1024; // In KBs
        } else {
            Assert.fail("File '" + file + "' does not exist!");
        }
        return size;
    }

    public static void writeCsvFile(String storageFilePath, String log, String header) {
        FileSystem.ensureFolderExists(new File(storageFilePath).getParent());

        try {
            if (FileSystem.exist(storageFilePath)) {
                FileSystem.appendFile(storageFilePath, System.lineSeparator() + log);
            } else {
                String content = header + System.lineSeparator() + log;
                FileSystem.writeFile(storageFilePath, content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}