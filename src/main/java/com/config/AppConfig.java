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

package com.config;

import com.typesafe.config.Config;
import lombok.Getter;

/**
 * @author Dipjyoti Metia
 */
@Getter
public class AppConfig {
    private final String applicationName;
    private final int appiumPort;
    private final int proxyPort;
    private final String browserUrl;
    private final String browserAppium;
    private final String deviceFarm;
    private final String sauceUrl;
    private final String sauceAppium;

    public AppConfig(Config config) {
        this.applicationName = config.getString("application.name");
        this.appiumPort = config.getInt("appium.appiumport");
        this.proxyPort = config.getInt("appium.proxyport");
        this.deviceFarm = config.getString("aws.deviceFarm");
        this.sauceUrl = config.getString("saucelabs.host");
        this.sauceAppium = config.getString("saucelabs.appium_version");
        this.browserUrl = config.getString("browserstack.host");
        this.browserAppium = config.getString("browserstack.appium_version");
    }

}
