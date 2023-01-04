class EnjoyVehicle {

    public static void startVehicle() {
        // start your vehicle
        Vehicle v = new Vehicle();
        Vehicle.Engine e = v.new Engine();
        e.start();

    }
}
/*
important topic -- inner class
example -
https://hyperskill.org/learn/step/11505

public class Main {

    public static void main(String[] args) {

        Cat cat = new Cat("Bob");
        Cat.Bow bow = cat.new Bow("red");

        bow.printColor();
    }
}
 */