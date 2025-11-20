class SnickersHandler extends SnackDispenseHandler {
    public void handleRequest(String snackName, VendingMachine machine) {
        if (snackName.equals("Snickers")) {
            Snack snack = machine.getSnackByName("Snickers");
            System.out.println("Dispensing Snickers");
            snack.decreaseQuantity();
        } else if (next != null) {
            next.handleRequest(snackName, machine);
        }
    }
}
