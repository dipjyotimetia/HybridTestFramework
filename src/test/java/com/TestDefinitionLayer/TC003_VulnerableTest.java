package com.TestDefinitionLayer;

import com.security.ZapTools;
import org.zaproxy.clientapi.core.ClientApi;

public class TC003_VulnerableTest {

    private static final String ZAP_SESSION_IP = "127.0.0.1";
    private static final int ZAP_SESSION_PORT = 8091;
    private static final String ZAP_HOSTNAME = "localhost";
    private static final String ZAP_URI = "http://localhost";
    private static final String ZAP_URI_PORT = "http://localhost:8888";
    private static final String SELENIUM_URI = "http://localhost:8888/cgi-bin/TestVulnerable/index.pl";

    public static void main(String[] args) {

        ZapTools zap = new ZapTools();
        if( zap.startZAP() == false ) {
            System.out.println( "ZAP failed to start. Terminating..." );
            System.exit(0);
        }
        zap.startSession( ZAP_HOSTNAME, ZAP_SESSION_PORT );


        //We now have ZAP and Selenium running and ready to go:
        //1. open up the Vulnerable Test App and complete the form with Selenium
        //2. stop and close Selenium
        //3. spider the Vulnerable Test App (not necessary as there's only 2 URLs in this Vulnerable Test App - demonstration purposes)
        //4. run an active scan to uncover any vulnerabilities
        //5. check for any errors/warning found in the active scan
        //6. save session for later use
        //7. stop and close ZAP

        // 1


        // 3
        ClientApi api = new ClientApi( ZAP_HOSTNAME, ZAP_SESSION_PORT );

        // 6
        zap.saveSession (api, "Vulnerable" );

        // 7
        zap.stopZAP( ZAP_SESSION_IP, ZAP_SESSION_PORT );
    }

}
