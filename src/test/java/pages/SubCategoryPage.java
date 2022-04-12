package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserUtils;
import utilities.Driver;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SubCategoryPage extends BasePage{

    @FindBy(tagName = "h5")
    public List<WebElement> productsList;

    public String clickAnyProduct(){
        WebElement selectedProduct = BrowserUtils.selectRandomFromList(productsList);
        String productTitle = selectedProduct.getText();
//        BrowserUtils.scrollToElement(selectedProduct);
        new WebDriverWait(Driver.get(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(selectedProduct));
        selectedProduct.click();
        return productTitle;
    }



}
