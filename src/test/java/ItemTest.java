import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ItemTest {

    Item testItem;
    Item testItem2;

    @BeforeEach
    public void beforeEach() {
        testItem = new Item();
        testItem2 = new Item();
    }

    @AfterEach
    public void afterEach() {
        testItem = null;
        testItem2 = null;
    }

    @Test
    public void checkThatIdsAreDifferent() {
        Item item1 = new Item();
        Item item2 = new Item();

        assertNotEquals(item1.getID(), item2.getID());
    }

}
