import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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

//    @Disabled
//    @Test   //this test was refactored into the one below (addItemCheckItemTest)
//    public void addItemTest() {
//        // Arrange
////        Item testItem = new Item();
////        Basket testBasket = new Basket();
//        //Act
//        testBasket.addItem(testItem);
//
//        //Assert
//        assertEquals(1, testBasket.getBasketContents().length);
//
//    }

    @Test
    public void addItemCheckItemTest() {
        // Arrange
        // Act
        testBasket.addItem(testItem);

        boolean result = testBasket.getBasketContents()[0].equals(testItem);

        // Assert
        assertEquals(true, result);

    }

    @Test
    public void addTwoItemsTest() {
        //Arrange
        Item testItem2 = new Item();
        //Act
        testBasket.addItem(testItem);
        testBasket.addItem(testItem2);
        boolean result = testBasket.getBasketContents()[1].equals(testItem2);
        //Assert
        assertEquals(true, result);
    }

    @Test
    public void addThreeItemsTest() {
        //Arrange
        Item testItem2 = new Item();
        Item testItem3 = new Item();
        //Act
        testBasket.addItem(testItem);
        testBasket.addItem(testItem2);
        testBasket.addItem(testItem3);
        boolean result = testBasket.getBasketContents()[2].equals(testItem3);
        //Assert
        assertEquals(true, result);
    }

    @Test
    public void removeItemTest() {
        // Arrange
        testBasket.addItem(testItem);

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
        testBasket.addItem(testItem);
        testBasket.addItem(testItem2);
        testBasket.addItem(testItem3);

        // Act
        testBasket.removeItem(testItem2);
        // Assert
        assertNull(testBasket.getBasketContents()[1]);

        // Arrange
//        Item testItem2 = new Item();
//        Item testItem3 = new Item();
//        testBasket.addItem(testItem);
//        testBasket.addItem(testItem2);
//        testBasket.addItem(testItem3);
//
        // Act
//        boolean result = testBasket.removeItem(testItem2);
//
        // Assert
//        assertTrue(result);
    }

    @Test
    public void removeItemNotInBasketTest() {
        Item testItem4 = new Item();
        testBasket.addItem(testItem);

        boolean result = testBasket.removeItem(testItem4);

        //This works, but we would like to get the code to avoid throwing exceptions or errors.
        //assertThrows(NullPointerException.class, () -> {
        //    testBasket.removeItem(testItem4);
        //});

        assertFalse(result);
    }

    @Test
    public void basketIsFullTest() {
        Item testItem2 = new Item();
        Item testItem3 = new Item();
        Item testItem4 = new Item();

//        testBasket.capacity = 3;

        testBasket.addItem(testItem);
        testBasket.addItem(testItem2);
        testBasket.addItem(testItem3);
        testBasket.addItem(testItem4);

        //testBasket.checkCapacity();
        boolean result = testBasket.isFull;
        assertTrue(result);

    }
}
