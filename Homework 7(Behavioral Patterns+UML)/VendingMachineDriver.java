public class VendingMachineDriver {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        machine.addSnack(new Snack("Coke", 1.50, 5));
        machine.addSnack(new Snack("Pepsi", 1.50, 5));
        machine.addSnack(new Snack("Cheetos", 2.00, 5));
        machine.addSnack(new Snack("Doritos", 2.00, 5));
        machine.addSnack(new Snack("KitKat", 1.75, 5));
        machine.addSnack(new Snack("Snickers", 1.75, 1));

        System.out.println("Vending Machine Test\n");

        System.out.println("Test 1: Buy Coke");
        machine.selectSnack("Coke");
        machine.insertMoney(2.00);
        System.out.println();

        System.out.println("Test 2: Not enough money for Cheetos");
        machine.selectSnack("Cheetos");
        machine.insertMoney(1.00);
        System.out.println();

        System.out.println("Test 3: Buy Doritos");
        machine.selectSnack("Doritos");
        machine.insertMoney(2.00);
        System.out.println();

        System.out.println("Test 4: Buy Snickers (quantity 1)");
        machine.selectSnack("Snickers");
        machine.insertMoney(2.00);
        System.out.println();

        System.out.println("Test 5: Try to buy Snickers again (out of stock)");
        machine.selectSnack("Snickers");
        machine.insertMoney(2.00);
        System.out.println();

        System.out.println("Test 6: Buy KitKat");
        machine.selectSnack("KitKat");
        machine.insertMoney(1.75);
    }
}
