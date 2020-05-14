/*
MIT License

Copyright (c) 2020 Dipjyoti Metia

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package com.utils;

import net.lingala.zip4j.ZipFile;
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
 * utils for file system operations.
 */
public class FileSystem {

    private static final Logger logger = LogManager.getLogger(FileSystem.class);

    public void downloadDriver() throws Exception{
        String fromFile = "https://chromedriver.storage.googleapis.com/81.0.4044.138/chromedriver_win32.zip";
        String toFile = "Driver/chromedriver.zip";
        String destination = "Driver";
        try {
            FileUtils.copyURLToFile(new URL(fromFile), new File(toFile), 10000, 10000);
            unzip(toFile, destination);
            Thread.sleep(3000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void unzip(String source, String destination) {
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
        FileUtils.writeStringToFile(new File(filePath), text, "UTF-8", true);
    }

    /**
     * Write content of String to file.
     *
     * @param filePath File path as String.
     * @param text     Content to be written in file.
     * @throws IOException When fail to write in file.
     */
    public static void writeFile(String filePath, String text) throws IOException {
        FileUtils.writeStringToFile(new File(filePath), text, "UTF-8");
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