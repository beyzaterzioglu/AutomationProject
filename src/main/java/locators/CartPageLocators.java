package locators;

import org.openqa.selenium.By;

public class CartPageLocators {
    public static final By firstItemHeader = By.xpath("(//div[@class='inventory_item_name'])[1]");
    public static final By itemHeaders = By.xpath("//div[@class='inventory_item_name']");
    public static final By remove = By.xpath("(//button[@id='remove-sauce-labs-backpack'])[1]");
    public static final By continueShoppingButton = By.xpath("//button[@id='continue-shopping']");
    public static final By checkoutButton= By.xpath("//button[@id='checkout']");
    public static final By product=By.xpath("//div[@class='cart_item']");

}
