package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.List;
import java.util.Random;

public class ProductPage extends BasePage{

    @FindBy(id = "pd_add_to_cart")
    public WebElement addToCartBtn;

    @FindBy(xpath = "(//div[@class='product-code'])[2]")
    public WebElement productCode;

    public void addToCartAfterSizeSelection(){
        WebElement sizeOptions;
        try {
            sizeOptions = Driver.get().findElement(By.xpath("//div[@class='col-xs-12 size-area main-size-area pt-5']//a[@data-tracking-label='BedenSecenekleri']"));
            selectSizeFromOptions();
        }catch (Exception e){}
        addToCartBtn.click();
    }

    public void selectSizeFromOptions(){
        List<WebElement> sizeOptionsList = Driver.get().findElements(By.xpath("//div[@class='col-xs-12 size-area main-size-area pt-5']//a[@data-tracking-label='BedenSecenekleri']"));

        WebElement selectedSizeOption;
        while (true){
            selectedSizeOption = BrowserUtils.selectRandomFromList(sizeOptionsList);
            if (selectedSizeOption.isEnabled()){
                selectedSizeOption.click();
                break;
            }
        }
    }

    public String getProductCode(){

        String productCodeText = productCode.getText().trim();
        return productCodeText;

    }
}
