package pages;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static expected.GeneralExpecteds.EXPECTED_PRODUCT_PAGE_HEADER;
import static expected.ProductPageExpected.*;
import static locators.ProductsPageLocators.*;

public class ProductsPage extends PageObject {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public enum SortType {
        NAME_A_TO_Z,
        NAME_Z_TO_A,
        PRICE_LOW_TO_HIGH,
        PRICE_HIGH_TO_LOW
    }

    public boolean checkProductsPageHeader() {
        return getPageHeader(productsPageHeader).equals(EXPECTED_PRODUCT_PAGE_HEADER);
    }


    public boolean sortBy(SortType sortType) {
        sortDropdown(sortType);

        switch (sortType) {
            case NAME_A_TO_Z:
            case NAME_Z_TO_A:
                return checkNameSorting(sortType);
            case PRICE_LOW_TO_HIGH:
            case PRICE_HIGH_TO_LOW:
                return checkPriceSorting(sortType);
            default:
                return false;
        }
    }

    private void sortDropdown(SortType sortType) {
        switch (sortType) {
            case NAME_A_TO_Z:
                chooseFromList(SORT_NAME_A_TO_Z);
                break;
            case NAME_Z_TO_A:
                chooseFromList(SORT_NAME_Z_TO_A);
                break;
            case PRICE_HIGH_TO_LOW:
                chooseFromList(SORT_PRICE_HIGH_TO_LOW);
                break;
            case PRICE_LOW_TO_HIGH:
                chooseFromList(SORT_PRICE_LOW_TO_HIGH);
                break;
        }
    }

    private boolean checkNameSorting(SortType sortType) {
        List<String> names = new ArrayList<>(makeList(itemHeader));

        if (sortType == SortType.NAME_A_TO_Z) {
            Collections.sort(names);
        } else {
            Collections.sort(names, Collections.reverseOrder());
        }

        String firstItem = driver.findElement(firstItemName).getText();
        return firstItem.equals(names.get(0));
    }

    private boolean checkPriceSorting(SortType sortType) {
        List<String> prices = new ArrayList<>(makeList(itemPrice));

        Comparator<String> comparator = Comparator.comparingDouble(this::normalizePrice);

        if (sortType == SortType.PRICE_HIGH_TO_LOW) {
            comparator = comparator.reversed();
        }

        prices.sort(comparator);

        String firstItemPriceOnPage = driver.findElement(itemPrice).getText();
        return firstItemPriceOnPage.equals(prices.get(0));
    }

    private double normalizePrice(String price) {
        return Double.parseDouble(price.replace("$", "").trim());
    }




}



