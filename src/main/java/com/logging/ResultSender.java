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

package com.logging;

import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.Unirest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResultSender {
    private static final ObjectMapper OM = new ObjectMapper();
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_VALUE = "application/json";
    private static final String ELASTICSEARCH_URL = "http://localhost:9200/app/suite";

    public static void send(final TestStatus testStatus) {
        try {
            Unirest.post(ELASTICSEARCH_URL)
                    .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                    .body(OM.writeValueAsString(testStatus)).asJson();
            log.info(OM.writeValueAsString(testStatus));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
