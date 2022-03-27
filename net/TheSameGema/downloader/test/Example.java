package net.TheSameGema.downloader.test;

import net.TheSameGema.downloader.Downloader;

import java.io.IOException;


public class Example {

    public static void main(String[] args)  {
        try {
            Downloader.downloadAndConvert("XXYlFuWEuKI");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
