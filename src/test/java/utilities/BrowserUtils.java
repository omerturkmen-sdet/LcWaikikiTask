package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BrowserUtils {

    /**
     * We use that method to prevent using try-catch block in stepDefinitions or throw declaration for every method
     * @param seconds
     */
    public static void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * For navigating sub-category we need to hover over related category.
     * We just navigate directly without clicking category.
     * @param element
     */
    public static void hover(WebElement element){
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(element).perform();
    }

    /**
     * If element is still loading we need to wait, or we get Exception
     * @param element
     * @param timeout
     * @return
     */
    public static WebElement waitForVisibility(WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * For getting random element of a list
     * @param listOfElement
     * @return
     */
    public static WebElement selectRandomFromList(List<WebElement> listOfElement){
        Random random = new Random();
        int productNumber = random.nextInt(listOfElement.size());

        return listOfElement.get(productNumber);
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elementTexts = new ArrayList<>();
        for (WebElement element : list) {
            elementTexts.add(element.getText());
        }
        return elementTexts;
    }

}
