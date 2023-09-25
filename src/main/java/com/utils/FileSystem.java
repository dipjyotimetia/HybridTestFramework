/*
MIT License

Copyright (c) 2023 Dipjyoti Metia

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

import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.ZipFile;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Utils for file system operations.
 */
@Slf4j
public class FileSystem {

    /**
     * Check if a path exists.
     *
     * @param path Path as a String.
     * @return True if the path exists, False if the path does not exist.
     */
    public static boolean exists(String path) {
        File file = new File(path);
        return file.exists();
    }

    /**
     * Ensure that a folder exists (create it if it does not exist).
     *
     * @param directory Path to the directory.
     */
    public static void ensureFolderExists(String directory) {
        File file = new File(directory);
        if (!file.exists()) {
            boolean result = file.mkdirs();
            if (!result) {
                log.error("Failed to create folder: " + directory);
            }
        }
    }

    /**
     * Unzip a file.
     *
     * @param source      Source file path.
     * @param destination Destination folder path.
     */
    private void unzip(String source, String destination) {
        try {
            ZipFile zipFile = new ZipFile(source);
            zipFile.extractAll(destination);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * Delete a file or folder.
     *
     * @param path Path to the file or folder to be deleted.
     */
    public void deletePath(String path) {
        try {
            File file = new File(path);
            if (file.isDirectory()) {
                FileUtils.deleteDirectory(file);
            } else {
                file.delete();
            }
            log.info("Deleted " + path);
        } catch (Exception e) {
            log.error("Failed to delete " + path);
        }
    }

    /**
     * Read the content of a file.
     *
     * @param filePath File path as a String.
     * @return Content of the file as a String.
     * @throws IOException When failed to read the file.
     */
    public String readFile(String filePath) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(filePath));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    /**
     * Get the size of a file.
     *
     * @param path Path to the file.
     * @return Size of the file in kilobytes (KB).
     */
    public long getFileSize(String path) {
        File file = new File(path);
        if (file.exists()) {
            return file.length() / 1024; // In KBs
        } else {
            Assert.fail("File '" + file + "' does not exist!");
            return 0;
        }
    }
}
