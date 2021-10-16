package com.spotify.developer.oauth2.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.spotify.developer.oauth2.enums.LogType;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public final class FrameworkLogger {

    private FrameworkLogger() {
    }

    private static final Consumer<String> PASS = (message) -> ExtentManager.getExtentTest().pass(message);
    private static final Consumer<String> FAIL = (message) -> ExtentManager.getExtentTest().fail(message);
    private static final Consumer<String> SKIP = (message) -> ExtentManager.getExtentTest().skip(message);
    private static final Consumer<String> INFO = (message) -> ExtentManager.getExtentTest().info(message);
    private static final Consumer<String> CONSOLE = (message) -> System.out.println("INFO---->" + message);
    private static final Consumer<String> EXTENTANDCONSOLE = PASS.andThen(CONSOLE);
    private static final Consumer<String> LOGSTACKTRACEINFOINEXTENTREPORT = (message) -> {
        String formattedText = "<pre>" + message.replace(",", "<br>") + "</pre>";
        ExtentManager.getExtentTest().fail(formattedText);
    };
    private static final Consumer<String> LOGPRETTYRESPONSETOREPORT = (response) -> {
        ExtentManager.getExtentTest().info(MarkupHelper.createCodeBlock(response, CodeLanguage.JSON));
    };
    private static final Consumer<String> LOGPRETTYREQUESTTOREPORT = (request) -> {
        ExtentManager.getExtentTest().info("<pre>" + request.replace("\n", "<br>") + "</pre>");
    };

    private static final BiConsumer<String, String> LOGREQUESTANDRESPONSETOREPORT =
            (request, response) -> {
                ExtentManager.getExtentTest().info(request.replace("\n", "<br>"));
                ExtentManager.getExtentTest().info(MarkupHelper.createCodeBlock(response, CodeLanguage.JSON));
            };
    private static final Map<LogType, Consumer<String>> MAP = new EnumMap<>(LogType.class);
    private static final Map<LogType, BiConsumer<String, String>> BI_CONSUMER_MAP = new EnumMap<>(LogType.class);

    static {
        MAP.put(LogType.PASS, PASS);
        MAP.put(LogType.FAIL, FAIL);
        MAP.put(LogType.SKIP, SKIP);
        MAP.put(LogType.INFO, INFO);
        MAP.put(LogType.CONSOLE, CONSOLE);
        MAP.put(LogType.EXTENTANDCONSOLE, EXTENTANDCONSOLE);
        MAP.put(LogType.LOGSTACKTRACEINFOINEXTENTREPORT, LOGSTACKTRACEINFOINEXTENTREPORT);
        MAP.put(LogType.LOGPRETTYRESPONSETOREPORT, LOGPRETTYRESPONSETOREPORT);
        MAP.put(LogType.LOGPRETTYREQUESTTOREPORT, LOGPRETTYREQUESTTOREPORT);
        BI_CONSUMER_MAP.put(LogType.LOGREQUESTANDRESPONSETOREPORT,LOGREQUESTANDRESPONSETOREPORT);
    }

    public static void log(LogType status, String message) {
        MAP.getOrDefault(status, EXTENTANDCONSOLE).accept(message);
    }
    public static void log(LogType status, String request,String response) {
        BI_CONSUMER_MAP.getOrDefault(status, LOGREQUESTANDRESPONSETOREPORT).accept(request,response);
    }

   /* public static void logRequestAndResponseInReport(String request, String response) {
        logPrettyRequestToReport(request);
        logPrettyResponseToReport(response);
    }

    private static void logPrettyResponseToReport(String response) {
        ExtentManager.getExtentTest().info(MarkupHelper.createCodeBlock(response, CodeLanguage.JSON));
    }

    private static void logPrettyRequestToReport(String request) {
//        ExtentManager.getExtentTest().info("<pre>"+ request.replace("\n", "<br>") + "</pre>");
        ExtentManager.getExtentTest().info(request.replace("\n", "<br>"));
    }*/
}