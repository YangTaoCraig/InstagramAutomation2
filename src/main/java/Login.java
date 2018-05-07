import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Login {

    @Test
    public void startLogin() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\browserdriver\\chromedriver.exe");

// Initialize browser
        WebDriver driver=new ChromeDriver();

        String baseUrl = "https://www.instagram.com/";
        // Implicit Wait, any element from website can initiate the Page to load.
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        String expectedTitle = "Instagram";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();
//      // Wait until the page is ready within the specified timeout.
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"react-root\"]/section/main/article/div[2]/div[2]/p/a")));
        WebElement login = driver.findElement((By.xpath("//*[@id=\"react-root\"]/section/main/article/div[2]/div[2]/p/a")));
        login.click();
        sleep(1000);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        username.sendKeys("everyemery");
        password.sendKeys("Junshan@19890824");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/article/div[2]/div[1]/div/form/span[1]/button"));
        loginButton.click();
        driver.manage().window().maximize();

        sleep(4000);
        WebElement myDynamicElement1= (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("_gh2cz")));

        List<WebElement> linkElements = driver.findElements(By.className("_gh2cz"));
        String[] linkTexts = new String[linkElements.size()];
        int	i = 0;

        //extract the link texts of each link element
        for (WebElement e : linkElements) {
            linkTexts[i] = e.getText();
            System.out.println(linkTexts[i]);
            i++;
        }





        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        Assert.assertTrue("Check the title is correct",expectedTitle.equals(actualTitle));
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        //close Fire fox
        sleep(3000);
        driver.close();

    }

}