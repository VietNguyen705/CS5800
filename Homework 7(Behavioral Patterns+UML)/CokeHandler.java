class CokeHandler extends SnackDispenseHandler {
    public void handleRequest(String snackName, VendingMachine machine) {
        if (snackName.equals("Coke")) {
            Snack snack = machine.getSnackByName("Coke");
            System.out.println("Dispensing Coke");
            snack.decreaseQuantity();
        } else if (next != null) {
            next.handleRequest(snackName, machine);
        }
    }
}
