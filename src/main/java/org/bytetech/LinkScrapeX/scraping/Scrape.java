package org.bytetech.LinkScrapeX.scraping;

import jakarta.servlet.http.HttpSession;
import org.bytetech.LinkScrapeX.model.Experience;
import org.bytetech.LinkScrapeX.model.Profile;
import org.bytetech.LinkScrapeX.model.User;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scrape {

//    @Autowired
//     static HttpSession session;

    static KeyWords words = new KeyWords();


    public static void linkedinData(List<String> list) throws InterruptedException {

        List<Profile> profiles = new ArrayList<>();

//        User user = (User) session.getAttribute("user");

        try {


            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            driver.get("https://www.linkedin.com");


            driver.findElement(By.xpath("//a[@class='nav__button-secondary btn-md btn-secondary-emphasis']")).click();
            driver.findElement(By.id("username")).sendKeys("suraj007@telegmail.com");
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
                // Find the span element only once and store it in a variable
                WebElement spanElement = ele.findElement(By.tagName("span"));
                String spanText = spanElement.getText();

                // Use a regular expression to check if the text contains any digit
                if (spanText.matches(".*\\d.*") && ele.getAttribute("class").contains("t-14 t-black t-normal")) {
                    profile.setContactInfo(spanText);
                }
            } catch (NoSuchElementException e) {
                // Handle the case where the span element is not found
//                System.out.println("Element not found: " + e.getMessage());
            }


            for (WebElement element : elements) {

                String txt = element.getAttribute("href");

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

            Set<Experience> experiences = new HashSet<>();

            try {


                driver.findElement(By.id("navigation-index-see-all-experiences")).click();
                wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                liElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[5]/div[3]/div/div/div[2]/div/div/main/section/div[2]/div/div[1]/ul/li/div/div/div[2]/div[2]/ul/li/div/div/div/ul/li")));

                for (WebElement el : liElements) {
                    // Extract text for each XPath

                    List<WebElement> companyName = el.findElements(By.xpath("//main/section/div[2]/div/div[1]/ul/li/div/div/div[2]/div/a/div/div/div/div/span[1]"));

                    List<WebElement> jobTitle = el.findElements(By.xpath("//main/section[3]/div[3]/ul/li/div/div[2]/div[2]/ul/li/div/div[2]/div[1]/a/div/div/div/div/span[1]"));

                    List<WebElement> duration = el.findElements(By.xpath("//main/section[3]/div[3]/ul/li/div/div[2]/div[2]/ul/li/div/div[2]/div[1]/a/span[1]/span[1]"));

                    List<WebElement> totalDuration = el.findElements(By.xpath("//main/section[3]/div[3]/ul/li/div/div[2]/div[1]/a/span/span[1]"));


                    List<WebElement> companyUrl = el.findElements(By.xpath("//main/section/div[2]/div/div[1]/ul/li/div/div/div[2]/div[1]/a"));


                    int size = companyName.size(); // You can also check the size of other lists to make sure they are consistent

                    // Iterate over the lists and create Experience objects
                    for (int i = 0; i < size; i++) {
                        Experience ex = new Experience();

                        // Extract data from the current elements and set them in the Experience object
                        System.out.println(jobTitle.get(i).getText());
                        ex.setCompanyName(companyName.get(i).getText());
                        ex.setJobTitle(jobTitle.get(i).getText());
                        ex.setEmploymentDuration(duration.get(i).getText());
                        ex.setTotalDuration(totalDuration.get(i).getText());
                        ex.setCompanyUrl(companyUrl.get(i).getAttribute("href"));  // Extract URL from href attribute

                        // Add the Experience object to the list
                        experiences.add(ex);
                    }


                }


                // Add texts to the set (duplicates will be automatically discarded)


            } catch (NoSuchElementException e) {


                wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                liElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//main/section[3]/div/ul/li")));

                for (WebElement element : liElements) {
                    // Extract text for each XPath

                    List<WebElement> companyName = element.findElements(By.xpath("//main/section[3]/div[3]/ul/li/div/div[2]/div[1]/a/div/div/div/div/span[1]"));

                    List<WebElement> jobTitle = element.findElements(By.xpath("//main/section/div[2]/div/div[1]/ul/li/div/div/div[2]/div[2]/ul/li/div/div/div/ul/li/div/div/div[2]/div/a/div/div/div/div/span[1]"));

                    List<WebElement> duration = element.findElements(By.xpath("//main/section[3]/div[3]/ul/li/div/div[2]/div[2]/ul/li/div/div[2]/div[1]/a/div/div/div/div/span[1]"));

                    List<WebElement> totalDuration = element.findElements(By.xpath("//main/section[3]/div[3]/ul/li/div/div[2]/div[1]/a/span/span[1]"));


                    List<WebElement> companyUrl = element.findElements(By.xpath("//main/section[3]/div[3]/ul/li/div/div[2]/div[1]/a"));


                    int size = companyName.size(); // You can also check the size of other lists to make sure they are consistent
                    System.out.println(size);
                    // Iterate over the lists and create Experience objects

                    System.out.println(companyName.get(0).getText());


                    if (size == 0) {
                        System.out.println("No elements found in the list.");
                    } else {
                        // Handle the case when there's only one element in the lists
                        for (int i = 0; i < size; i++) {
                            Experience ex = new Experience();

                            // Check if each list has enough elements before accessing
                            if (!companyName.isEmpty() && i < companyName.size()) {
                                ex.setCompanyName(companyName.get(i).getText());
                            }
                            if (!jobTitle.isEmpty() && i < jobTitle.size()) {
                                ex.setJobTitle(jobTitle.get(i).getText());
                            }
                            if (!duration.isEmpty() && i < duration.size()) {
                                ex.setEmploymentDuration(duration.get(i).getText());
                            }
                            if (!totalDuration.isEmpty() && i < totalDuration.size()) {
                                ex.setTotalDuration(totalDuration.get(i).getText());
                            }
                            if (!companyUrl.isEmpty() && i < companyUrl.size()) {
                                ex.setCompanyUrl(companyUrl.get(i).getAttribute("href"));
                            }

                            // Add the Experience object to the list
                            experiences.add(ex);
                        }
                    }


                }


            }

            System.out.println("\n\n\n\n");
            System.out.println(liElements.size());
            System.out.println("\n\n\n\n");

            System.out.println("***************************************************");

            for (Experience experience : experiences) {
                System.out.println(experience);
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