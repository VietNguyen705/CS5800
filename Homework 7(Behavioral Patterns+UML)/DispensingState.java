class DispensingState implements StateOfVendingMachine {
    private VendingMachine machine;

    public DispensingState(VendingMachine machine) {
        this.machine = machine;
    }

    public void selectSnack(String snackName) {
        System.out.println("Already dispensing");
    }

    public void insertMoney(double amount) {
        System.out.println("Already dispensing");
    }

    public void dispenseSnack() {
        machine.getDispenseHandler().handleRequest(machine.getSelectedSnack(), machine);
        machine.setState(machine.getIdleState());
    }
}
