package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(css = ".rd-cart-item-code")
    public List<WebElement> productCodeList;

    public List<String> getProductCodes(){
        return BrowserUtils.getElementsText(productCodeList);
    }

    /**
     * It will check the product codes from both product page and the cart
     * @param productCode
     * @return
     */
    public boolean isProductAdded(String productCode){
        boolean flag = false;
        for (String code : getProductCodes()) {
            if (productCode.contains(code)){
                flag = true;
                break;
            }
        }

        return flag;
    }



}
