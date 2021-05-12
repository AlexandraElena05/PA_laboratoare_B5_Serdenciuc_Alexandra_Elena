package com.company;
import com.jcraft.jsch.*;
import java.io.*;
public class SFTPsender {
    public void send(String fileName) throws IOException {
        String SFTPHOST = "fenrir.info.uaic.ro";
        int SFTPPORT = 22;
        String SFTPUSER = "alexandra.serdenciuc";
        String SFTPPASS = readPassword();
        String SFTPWORKINGDIR = "/fenrir/studs/alexandra.serdenciuc/html/";
        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
            session.setPassword(SFTPPASS);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            System.out.println("Host connected.");
            channel = session.openChannel("sftp");
            channel.connect();
            System.out.println("sftp channel opened and connected.");
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(SFTPWORKINGDIR);
            File f = new File(fileName);
            channelSftp.put(new FileInputStream(f), f.getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally{
            channelSftp.exit();
            System.out.println("sftp Channel exited.");
            channel.disconnect();
            System.out.println("Channel disconnected.");
            session.disconnect();
            System.out.println("Host Session disconnected.");
        }
    }
    public String readPassword () throws IOException {
        File file = new File("C:\\facultate\\Anul 2, sem 2\\PA\\lab10\\password.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        st = br.readLine();
        return st;
    }
}