public class ShipDemo {
    public static void main(String[] args) {
        Ship[] fleet = new Ship[3];
        fleet[0] = new Ship("Heritage", "1999");
        fleet[1] = new CruiseShip("Ocean Dream", "2012", 3200);
        fleet[2] = new CargoShip("Iron Titan", "2008", 55000);

        for (Ship s : fleet) {
            s.print();
        }
    }
}

