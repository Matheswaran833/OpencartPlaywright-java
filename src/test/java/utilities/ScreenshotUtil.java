package utilities;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;

public class ScreenshotUtil {
    
    public Page page;
	
	
	public String captureScreen( Page page,String tname)
	{

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";		
		page.screenshot(new ScreenshotOptions().setPath(Paths.get(targetFilePath)));
		return targetFilePath;

	}
	
	public String captureFullScreen( Page page,String tname)
	{

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";		
		page.screenshot(new ScreenshotOptions().setPath(Paths.get(targetFilePath)).setFullPage(true));
		return targetFilePath;

	}
}
