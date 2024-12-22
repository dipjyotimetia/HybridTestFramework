/*
MIT License

Copyright (c) 2025 Dipjyoti Metia

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

package com.core;


import com.config.AppConfig;
import com.microsoft.playwright.Browser;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.openqa.selenium.WebDriver;

/**
 * DriverManager class is responsible for handling WebDriver instance management.
 * It extends DriverController class to access its methods and configurations.
 *
 * @author Dipjyoti Metia
 */
public class DriverManager extends DriverController {
    /**
     * AppConfig instance to access application configurations.
     */
    public AppConfig appConfig;
    /**
     * WebDriver instance to manage the WebDriver for the current thread.
     */
    public WebDriver driverThread;

    /**
     * Browser instance to manage the Browser for the current thread.
     */
    public Browser playThread;

    /**
     * OpenTelemetry instance for tracing.
     */
    private static final OpenTelemetry openTelemetry = GlobalOpenTelemetry.get();
    private static final Tracer tracer = openTelemetry.getTracer("com.core.DriverManager");

    /**
     * Default constructor for DriverManager.
     * Initializes AppConfig and WebDriver instances from the superclass.
     */
    public DriverManager() {
        this.appConfig = super.getAppConfig();
        this.driverThread = super.getWebDriver();
        this.playThread = super.getPlaywright();
    }

    /**
     * Setup method to initialize tracing spans for key selenium actions.
     */
    public void setup() {
        Span span = tracer.spanBuilder("setup").startSpan();
        try {
            // Your setup code here
        } finally {
            span.end();
        }
    }

    /**
     * TearDown method to end tracing spans for key selenium actions.
     */
    public void tearDown() {
        Span span = tracer.spanBuilder("tearDown").startSpan();
        try {
            // Your tearDown code here
        } finally {
            span.end();
        }
    }
}
