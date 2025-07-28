package locators;

import org.openqa.selenium.By;

public class ProductsPageLocators {
    public static final By productsPageHeader = By.xpath("//span[@class='title']");
    public static final By productsPageMenuButton = By.xpath("//button[@id='react-burger-menu-btn']");
    public static final By logOutButton = By.xpath("//a[@id='logout_sidebar_link']");
    public static final By cartButton = By.xpath("//a[@class='shopping_cart_link']");

    public static final By sortButton = By.xpath("//select[@class='product_sort_container']");
    public static final By itemHeader = By.xpath("//div[@class='inventory_item_name ']");

    public static final By firstItemName = By.xpath("(//div[@class='inventory_item_name '])[1]");
    public static final By itemPrice = By.xpath("(//div[@class='inventory_item_price'])[1]");
    public static final By itemAddtoCart = By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory '])[1]");
    public static final By itemRemoveFromCart = By.xpath("(//button[@class='btn btn_secondary btn_small btn_inventory '])[1]");
}
