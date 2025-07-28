package locators;

import org.openqa.selenium.By;

public class CheckoutPageLocators {
    public static final By firstName=By.xpath("//input[@placeholder='First Name']");
    public static final By lastName=By.xpath("//input[@placeholder='Last Name']");
    public static final By zipCode=By.xpath("//input[@placeholder='Zip/Postal Code']");
    public static final By continueButton=By.xpath("//input[@id='continue']");
    public static final By cancelButton=By.xpath("//button[@id='cancel']");
    public static final By checkoutPageHeader=By.xpath("//span[@class='title']");
}
