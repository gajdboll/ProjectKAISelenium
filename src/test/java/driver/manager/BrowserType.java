package driver.manager;

public enum BrowserType {
//enum created to select one of the browsers
    FIREFOX("firefox"),
    CHROME("chrome"),
    IE("internetexplorer"),
    OPERA("opera"),
    EDGE("edge");

    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }

}