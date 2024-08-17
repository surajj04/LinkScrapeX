package org.bytetech.LinkScrapeX.scraping;

import jakarta.servlet.http.HttpSession;
import org.bytetech.LinkScrapeX.model.Profile;
import org.bytetech.LinkScrapeX.model.User;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Scrape {

//    @Autowired
//     static HttpSession session;

    public static void linkedinData(List<String> list) throws InterruptedException {

        List<Profile> profiles = new ArrayList<>();

//        User user = (User) session.getAttribute("user");

        try {


            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            driver.get("https://www.linkedin.com");


            driver.findElement(By.xpath("//a[@class='nav__button-secondary btn-md btn-secondary-emphasis']")).click();
            driver.findElement(By.id("username")).sendKeys("surajjadhav007872@gmail.com");
            driver.findElement(By.id("password")).sendKeys("suraj@78725");
            driver.findElement(By.xpath("//button[@aria-label='Sign in']")).click();

            driver.navigate().to("https://www.linkedin.com/in/sagar-sarate-52179a228/");

            Profile profile = new Profile();

            profile.setName(driver.findElement(By.cssSelector(".text-heading-xlarge.inline.t-24.v-align-middle.break-words")).getText());

            driver.findElement(By.id("top-card-text-details-contact-info")).click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.pv-profile-section__section-info.section-info")));
            List<WebElement> elements = ele.findElements(By.tagName("a"));

            try {
                if ((ele.findElement(By.tagName("span")).getText().contains("0") || ele.findElement(By.tagName("span")).getText().contains("1") || ele.findElement(By.tagName("span")).getText().contains("2") || ele.findElement(By.tagName("span")).getText().contains("3") || ele.findElement(By.tagName("span")).getText().contains("4") || ele.findElement(By.tagName("span")).getText().contains("5") || ele.findElement(By.tagName("span")).getText().contains("6") || ele.findElement(By.tagName("span")).getText().contains("7") || ele.findElement(By.tagName("span")).getText().contains("8") || ele.findElement(By.tagName("span")).getText().contains("9")) && ele.getAttribute("class").contains("t-14 t-black t-normal")) {
                    profile.setContactInfo(ele.findElement(By.tagName("span")).getText());
                }
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }



            for (WebElement element : elements) {

                String txt = element.getAttribute("href");
                System.out.println(txt);

                if (txt.contains("https://www.linkedin.com/in")) {
                    profile.setProfileLink(txt);
                } else if (txt.contains("mailto")) {
                    profile.setEmail(element.getText());
                }
            }

            driver.findElement(By.cssSelector("button.artdeco-button.artdeco-button--circle.artdeco-button--muted.artdeco-modal__dismiss")).click();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            Thread.sleep(3000);

            js.executeScript("window.scrollBy(0,1500)");

            List<WebElement> liElements = null;

            Thread.sleep(3000);

            try {
                ele = driver.findElement(By.cssSelector("ul.pAEeUbZqvliACxLERGmSJMPGFQimHUoxI"));
                liElements = ele.findElements(By.tagName("li"));
            } catch (NoSuchElementException e) {
                // Fetch all <li> elements with the common class if <ul> is not found
                ele = driver.findElement(By.cssSelector("ul.pAEeUbZqvliACxLERGmSJMPGFQimHUoxI"));
                liElements = ele.findElements(By.tagName("li"));
            }

            System.out.println(liElements.size());


            for (WebElement el : liElements) {
                System.out.println(ele.getText());
            }

            System.out.println(profile);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public static void main(String[] args) throws InterruptedException {

//        User user = new User();
//        user.setEmail("surajjadhav00787@gmail.com");
//        user.setPassword("suraj@78725");
//        session.setAttribute("user", user);

        List<String> list = new ArrayList<>();

//        list.add("")

        linkedinData(list);
    }
}