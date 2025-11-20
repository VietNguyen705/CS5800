import java.util.ArrayList;
import java.util.List;

class VendingMachine {
    private List<Snack> snacks;
    private StateOfVendingMachine currentState;
    private StateOfVendingMachine idleState;
    private StateOfVendingMachine waitingForMoneyState;
    private StateOfVendingMachine dispensingState;
    private SnackDispenseHandler dispenseHandler;
    private String selectedSnack;
    private double insertedMoney;

    public VendingMachine() {
        snacks = new ArrayList<>();
        idleState = new IdleState(this);
        waitingForMoneyState = new WaitingForMoneyState(this);
        dispensingState = new DispensingState(this);
        currentState = idleState;
        setupHandlerChain();
    }

    private void setupHandlerChain() {
        CokeHandler coke = new CokeHandler();
        PepsiHandler pepsi = new PepsiHandler();
        CheetosHandler cheetos = new CheetosHandler();
        DoritosHandler doritos = new DoritosHandler();
        KitKatHandler kitkat = new KitKatHandler();
        SnickersHandler snickers = new SnickersHandler();

        coke.setNext(pepsi);
        pepsi.setNext(cheetos);
        cheetos.setNext(doritos);
        doritos.setNext(kitkat);
        kitkat.setNext(snickers);

        dispenseHandler = coke;
    }

    public void addSnack(Snack snack) {
        snacks.add(snack);
    }

    public Snack getSnackByName(String name) {
        for (Snack snack : snacks) {
            if (snack.getName().equals(name)) {
                return snack;
            }
        }
        return null;
    }

    public void selectSnack(String snackName) {
        currentState.selectSnack(snackName);
    }

    public void insertMoney(double amount) {
        currentState.insertMoney(amount);
    }

    public void setState(StateOfVendingMachine state) {
        currentState = state;
    }

    public StateOfVendingMachine getState() {
        return currentState;
    }

    public StateOfVendingMachine getIdleState() {
        return idleState;
    }

    public StateOfVendingMachine getWaitingForMoneyState() {
        return waitingForMoneyState;
    }

    public StateOfVendingMachine getDispensingState() {
        return dispensingState;
    }

    public SnackDispenseHandler getDispenseHandler() {
        return dispenseHandler;
    }

    public void setSelectedSnack(String snackName) {
        selectedSnack = snackName;
    }

    public String getSelectedSnack() {
        return selectedSnack;
    }

    public void setInsertedMoney(double amount) {
        insertedMoney = amount;
    }

    public double getInsertedMoney() {
        return insertedMoney;
    }
}
