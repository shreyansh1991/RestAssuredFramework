package com.spotify.developer.oauth2.constants;


public final class FrameworkConstants {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private FrameworkConstants() {}

	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-reports/";
	private static String extentReportFilePath = "";
	

	public static String getExtentReportFilePath()  {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	private static String createReportPath()  {
			return EXTENTREPORTFOLDERPATH+"/index.html";
	}


}