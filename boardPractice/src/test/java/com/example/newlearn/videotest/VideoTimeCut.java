package com.example.newlearn.videotest;

import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegFormat;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;

import java.io.IOException;

public class VideoTimeCut {

    public static String media_player_time() {
        System.out.println("@@ media_player_time start @@");
        String returnData = "0";

        try {
            FFprobe ffprobe = new FFprobe("/opt/homebrew/Cellar/ffmpeg/4.4_1/bin/ffprobe"); // homebrew에 설치된  ffprobe.exe 경로
            FFmpegProbeResult probeResult = ffprobe.probe("/Users/junfe/Desktop/1.mp4"); // 동영상 경로
            FFmpegFormat format = probeResult.getFormat();
            double second = format.duration; // 초단위
            int h = (int)second/3600;
            int m = (int)second%3600/60;
            int s = (int)second%3600%60;

            returnData = second + "";
            System.out.println("second==" + second);
            System.out.println(h+":"+m+":"+s);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("@@ media_player_time end @@");
        }

        return returnData;
    }

    public static void main(String[] args) throws IOException {
        media_player_time();
    }
}
