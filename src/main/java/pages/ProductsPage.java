package pages;

import org.openqa.selenium.WebDriver;

import static expected.ProductPageExpected.EXPECTED_PRODUCT_PAGE_HEADER;
import static locators.ProductsPageLocators.productsPageHeader;

public class ProductsPage extends PageObject{
    public ProductsPage(WebDriver driver)
    {
        super(driver);
    }
    public boolean checkProductsPageHeader()
    {

        return getPageHeader(productsPageHeader).equals(EXPECTED_PRODUCT_PAGE_HEADER);
    }

}
