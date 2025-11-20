class KitKatHandler extends SnackDispenseHandler {
    public void handleRequest(String snackName, VendingMachine machine) {
        if (snackName.equals("KitKat")) {
            Snack snack = machine.getSnackByName("KitKat");
            System.out.println("Dispensing KitKat");
            snack.decreaseQuantity();
        } else if (next != null) {
            next.handleRequest(snackName, machine);
        }
    }
}
