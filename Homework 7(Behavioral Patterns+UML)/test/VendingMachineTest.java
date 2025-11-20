import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {
    private VendingMachine machine;

    @BeforeEach
    void setup() {
        machine = new VendingMachine();
        machine.addSnack(new Snack("Coke", 1.50, 5));
        machine.addSnack(new Snack("Pepsi", 1.50, 3));
    }

    @Test
    void testAddSnack() {
        Snack snack = machine.getSnackByName("Coke");
        assertNotNull(snack);
        assertEquals("Coke", snack.getName());
    }

    @Test
    void testSnackPrice() {
        Snack snack = machine.getSnackByName("Coke");
        assertEquals(1.50, snack.getPrice());
    }

    @Test
    void testSnackQuantity() {
        Snack snack = machine.getSnackByName("Pepsi");
        assertEquals(3, snack.getQuantity());
    }

    @Test
    void testDecreaseQuantity() {
        Snack snack = machine.getSnackByName("Coke");
        int before = snack.getQuantity();
        snack.decreaseQuantity();
        assertEquals(before - 1, snack.getQuantity());
    }

    @Test
    void testInitialStateIsIdle() {
        assertEquals(machine.getIdleState(), machine.getState());
    }

    @Test
    void testSelectSnackChangesState() {
        machine.selectSnack("Coke");
        assertEquals(machine.getWaitingForMoneyState(), machine.getState());
    }
}
