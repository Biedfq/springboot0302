package net.hnkj.springboot0302.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Demo02 {
    private static WebDriver driver;
    private static List<String> urls = new ArrayList<>();

    static {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();


    }

    public static void grtUrls() throws Exception {


        driver.get("https://www.maoyan.com/");

        WebElement bangdanElement = driver.findElement(By.linkText("榜单"));
        bangdanElement.click();


        Thread.sleep(10 * 1000L);

        Thread.sleep(5000);

        for (int i = 400; i <= 1600; i += 400) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(" + (i - 400) + "," + i + ")");
            Thread.sleep(1000);
        }
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(1000);

        Thread.sleep(5000);

        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div/dl/dd"));

        System.out.println(elements.size());

        for (WebElement element : elements) {
            WebElement img = element.findElement(By.cssSelector("img.board-img"));
            String url = img.getAttribute("src");
            urls.add(url);
        }

        System.out.println("图片路径读取完成");


        driver.close();

        driver.quit();

    }

    public static void upload(String ur1) {
        try {
            URL url1 = new URL(ur1);
            InputStream is = new DataInputStream(url1.openStream());

            String path = "D:\\4399\\实训5\\img\\" + System.currentTimeMillis() + ".jpg";
            OutputStream out = new FileOutputStream(new File(path));

            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                out.write(bytes, 0, len);

            }
                is.close();
                out.close();


            }catch(Exception e){
                e.printStackTrace();
            }
        }




        public static void main (String[]args) throws Exception {

            grtUrls();
            for(String url : urls){
                System.out.println(url);
                upload(url);

            }



//            List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div/dl/dd"));
//
//            System.out.println(elements.size());
//
//            for (WebElement element : elements) {
//                WebElement name = element.findElement(By.className("name"));
//                WebElement star = element.findElement(By.className("star"));
//                WebElement img = element.findElement(By.cssSelector("img.board-img"));
//
//                System.out.println(img.getAttribute("src"));
//                System.out.println(star.getText());
//                System.out.println(name.getText());
//
//            }

        }

    }


