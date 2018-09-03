package com.honeygram.configuration;

import com.sun.deploy.net.proxy.WIExplorerAutoProxyHandler;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.SessionId;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ADBcommands {
    private static final String[] WIN_RUNTIME = { "cmd.exe", "/C" };
    private static final String[] OS_LINUX_RUNTIME = { "/bin/bash", "-l", "-c" };
    static String [] adbCommand={"adb devices","adb shell getprop ro.build.version.release","adb shell cat build.prop"};
    static FileInputStream fls;
    static ProcessBuilder bulder;
    static Process p;
    static BufferedReader in;
    static StringBuilder output = new StringBuilder();
    static BufferedWriter writer;
    Runtime rn;
    static File file;
    static Device device= new Device();

    public ADBcommands(){

    }
    // run adb commands in command and get the device list
    public static void getDeviceList(){
        bulder =new ProcessBuilder();
        bulder.command(WIN_RUNTIME[0],WIN_RUNTIME[1],adbCommand[0] +"&&"+ adbCommand[1]);
        try{
           p= bulder.start();
           p.waitFor();
           in=new BufferedReader(new InputStreamReader(p.getInputStream()));
           String line="";
           int currentLine=0;
           while((line =in.readLine())!=null){
               if(currentLine++<=1){
                   continue;
               }
               output.append(line + System.lineSeparator());
               in.close();

           }
        }
        catch(Exception e){

            e.printStackTrace();

        }
        System.out.println(output);


        redirectOutput(output);
    }
    // redirect console output to deviceconfig file.
    public static void redirectOutput(StringBuilder stringBuilder) {
        try {
            file = new File(".");
            String path = file.getCanonicalPath();
            String consoleOutput= stringBuilder.toString();
            consoleOutput=consoleOutput.replaceAll("(?m)^[\t]\r?\n", "");
            writer = new BufferedWriter(new FileWriter(file + "deviceconfig.txt"));
            writer.write(consoleOutput);
            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static void processDevicelist(){
        String strLine="",model="",osVersion="";
        String modelNumber="";
        String [] modelSplit=new String[5];
        String [] dsplit;
        int lineNumber=0;
        try {
            fls = new FileInputStream(".deviceconfig.txt");
            in = new BufferedReader(new InputStreamReader(fls));
            while((strLine =in.readLine()) !=null) {
                if(lineNumber>0 && !strLine.matches("\\r\\n|[\\r\\n]")){
                    dsplit=strLine.split("\\s+");
                    for(int i=0;i<dsplit.length; i++){
                        if(i==0){
                            device.setDeviceID(dsplit[i]);
                        }
                        if(dsplit[i].contains(":")){
                            modelSplit= dsplit[i].split(":");
                            for(int j=0;j<modelSplit.length;j++){
                                if(modelSplit[j++].equals("model")){
                                    modelNumber=modelSplit[j];
                                    System.out.println(modelNumber);
                                    device.setModelName(modelNumber);
                                    break;
                                }
                            }

                        }
                        if(i==dsplit.length){
                            device.setOsInfo(dsplit[i]);

                        }

                    }

                }
                lineNumber++;
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    public HashMap<String, String> getDeviceIdentification(){

        return null;
    }

}




