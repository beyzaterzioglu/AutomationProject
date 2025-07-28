package pages;

import org.openqa.selenium.WebDriver;

import static locators.CartPageLocators.*;
import static locators.ProductsPageLocators.firstItemName;
import static locators.ProductsPageLocators.itemAddtoCart;

public class CartPage extends PageObject{
    public CartPage(WebDriver driver)
    {
        super(driver);
    }


    public boolean checkItemHead()
    {
        String header = productHeader();
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
