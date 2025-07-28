package locators;

import org.openqa.selenium.By;

public class OverviewPageLocators {

    public static final By productNameField = By.xpath("//div[@class='inventory_item_name']");
    public static final By priceField = By.xpath("//div[@class='inventory_item_price']");
    public static final By cancelButton = By.xpath("//button[@id='cancel']");
    public static final By finishButton = By.xpath("//button[@id='finish']");
    public static final By overviewPageHeader=By.xpath("//span[@class='title']");
}
