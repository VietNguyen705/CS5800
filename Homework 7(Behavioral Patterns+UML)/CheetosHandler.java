class CheetosHandler extends SnackDispenseHandler {
    public void handleRequest(String snackName, VendingMachine machine) {
        if (snackName.equals("Cheetos")) {
            Snack snack = machine.getSnackByName("Cheetos");
            System.out.println("Dispensing Cheetos");
            snack.decreaseQuantity();
        } else if (next != null) {
            next.handleRequest(snackName, machine);
        }
    }
}
