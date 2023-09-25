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
import org.apache.sshd.client.SshClient;
import org.apache.sshd.client.channel.ClientChannel;
import org.apache.sshd.client.channel.ClientChannelEvent;
import org.apache.sshd.client.session.ClientSession;
import org.apache.sshd.common.channel.Channel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

/**
 * This class provides methods for performing SSH operations, such as executing commands on a remote server.
 *
 * @author Dipjyoti Metia
 */
@Slf4j
public class SSH {

    private static final long DEFAULT_TIMEOUT_SECONDS = 30;

    /**
     * Executes a command on a remote server using SSH and logs the output.
     *
     * @param username a String representing the SSH username
     * @param password a String representing the SSH password
     * @param host     a String representing the remote server's host
     * @param port     an int representing the SSH port number
     * @param command  a String representing the command to execute
     * @throws IOException if an error occurs while performing the SSH operation
     */
    public static void executeCommand(String username, String password, String host, int port, String command) throws IOException {
        executeCommand(username, password, host, port, DEFAULT_TIMEOUT_SECONDS, command);
    }

    /**
     * Executes a command on a remote server using SSH, logs the output, and specifies a custom timeout.
     *
     * @param username              a String representing the SSH username
     * @param password              a String representing the SSH password
     * @param host                  a String representing the remote server's host
     * @param port                  an int representing the SSH port number
     * @param timeoutSeconds        a long representing the timeout duration in seconds
     * @param command               a String representing the command to execute
     * @throws IOException if an error occurs while performing the SSH operation
     */
    public static void executeCommand(String username, String password, String host, int port, long timeoutSeconds, String command) throws IOException {
        SshClient client = SshClient.setUpDefaultClient();
        client.start();

        try (ClientSession session = client.connect(username, host, port)
                .verify(timeoutSeconds, TimeUnit.SECONDS).getSession()) {
            session.addPasswordIdentity(password);
            session.auth().verify(timeoutSeconds, TimeUnit.SECONDS);

            try (ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
                 ClientChannel channel = session.createChannel(Channel.CHANNEL_SHELL)) {
                channel.setOut(responseStream);
                try {
                    channel.open().verify(timeoutSeconds, TimeUnit.SECONDS);
                    try (OutputStream pipedIn = channel.getInvertedIn()) {
                        pipedIn.write(command.getBytes());
                        pipedIn.flush();
                    }

                    channel.waitFor(EnumSet.of(ClientChannelEvent.CLOSED),
                            TimeUnit.SECONDS.toMillis(timeoutSeconds));
                    String responseString = responseStream.toString();
                    log.info(responseString);
                } finally {
                    channel.close(false);
                }
            }
        } finally {
            client.stop();
        }
    }

    /**
     * Lists the folder structure of a remote server using SSH. The output is logged using the info level.
     *
     * @param username a String representing the SSH username
     * @param password a String representing the SSH password
     * @param host     a String representing the remote server's host
     * @param port     an int representing the SSH port number
     * @param command  a String representing the command to list the folder structure
     * @throws IOException if an error occurs while performing the SSH operation
     */
    public static void listFolderStructure(String username, String password, String host, int port, String command) throws IOException {
        executeCommand(username, password, host, port, command);
    }

    /**
     * Uploads a file to a remote server using SCP.
     *
     * @param username   a String representing the SSH username
     * @param password   a String representing the SSH password
     * @param host       a String representing the remote server's host
     * @param port       an int representing the SSH port number
     * @param localPath  a String representing the local file path
     * @param remotePath a String representing the remote file path
     * @throws IOException if an error occurs while uploading the file
     */
    public static void uploadFile(String username, String password, String host, int port, String localPath, String remotePath) throws IOException {
        String scpCommand = "scp -P " + port + " " + localPath + " " + username + "@" + host + ":" + remotePath;
        executeCommand(username, password, host, port, scpCommand);
    }
}
