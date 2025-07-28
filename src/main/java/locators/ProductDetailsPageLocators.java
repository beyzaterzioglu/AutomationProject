package locators;

import org.openqa.selenium.By;

public class ProductDetailsPageLocators {

    public static final By itemHead = By.xpath("//div[@class='inventory_details_name large_size']");
    public static final By backToProductsButton = By.xpath("//button [@id='back-to-products']");
    public static final By addToCartButton = By.xpath("//button [@id='add-to-cart']");
    public static final By removeButton = By.xpath(" //button [@id='remove']");

}
