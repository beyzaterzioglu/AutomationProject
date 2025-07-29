package pages;

import org.openqa.selenium.WebDriver;

import static expected.GeneralExpecteds.EXPECTED_CART_PAGE_HEADER;
import static locators.CartPageLocators.*;
import static locators.ProductsPageLocators.firstItemName;
import static locators.ProductsPageLocators.itemAddtoCart;

public class CartPage extends PageObject{
    public CartPage(WebDriver driver)
    {
        super(driver);
    }

    public boolean checkHeader()
    {
        return driver.findElement(cartPageHeader).getText().equals(EXPECTED_CART_PAGE_HEADER);
    }
    public boolean checkItemHead()
    {
        String header = productHeader(firstItemName);
        addToCart(itemAddtoCart);
        openCartPage();
        return header.equals(driver.findElement(firstItemHeader).getText());

    }
    public boolean removeProduct()
    {
        addToCart(itemAddtoCart);
        openCartPage();
        driver.findElement(remove).click();
        return driver.findElements(product).isEmpty();
    }
    public void continueShopping()
    {
        openCartPage();
        driver.findElement(continueShoppingButton).click();
    }
    public boolean checkTheNumberOfProducts(int number)
    {
        openCartPage();
        return driver.findElements(itemHeaders).size() == number;
    }

}
