package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;

import java.util.List;
import java.util.Random;

public class SubCategoryPage extends BasePage{

    @FindBy(tagName = "h5")
    public List<WebElement> productsList;

    public String clickAnyProduct(){
        WebElement selectedProduct = BrowserUtils.selectRandomFromList(productsList);
        String productTitle = selectedProduct.getText();
        selectedProduct.click();
        return productTitle;
    }



}
