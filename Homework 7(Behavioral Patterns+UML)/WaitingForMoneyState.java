class WaitingForMoneyState implements StateOfVendingMachine {
    private VendingMachine machine;

    public WaitingForMoneyState(VendingMachine machine) {
        this.machine = machine;
    }

    public void selectSnack(String snackName) {
        System.out.println("Already have a selection. Insert money or cancel.");
    }

    public void insertMoney(double amount) {
        System.out.println("Inserted: $" + String.format("%.2f", amount));
        machine.setInsertedMoney(amount);

        Snack snack = machine.getSnackByName(machine.getSelectedSnack());
        if (snack == null) {
            System.out.println("Snack not found. Returning money.");
            machine.setState(machine.getIdleState());
            return;
        }

        if (amount >= snack.getPrice()) {
            if (snack.getQuantity() > 0) {
                machine.setState(machine.getDispensingState());
                machine.getState().dispenseSnack();
            } else {
                System.out.println("Out of stock. Returning money.");
                machine.setState(machine.getIdleState());
            }
        } else {
            System.out.println("Not enough money. Need $" + String.format("%.2f", snack.getPrice()));
            machine.setState(machine.getIdleState());
        }
    }

    public void dispenseSnack() {
        System.out.println("Insert money first");
    }
}
