package com.qa.utils;

import io.appium.java_client.screenrecording.CanRecordScreen;
import io.cucumber.java.Scenario;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class VideoManager {
    private TestUtils testUtils = new TestUtils();

    public void startRecording(){
        testUtils.log().info("video recording starting...");
        ((CanRecordScreen) new DriverManager().getDriver()).startRecordingScreen();
    }

    public void stopRecording(Scenario scenario){
        testUtils.log().info("video recording stopping...");
        GlobalParams params = new GlobalParams();
        String media = ((CanRecordScreen) new DriverManager().getDriver()).stopRecordingScreen();
        String dirPath = params.getPlatformName() + TestUtils.UNDERSCORE + params.getDeviceName() + File.separator + "Videos";

        File videoDir = new File(dirPath);

        synchronized (videoDir){
            if(!videoDir.exists()){
                videoDir.mkdirs();
            }
        }

        FileOutputStream stream = null;

        try {
            stream = new FileOutputStream(videoDir + File.separator + scenario.getName() + TestUtils.VIDEO_FILE_EXTENSION);
            stream.write(Base64.decodeBase64(media));
            stream.close();
            testUtils.log().info("Video path: " + videoDir + File.separator + scenario.getName() + TestUtils.VIDEO_FILE_EXTENSION);
        }catch (Exception e){
            e.printStackTrace();
            testUtils.log().error("Video capturing failure 1: " + e.getMessage());
        }finally {
            if(stream!=null){
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    testUtils.log().error("Video capturing failure 2: " + e.getMessage());
                }
            }
        }
    }
}
