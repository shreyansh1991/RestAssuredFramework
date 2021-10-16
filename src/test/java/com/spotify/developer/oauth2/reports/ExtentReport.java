package com.spotify.developer.oauth2.reports;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.spotify.developer.oauth2.constants.FrameworkConstants;


public final class ExtentReport {


    /**
     * Private constructor to avoid external instantiation
     */
    private ExtentReport() {
    }

    private static ExtentReports extent;

    public static void initReports() {
        System.out.println("29...............");
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Rest Assured API Automation");
            spark.config().setReportName("API Testing Report");
            System.out.println("35..");
        }
    }


    public static void flushReports() {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unload();
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a test node in the extent report. Delegates to {@link ExtentManager} for providing thread safety
     *
     * @param testcasename Test Name that needs to be reflected in the report
     * @author Amuthan Sakthivel
     * Jan 22, 2021
     */
    public static void createTest(String testcasename) {
        ExtentManager.setExtentTest(extent.createTest(testcasename));
    }


}