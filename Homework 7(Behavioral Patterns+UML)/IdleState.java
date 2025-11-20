class IdleState implements StateOfVendingMachine {
    private VendingMachine machine;

    public IdleState(VendingMachine machine) {
        this.machine = machine;
    }

    public void selectSnack(String snackName) {
        System.out.println("Selected: " + snackName);
        machine.setSelectedSnack(snackName);
        machine.setState(machine.getWaitingForMoneyState());
    }

    public void insertMoney(double amount) {
        System.out.println("Please select a snack first");
    }

    public void dispenseSnack() {
        System.out.println("Please select a snack first");
    }
}
