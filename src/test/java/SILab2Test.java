import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SILab2Test {
    @Test
    void everyStatementTestC0() {
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "1234567890123456"),
                "allItems list can't be null!");

        Item invalidItem = new Item(null, 5, 100, 0);
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(Collections.singletonList(invalidItem), "1234567890123456"),
                "Invalid item!");

        Item itemWithDiscount = new Item("item1", 5, 400, 0.1);
        double expectedSum = (400 * (1 - 0.1) * 5) - 30;
        assertEquals(expectedSum, SILab2.checkCart(Collections.singletonList(itemWithDiscount), "1234567890123456"));

        Item itemNoDiscount = new Item("item2", 3, 200, 0);
        expectedSum = 200 * 3;
        assertEquals(expectedSum, SILab2.checkCart(Collections.singletonList(itemNoDiscount), "1234567890123456"));

        Item validItem = new Item("item3", 5, 100, 0);
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(Collections.singletonList(validItem), "12345678901234ab"),
                "Invalid character in card number!");
    }

    @Test
    void multipleConditionTest() {
        Item item1 = new Item("item1", 5, 400, 0);
        double expectedSum1 = (400 * 5) - 30;
        assertEquals(expectedSum1, SILab2.checkCart(Collections.singletonList(item1), "1234567890123456"));

        Item item2 = new Item("item2", 5, 200, 0.1);
        double expectedSum2 = (200 * (1 - 0.1) * 5) - 30;
        assertEquals(expectedSum2, SILab2.checkCart(Collections.singletonList(item2), "1234567890123456"));

        Item item3 = new Item("item3", 15, 200, 0);
        double expectedSum3 = (200 * 15) - 30;
        assertEquals(expectedSum3, SILab2.checkCart(Collections.singletonList(item3), "1234567890123456"));

        Item item4 = new Item("item4", 5, 200, 0);
        double expectedSum4 = 200 * 5;
        assertEquals(expectedSum4, SILab2.checkCart(Collections.singletonList(item4), "1234567890123456"));
    }
}
