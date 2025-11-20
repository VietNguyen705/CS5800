class PepsiHandler extends SnackDispenseHandler {
    public void handleRequest(String snackName, VendingMachine machine) {
        if (snackName.equals("Pepsi")) {
            Snack snack = machine.getSnackByName("Pepsi");
            System.out.println("Dispensing Pepsi");
            snack.decreaseQuantity();
        } else if (next != null) {
            next.handleRequest(snackName, machine);
        }
    }
}
