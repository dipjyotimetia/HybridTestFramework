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

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Utility class for Android-related operations.
 *
 * @author Dipjyoti Metia
 */
@Slf4j
public class Android {

    private static String OS;
    private static String ANDROID_HOME;

    /**
     * Get the path to the Android SDK directory.
     *
     * @return Android SDK path
     */
    public static String getAndroidHome() {
        if (ANDROID_HOME == null) {
            ANDROID_HOME = System.getenv("ANDROID_HOME");
            if (ANDROID_HOME == null)
                log.error("Failed to find ANDROID_HOME, make sure the environment variable is set");
        }
        return ANDROID_HOME;
    }

    /**
     * Get the operating system name.
     *
     * @return OS name
     */
    public static String getOS() {
        if (OS == null) OS = System.getenv("os.name");
        return OS;
    }

    /**
     * Check if the operating system is Windows.
     *
     * @return true if Windows, false otherwise
     */
    public static boolean isWindows() {
        return getOS().startsWith("Windows");
    }

    /**
     * Check if the operating system is macOS.
     *
     * @return true if macOS, false otherwise
     */
    public static boolean isMac() {
        return getOS().startsWith("Mac");
    }

    /**
     * Run a command and return its output.
     *
     * @param command Command to run
     * @return Command output
     * @throws Exception if an error occurs
     */
    public static String runCommand(String command) throws Exception {
        String output = null;
        try {
            Scanner scanner = new Scanner(Runtime.getRuntime().exec(command).getInputStream()).useDelimiter("\\A");
            if (scanner.hasNext()) output = scanner.next();
        } catch (IOException e) {
            log.error("Error executing command: " + command);
        }
        return output;
    }

    /**
     * Get the current working directory.
     *
     * @return Current working directory
     */
    public static String getWorkingDir() {
        return System.getProperty("user.dir");
    }

    /**
     * Read the contents of a file.
     *
     * @param file File to read
     * @return File contents
     */
    public static String read(File file) {
        StringBuilder output = new StringBuilder();
        try {
            String line;
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) output.append(line).append("\n");
            bufferedReader.close();
        } catch (IOException error) {
            log.error("Error reading file: " + error.getMessage());
        }
        return output.toString();
    }

    /**
     * Write content to a file.
     *
     * @param file    File to write
     * @param content Content to write
     */
    public static void write(File file, String content) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            writer.write(content);
        } catch (IOException error) {
            log.error("Error writing to file: " + error.getMessage());
        }
    }
}
