package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SubCategoryPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import static org.junit.Assert.*;

public class AddingProductStepDefs {

    HomePage page = new HomePage();
    String selectedProductTitle;
    String productCode;

    @Given("user on the LC WAIKIKI page")
    public void user_on_the_lc_waikiki_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Then("title should contain {string}")
    public void titleShouldContain(String partOfTitle) {
        partOfTitle = partOfTitle.toLowerCase();
        assertTrue(Driver.get().getTitle().toLowerCase().contains(partOfTitle));
    }

    @When("user select any {string} from {string}")
    public void userSelectAnyFrom(String subCategoryName, String categoryName) {
        page.navigateToSubCategory(categoryName,subCategoryName);
    }

    @Then("user click any product")
    public void user_click_any_product() {
        SubCategoryPage subCategoryPage = new SubCategoryPage();
        selectedProductTitle = subCategoryPage.clickAnyProduct();
    }

    @Then("user should land on product page")
    public void user_should_land_on_product_page() {
        assertTrue(Driver.get().getTitle().contains(selectedProductTitle));

    }

    @And("user add product to cart")
    public void userAddProductToCart() {
        ProductPage productPage = new ProductPage();
        productPage.addToCartAfterSizeSelection();
        productCode = productPage.getProductCode();
    }

    @And("user navigate to cart")
    public void userNavigateToCart() {
        page.cartBtn.click();
    }

    @Then("user should see the product added")
    public void user_should_see_the_product_added() {
        assertTrue(new CartPage().isProductAdded(productCode));
    }

    @Then("user navigate back to home page")
    public void user_navigate_back_to_home_page() {
        page.homePageLink.click();
    }

}
