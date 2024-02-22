class CoffeeFactory {
    public Coffee createCoffee(CoffeeType type) {
        switch (type) {
            case ESPRESSO:
                return Coffees.getCoffee(CoffeeType.ESPRESSO);
            case CAPPUCCINO:
                return Coffees.getCoffee(CoffeeType.CAPPUCCINO);
            case AMERICANO:
                return Coffees.getCoffee(CoffeeType.AMERICANO);
            default:
                throw new IllegalArgumentException("Unknown coffee type: " + type);
        }
    }
}

public class CoffeeMenu {
    private final CoffeeFactory factory;

    public CoffeeMenu() {
        this.factory = new CoffeeFactory();
    }

    public void displayMenu() {
        System.out.println("Coffee Menu:");
        System.out.println("1. Espresso");
        System.out.println("2. Cappuccino");
        System.out.println("3. Americano");
    }

    public Coffee orderCoffee(CoffeeType type) {
        return factory.createCoffee(type);
    }
}
