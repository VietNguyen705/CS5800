class DoritosHandler extends SnackDispenseHandler {
    public void handleRequest(String snackName, VendingMachine machine) {
        if (snackName.equals("Doritos")) {
            Snack snack = machine.getSnackByName("Doritos");
            System.out.println("Dispensing Doritos");
            snack.decreaseQuantity();
        } else if (next != null) {
            next.handleRequest(snackName, machine);
        }
    }
}
