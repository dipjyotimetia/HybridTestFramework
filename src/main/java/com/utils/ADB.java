/*
MIT License
Copyright (c) 2021 Dipjyoti Metia
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

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Dipjyoti Metia
 */
@Slf4j
public class ADB {

    private final String SDK_PATH = System.getenv("ANDROID_HOME");
    private final String ADB_PATH = SDK_PATH + "platform-tools" + File.separator + "adb";
    private final String EMULATOR_PATH = SDK_PATH + File.separator + "emulator";

    private final String ID;

    public ADB(String deviceID) {
        ID = deviceID;
    }

    /**
     * launch android emulator
     *
     * @param avdName emulator name
     */
    public void launchEmulator(String avdName) {
        log.info("Starting emulator for" + avdName + "....");
        String[] aCommand = new String[]{EMULATOR_PATH, "-avd", avdName};
        try {
            Process process = new ProcessBuilder(aCommand).start();
            process.waitFor(180, TimeUnit.SECONDS);
            log.info("Emulator launched successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * Close android emulator
     */
    public void closeEmulator() {
        log.info("Closing emulator");
        String[] aCommand = new String[]{EMULATOR_PATH, "emu", "kill"};
        try {
            Process process = new ProcessBuilder(aCommand).start();
            process.waitFor(1, TimeUnit.SECONDS);
            log.info("Emulator closed successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * avd commands
     *
     * @param command command
     * @return output
     */
    public String command(String command) throws Exception {
        log.debug("Formatting ADB Command: " + command);
        String newCommand = "";
        if (command.startsWith("adb"))
            newCommand = command.replace("adb ", Android.getAndroidHome() + "/platform-tools/adb ");
        else log.error("This method is designed to run ADB commands only!");
        log.debug("Formatted ADB Command: " + newCommand);
        String output = Android.runCommand(newCommand);
        log.debug("Output of the ADB Command: " + output);
        if (output == null) return "";
        else return output.trim();
    }

    public void killServer() throws Exception {
        command("adb kill-server");
    }

    public void startServer() throws Exception {
        command("adb start-server");
    }

    /**
     * Get list of connected device
     *
     * @return devices
     */
    public List<Object> getConnectedDevices() throws Exception {
        List<Object> devices = new ArrayList<>();
        String output = command("adb devices");
        for (String line : output.split("\n")) {
            line = line.trim();
            if (line.endsWith("device")) devices.add(line.replace("device", "").trim());
        }
        return devices;
    }

    /**
     * Get Foreground activity
     *
     * @return activity
     */
    public String getForegroundActivity() throws Exception {
        return command("adb -s " + ID + " shell dumpsys window windows | grep mCurrentFocus");
    }

    /**
     * Get android version
     *
     * @return version
     */
    public String getAndroidVersionAsString() throws Exception {
        String output = command("adb -s " + ID + " shell getprop ro.build.version.release");
        if (output.length() == 3) output += ".0";
        return output;
    }

    public int getAndroidVersion() throws Exception {
        return Integer.parseInt(getAndroidVersionAsString().replaceAll("\\.", ""));
    }

    /**
     * Get installed package
     *
     * @return packages
     */
    public List<Object> getInstalledPackages() throws Exception {
        List<Object> packages = new ArrayList<>();
        String[] output = command("adb -s " + ID + " shell pm list packages").split("\n");
        for (String packageID : output) packages.add(packageID.replace("package:", "").trim());
        return packages;
    }

    /**
     * Open apps activity
     *
     * @param packageID  package
     * @param activityID activity
     */
    public void openAppsActivity(String packageID, String activityID) throws Exception {
        command("adb -s " + ID + " shell am start -c api.android.intent.category.LAUNCHER -a api.android.intent.action.MAIN -n " + packageID + "/" + activityID);
        log.info("Open apps activity");
    }

    /**
     * Clear apps data
     *
     * @param packageID package
     */
    public void clearAppsData(String packageID) throws Exception {
        command("adb -s " + ID + " shell pm clear " + packageID);
        log.info("Clear apps data " + packageID);
    }

    /**
     * Force stop app
     *
     * @param packageID package
     */
    public void forceStopApp(String packageID) throws Exception {
        command("adb -s " + ID + " shell am force-stop " + packageID);
        log.info("Force stop app " + packageID);
    }

    /**
     * It let you change the level from 0 to 100
     *
     * @param level batteryLevel
     */
    public void setBatteryLevel(BatteryLevelEnum level) throws Exception {
        String status = "";

        switch (level) {
            case Unknown -> status = "1";
            case Charging -> status = "2";
            case Discharging -> status = "3";
            case NotCharging -> status = "4";
            case Full -> status = "5";
            default -> {
            }
        }
        command("adb -s" + ID + "dumpsys battery set level" + status);
        log.info("Battery status is changed to " + status);
    }

    /**
     * It let you change the level to Unknown, Charging, Discharging, Not Charging or Full.
     *
     * @param status batteryStatus
     */
    public void setBatteryStatus(String status) throws Exception {
        command("adb -s" + ID + "dumpsys battery set status" + status);
        log.info("Set battery status " + status);
    }

    /**
     * It let you reset the battery change made through adb.
     */
    public void setBatteryReset() throws Exception {
        command("adb -s" + ID + "dumpsys battery reset");
        log.info("Set battery reset");
    }

    /**
     * It let you change the status of USB connection. It can be ON or OFF
     *
     * @param val switch
     */
    public void setBatteryUSB(SwitchEnum val) throws Exception {
        String status = "";

        switch (val) {
            case ON:
                status = "1";
                break;
            case OFF:
                status = "0";
                break;
            default:
                break;
        }
        command("adb -s" + ID + "dumpsys battery set usb" + status);
        log.info("Device USB state is " + status);
    }

    /**
     * Install app
     *
     * @param apkPath apk path
     */
    public void installApp(String apkPath) throws Exception {
        command("adb -s " + ID + " install " + apkPath);
        log.info("App installed from path " + apkPath);
    }

    /**
     * Uninstall app
     *
     * @param packageID packageID
     */
    public void uninstallApp(String packageID) throws Exception {
        command("adb -s " + ID + " uninstall " + packageID);
        log.info("App uninstalled " + packageID);
    }

    /**
     * Clear log buffer
     */
    public void clearLogBuffer() throws Exception {
        command("adb -s " + ID + " shell -c");
        log.info("App log buffer cleared");
    }

    /**
     * Push file
     *
     * @param source source
     * @param target target
     */
    public void pushFile(String source, String target) throws Exception {
        command("adb -s " + ID + " push " + source + " " + target);
    }

    /**
     * Pull file
     *
     * @param source source
     * @param target target
     */
    public void pullFile(String source, String target) throws Exception {
        command("adb -s " + ID + " pull " + source + " " + target);
    }

    /**
     * Delete file
     *
     * @param target target
     */
    public void deleteFile(String target) throws Exception {
        command("adb -s " + ID + " shell rm " + target);
    }

    /**
     * Move file
     *
     * @param source source
     * @param target target
     */
    public void moveFile(String source, String target) throws Exception {
        command("adb -s " + ID + " shell mv " + source + " " + target);
    }

    /**
     * Take screenshot
     *
     * @param target target
     */
    public void takeScreenshot(String target) throws Exception {
        command("adb -s " + ID + " shell screenshot " + target);
        log.info("Take screenshot " + target);
    }

    /**
     * Reboot Device
     */
    public void rebootDevice() throws Exception {
        command("adb -s " + ID + " reboot");
    }

    /**
     * Get Device model
     *
     * @return device details
     */
    public String getDeviceModel() throws Exception {
        log.info("Get device model");
        return command("adb -s " + ID + " shell getprop ro.product.model");
    }

    /**
     * Get Device serial number
     *
     * @return serial number
     */
    public String getDeviceSerialNumber() throws Exception {
        log.info("Get device serial number");
        return command("adb -s " + ID + " shell getprop ro.serialno");
    }

    /**
     * Get Device carrier
     *
     * @return carrier
     */
    public String getDeviceCarrier() throws Exception {
        log.info("Get device carrier");
        return command("adb -s " + ID + " shell getprop gsm.operator.alpha");
    }

    /**
     * Get log process
     *
     * @return process
     */
    public List<Object> getLogcatProcesses() throws Exception {
        String[] output = command("adb -s " + ID + " shell top -n 1 | grep -i 'logcat'").split("\n");
        List<Object> processes = new ArrayList<>();
        for (String line : output) {
            processes.add(line.split(" ")[0]);
            processes.removeAll(Arrays.asList("", null));
        }
        return processes;
    }

    public enum BatteryLevelEnum {
        Unknown, Charging, Discharging, NotCharging,
        Full
    }

    public enum SwitchEnum {
        ON, OFF
    }
}
