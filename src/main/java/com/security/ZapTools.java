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

package com.security;

import lombok.extern.slf4j.Slf4j;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;
import org.zaproxy.clientapi.core.ClientApiMain;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

@Slf4j
public class ZapTools {

    private final String ZAP_LOCATION = "C:\\Program Files\\OWASP\\Zed Attack Proxy";
    private final String SAVE_SESSION_DIRECTORY = "ZAPSessions\\";

    public boolean startZAP() {
        try {
            String[] command = {"CMD", "/C", this.ZAP_LOCATION + "ZAP.exe"};
            ProcessBuilder proc = new ProcessBuilder(command);
            proc.directory(new File(this.ZAP_LOCATION));
            Process p = proc.start();
            p.waitFor();
            BufferedReader input = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            OutputStreamWriter oStream = new OutputStreamWriter(
                    p.getOutputStream());
            oStream.write("process where name='ZAP.exe'");
            oStream.flush();
            oStream.close();
            String line;
            while ((line = input.readLine()) != null) {
                //kludge to tell when ZAP is started and ready
                if (line.contains("INFO") && line.contains("org.parosproxy.paros.control.Control") && line.contains("New Session")) {
                    input.close();
                    break;
                }
            }
            log.info("ZAP has started successfully.");
            return true;
        } catch (Exception ex) {
            log.info("ZAP was unable to start.");
            ex.printStackTrace();
            return false;
        }
    }

    public void stopZAP(String zapaddr, int zapport) {
        ClientApiMain.main(new String[]{"stop", "zapaddr=" + zapaddr, "zapport=" + zapport});
    }

    public void startSession(String zapaddr, int zapport) {
        ClientApiMain.main(new String[]{"newSession", "zapaddr=" + zapaddr, "zapport=" + zapport});
        log.info("session started");
        log.info("Session started successfully.");
    }

    public void saveSession(ClientApi api, String fileName) {
        try {
            String path = this.SAVE_SESSION_DIRECTORY + fileName + ".session";
            api.core.saveSession(path, "true");
            log.info("Session save successful (" + path + ").");
        } catch (ClientApiException ex) {
            log.info("Error saving session.");
            ex.printStackTrace();
        }
    }
}
