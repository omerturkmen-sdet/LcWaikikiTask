package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//*[@id='shopping-cart']/..")
    public WebElement cartBtn;

    @FindBy(className = "main-header-logo")
    public WebElement homePageLink;

    public void navigateToSubCategory(String categoryName, String subCategoryName){

        WebElement categoryLink = Driver.get().findElement(By.linkText(categoryName));
        BrowserUtils.hover(categoryLink);

        WebElement subCategoryLink = Driver.get().findElement(By.linkText(subCategoryName));
        BrowserUtils.waitForVisibility(subCategoryLink,5);
        subCategoryLink.click();

    }

}
