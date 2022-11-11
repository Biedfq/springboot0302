package net.hnkj.springboot0302.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://www.baidu.com/";
        driver.get(url);

//        WebElement element = driver.findElement(By.className("s_ipt"));
//        System.out.println(element.getText());

//        List<WebElement> elements = driver.findElements(By.className("title-content-title"));
//        for (WebElement element : elements){
//            System.out.println(element.getText());
//        }


//        WebElement su = driver.findElement(By.id("su"));
//        System.out.println(su.getAttribute("value"));

//        WebElement aE1 = driver.findElement(By.linkText("地图"));
//        System.out.println(aE1.getAttribute("href"));

//        WebElement su = driver.findElement(By.xpath("//*[@id=\"su\"]"));
//
//        System.out.println(su.getAttribute("value"));


        WebElement input = driver.findElement(By.id("kw"));
        input.sendKeys("911");
        WebElement button = driver.findElement(By.id("su"));
        button.click();

//       driver.close();
////
//       driver.quit();


    }
}
