package decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoyaltyDiscountTest {

    @Test
    public void testApplyDiscountGoldMember() {
        LoyaltyDiscount gold = new LoyaltyDiscount("Gold", 0.15);
        double finalCost = gold.applyDiscount(100.00);
        assertEquals(85.00, finalCost, 0.01);
    }

    @Test
    public void testApplyDiscountSilverMember() {
        LoyaltyDiscount silver = new LoyaltyDiscount("Silver", 0.10);
        double finalCost = silver.applyDiscount(50.00);
        assertEquals(45.00, finalCost, 0.01);
    }

    @Test
    public void testGetStatus() {
        LoyaltyDiscount gold = new LoyaltyDiscount("Gold", 0.15);
        assertEquals("Gold", gold.getStatus());
    }

    @Test
    public void testGetDiscountRate() {
        LoyaltyDiscount silver = new LoyaltyDiscount("Silver", 0.10);
        assertEquals(0.10, silver.getDiscountRate(), 0.001);
    }

    @Test
    public void testApplyDiscountPlatinumMember() {
        LoyaltyDiscount platinum = new LoyaltyDiscount("Platinum", 0.20);
        double finalCost = platinum.applyDiscount(200.00);
        assertEquals(160.00, finalCost, 0.01);
    }

    @Test
    public void testApplyDiscountNoDiscount() {
        LoyaltyDiscount regular = new LoyaltyDiscount("Regular", 0.0);
        double finalCost = regular.applyDiscount(100.00);
        assertEquals(100.00, finalCost, 0.01);
    }
}
