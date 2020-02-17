package com.eriknj99.quickui.log;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.concurrent.TimeUnit;

public class Log {

    public static boolean INFO =  true;
    public static boolean DEBUG =  true;
    public static boolean ERROR =  true;

    private static String getUptimeString(){
        RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
        long ms = rb.getUptime();

       return ms + "" ;/*+ String.format("%d:%d",
                TimeUnit.MILLISECONDS.toMinutes(ms),
                TimeUnit.MILLISECONDS.toSeconds(ms) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ms))
        );*/
    }

    private static String parseEscapeSeq(Object o){
        String out = "<reset>" + o.toString();
        //ANSI: black \u001b[30m
        //ANSI: red \u001b[31m
        //ANSI: green \u001b[32m
        //ANSI: yellow \u001b[33m
        //ANSI: blue \u001b[34m
        //ANSI: magenta \u001b[35m
        //ANSI: cyan \u001b[36m
        //ANSI: reset \u001b[0m

        out = out.replaceAll("<black>", "\u001b[30m");
        out = out.replaceAll("<red>", "\u001b[31m");
        out = out.replaceAll("<green>", "\u001b[32m");
        out = out.replaceAll("<yellow>", "\u001b[33m");
        out = out.replaceAll("<blue>", "\u001b[34m");
        out = out.replaceAll("<magenta>", "\u001b[35m");
        out = out.replaceAll("<cyan>", "\u001b[36m");
        out = out.replaceAll("<reset>", "\u001b[0m");

        return out;
    }

    public static void info(Object o){
        System.out.println(parseEscapeSeq("[<green>"+getUptimeString() + "<reset>]\t <green>INFO:\t<reset>" + o.toString()));
    }

    public static void infonl(Object o){
        System.out.print(parseEscapeSeq(o));
    }

    public static void debug(Object o){
        System.out.println(parseEscapeSeq("[<green>"+getUptimeString() + "<reset>]\t <blue>DEBUG:\t<reset>" + o.toString()));
    }

    public static void debugnl(Object o){
        System.out.print(o.toString());
    }

    public static void ex(Exception e){
        System.out.println(parseEscapeSeq("[<red>"+getUptimeString() + "<reset>]\t <red>EX:\t<reset>" + e.getStackTrace()[0].getClassName() + "<red> :: <reset>" + e.getStackTrace()[0].getLineNumber()));
        e.printStackTrace();
    }

    public static void error(Object o){
        System.out.println(parseEscapeSeq("[<red>"+getUptimeString() + "<reset>]\t <red>ERROR:\t<reset>" + o.toString()));
    }

    public static void errornl(Object o){
        System.err.print(o.toString());
    }

}
