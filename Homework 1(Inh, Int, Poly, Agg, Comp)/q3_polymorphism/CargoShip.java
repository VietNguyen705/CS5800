public class CargoShip extends Ship {
    private int cargoCapacityTonnage;

    public CargoShip(String name, String yearBuilt, int cargoCapacityTonnage) {
        super(name, yearBuilt);
        setCargoCapacityTonnage(cargoCapacityTonnage);
    }

    public int getCargoCapacityTonnage() { return cargoCapacityTonnage; }
    public void setCargoCapacityTonnage(int cargoCapacityTonnage) { this.cargoCapacityTonnage = cargoCapacityTonnage; }

    @Override
    public void print() {
        System.out.printf("CargoShip: %s, Capacity: %d tons%n", getName(), cargoCapacityTonnage);
    }
}
