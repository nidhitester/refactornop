package com.noopcommercerefactor;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class CrossBrowser extends Util {
    LoadProp loadProp = new LoadProp();
    public void browser(){
        //String browsers = System.getProperty("omar");
        String browser=loadProp.getProperty("browser");
        //loadProp.getProperty("name");
        //loadProp.getProperty("card");
// String browser=System.getProperty("browser");
        if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","src\\main\\java\\com\\methods\\Driver\\geckodriver.exe");
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver","src\\main\\java\\com\\methods\\Driver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--incognito");
            options.addArguments("--disable-blink-features=BlockCredentialedSubresources");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get(loadProp.getProperty("url"));
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "src\\main\\java\\com\\methods\\Driver\\IEDriverServer.exe");
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
            options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,true);
            driver = new InternetExplorerDriver(options);
            driver.manage().window().maximize();
        }else{
            System.out.println("Browser name is empty or typed wrong :"+browser);

}}}
