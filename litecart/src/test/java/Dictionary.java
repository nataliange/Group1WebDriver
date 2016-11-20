import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;


public class Dictionary {
    FirefoxDriver wd;
    
    @Before
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void Dictionary() {
        wd.get("http://www.leo.org/");
        wd.findElement(By.xpath("//li[@class='is-active']//a[.='Dictionary']")).click();
        wd.findElement(By.id("search-field")).click();
        wd.findElement(By.id("search-field")).clear();
        wd.findElement(By.id("search-field")).sendKeys("test");
        wd.findElement(By.id("searchFieldSubmit")).click();
    }
    
    @After
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
