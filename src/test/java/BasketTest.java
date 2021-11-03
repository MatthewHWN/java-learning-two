import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {

    Item testItem;
    Basket testBasket;

    @BeforeEach
    public void beforeEach() {
        testItem = new Item();
        testBasket = new Basket();
    }

    @AfterEach
    public void afterEach() {
        testItem = null;
        testBasket = null;
    }

    @Test
    public void addItemCheckItemTest() {
        // Arrange
        // Act
        testBasket.addItemChecker(testItem);

        boolean result = testBasket.getBasketContents()[0].equals(testItem);

        // Assert
        assertTrue(result);

    }

    @Test
    public void addTwoItemsTest() {
        //Arrange
        Item testItem2 = new Item();
        //Act
        testBasket.addItemChecker(testItem);
        testBasket.addItemChecker(testItem2);
        boolean result = testBasket.getBasketContents()[1].equals(testItem2);
        //Assert
        assertTrue(result);
    }

    @Test
    public void addThreeItemsTest() {
        //Arrange
        Item testItem2 = new Item();
        Item testItem3 = new Item();
        //Act
        testBasket.addItemChecker(testItem);
        testBasket.addItemChecker(testItem2);
        testBasket.addItemChecker(testItem3);
        boolean result = testBasket.getBasketContents()[2].equals(testItem3);
        //Assert
        assertTrue(result);
    }

    @Test
    public void removeItemTest() {
        // Arrange
        testBasket.addItemChecker(testItem);

        // Act
        testBasket.removeItem(testItem);

        // Assert
        assertNull(testBasket.getBasketContents()[0]);

    }

    @Test
    public void removeItemFromAnyPositionInBasketTest() {
        // Arrange
        Item testItem2 = new Item();
        Item testItem3 = new Item();
        testBasket.addItemChecker(testItem);
        testBasket.addItemChecker(testItem2);
        testBasket.addItemChecker(testItem3);

        // Act
        testBasket.removeItem(testItem2);
        // Assert
        assertNull(testBasket.getBasketContents()[1]);
    }

    @Test
    public void removeItemNotInBasketTest() {
        Item testItem4 = new Item();
        testBasket.addItemChecker(testItem);

        boolean result = testBasket.removeItem(testItem4);

        assertFalse(result);
    }

    @Test
    public void basketIsFullTest() {
        Item testItem2 = new Item();
        Item testItem3 = new Item();
        Item testItem4 = new Item();

        testBasket.addItemChecker(testItem);
        testBasket.addItemChecker(testItem2);
        testBasket.addItemChecker(testItem3);
        testBasket.addItemChecker(testItem4);

        //testBasket.checkCapacity();
        boolean result = testBasket.isFull;
        assertTrue(result);

    }

    @Test
    public void checkCapacityCanChange() {
        Basket basket = new Basket(10);
        int result = basket.getCapacity();
        assertEquals(10, result);
    }

    @Test
    public void notAbleToAddSameItemTwice() {
        boolean result = testBasket.checkDuplicate(testItem,testItem);
        assertTrue(result);
    }

    @Test
    public void checkPrice() {
        BigDecimal expectedOutput = new BigDecimal(2.55).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = testItem.getPrice();

        assertEquals(expectedOutput,result);
    }

    @Test
    public void checkTotalSum() {
        testBasket.addItemChecker(new Item());
        testBasket.addItemChecker(new Item());

        BigDecimal result = testBasket.getTotal();
        assertEquals(new BigDecimal(5.10).setScale(2, RoundingMode.HALF_UP), result);
    }
}
