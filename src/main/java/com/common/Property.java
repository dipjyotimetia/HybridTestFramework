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
package com.common;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public enum Property {

    BUILD("build");

    private static Properties properties = null;
    private final String value;
    private final String systemPropertyKey;

    Property(String key) {
        this.systemPropertyKey = key;
        this.value = retrieveValue(key);
    }

    private String retrieveValue(String key) {
        if (System.getProperty(key) != null) {
            return System.getProperty(key);
        } else {
            return getValueFromConfigFile(key);
        }
    }

    private static String getValueFromConfigFile(String key) {
        if (properties == null) {
            properties = loadConfigFile();
        }

        Object objFromFile = properties.get(key);
        if (objFromFile != null) {
            return Objects.toString(objFromFile);
        } else {
            return null;
        }
    }

    private static Properties loadConfigFile() {
        String configFileName = System.getProperty("config");

        if (StringUtils.isBlank(configFileName)) {
            return new Properties();
        }

        try (InputStream configFileStream =
                     ClassLoader.getSystemClassLoader()
                             .getResourceAsStream(configFileName)) {
            Properties properties = new Properties();
            properties.load(configFileStream);
            return properties;
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Properties file '" + configFileName + "' not found.", e);
        }
    }

    /**
     * Check if a property is specified.
     *
     * @return true if the property is not empty ("") and not null
     */
    public boolean isSpecified() {
        return StringUtils.isNotEmpty(value);
    }

    public String getValue() {
        return retrieveValue(this.systemPropertyKey);
    }

    /**
     * @return true if the property is set and is equal, ignoring case, to "true".
     */
    public boolean getBoolean() {
        return isSpecified() && Boolean.parseBoolean(value);
    }

    public int getIntWithDefault(int defaultValue) {
        return isSpecified()
                ? Integer.parseInt(value)
                : defaultValue;
    }
}