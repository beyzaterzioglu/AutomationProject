package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;

import static locators.ProductDetailsPageLocators.backToProductsButton;
import static locators.ProductDetailsPageLocators.itemHead;
import static locators.ProductsPageLocators.firstItemName;
import static pages.PageObject.driver;

public class ProductDetailsPage extends PageObject {
    public ProductDetailsPage(WebDriver driver) {

        super(driver);
    }
  public void openDetailPage()
    {
    driver.findElement(firstItemName).click();
    }
   public boolean checkItemDetailsHeader()
   {
       String header=productHeader();
       openDetailPage();
       return header.equals(driver.findElement(itemHead).getText());
   }
    public void backToProducts()
    {
        openDetailPage();
        driver.findElement(backToProductsButton).click();
    }

}
