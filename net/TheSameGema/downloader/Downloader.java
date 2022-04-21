package net.TheSameGema.downloader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class Downloader {

    public static void downloadWithYtDpl(String watchID, String title, String artist, boolean log) throws IOException {
        String udlExec = "PATH TO yt-dpl.exe";
        String cmd = udlExec+" -x --audio-format mp3 --audio-quality 0 https://www.youtube.com/watch?v=" + watchID;

        Process p = Runtime.getRuntime().exec(cmd);

        BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while (true) {
                String newLine = bf.readLine();
                if (log) {
                    log(newLine);
                }
                if (newLine == null) break;
                //[download] 100.0%
            }

        bf.close();

         File tmpAudioFile = new File(artist + " - " + title + " [" + watchID + "].mp3");
         File path = new File(System.getProperty("user.home") + "/Music/"+"/"+watchID+".mp3");
         tmpAudioFile.renameTo(path);

        if (log) {
            log("File saved " + path);
        }
    }


    public static void downloadWithYoutubeDl(String watchID, boolean log) throws IOException {

        String udlExec = "PATH TO youtube-dl.exe";

        //update youtube-dl
        try {
            youtubeDlUtil.checkForYouTubeDlUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String cmd = udlExec+" -o audioDownload.%(ext)s --extract-audio --audio-format mp3 https://www.youtube.com/watch?v="+watchID;

        Process p = Runtime.getRuntime().exec(cmd);

        BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));


            while (true) {
                String newLine = bf.readLine();
                if (log) {
                    log(newLine);
                }
                if (newLine == null) break;
                //[download] 100.0%
            }

        bf.close();

        File tmpAudioFile = new File("audioDownload.mp3");
        File path = new File(System.getProperty("user.home") + "/Music/"+"/"+watchID+".mp3");
        tmpAudioFile.renameTo(path);
        

        if (log) {
            log("File saved " + path);
        }
    }
    
    private static void log(String text) {
        System.out.println(text);
    }
}

