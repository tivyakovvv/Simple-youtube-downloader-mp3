package net.TheSameGema.downloader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class youtubeDlUtil {


    public static String getYouTubeDlVersion() throws Exception
    {
        String appName = "HERE-YOUR-PATH-T0-YOUTUBE-DL.EXE";
        Process p = Runtime.getRuntime().exec(appName+" --version");
        BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String youtubeDLVersion = bf.readLine();
        bf.close();
        p.destroy();



        return youtubeDLVersion;
    }

    public static void checkForYouTubeDlUpdate() throws Exception
    {


        log("Checking for update ...");

        String execName = "HERE-YOUR-PATH-T0-YOUTUBE-DL.EXE";

        Process p = Runtime.getRuntime().exec(execName+" -U");
        BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));

        while(true)
        {
            String line = bf.readLine();

            if(line == null) break;

            log("'"+line+"'");
            if(line.startsWith("Updating to version "))
            {


                bw.write("\n");
            }
            else if(line.startsWith("ERROR"))
            {
                log("Unable to check for YouTube Dl Update, Make sure you're connected to the internet\n\nYouTube Dl Output : " + line);
            }
        }

        getYouTubeDlVersion();

        bf.close();


    }

    private static void log(String text) {
        System.out.println(text);
    }

}
