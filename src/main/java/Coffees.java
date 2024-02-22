interface Coffee {
    String coffeeKind();
    void grindCoffee();
    void makeCoffee();
    void pourIntoCup();
}

enum CoffeeType {
    ESPRESSO,
    CAPPUCCINO,
    AMERICANO
}

public class Coffees {
    public static Coffee getCoffee(CoffeeType type) {
        switch (type) {
            case ESPRESSO:
                return new Espresso();
            case CAPPUCCINO:
                return new Cappuccino();
            case AMERICANO:
                return new Americano();
            default:
                throw new IllegalArgumentException("Unknown coffee type: " + type);
        }
    }
}



class Espresso implements Coffee {
    @Override
    public String coffeeKind() {
        return "Espresso";
    }

    @Override
    public void grindCoffee() {
        System.out.println("\nGrinding coffee beans for espresso");
    }

    @Override
    public void makeCoffee() {
        System.out.println("Making espresso");
    }

    @Override
    public void pourIntoCup() {
        System.out.println("Pouring espresso into cup\n");
    }
}

class Cappuccino implements Coffee {
    @Override
    public String coffeeKind() {
        return "Cappuccino";
    }
    @Override
    public void grindCoffee() {
        System.out.println("\nGrinding coffee beans for cappuccino");
    }

    @Override
    public void makeCoffee() {
        System.out.println("Making cappuccino");
    }

    @Override
    public void pourIntoCup() {
        System.out.println("Pouring cappuccino into cup\n");
    }
}

class Americano implements Coffee {
    @Override
    public String coffeeKind() {
        return "Americano";
    }
    @Override
    public void grindCoffee() {
        System.out.println("\nGrinding coffee beans for americano");
    }

    @Override
    public void makeCoffee() {
        System.out.println("Making americano");
    }

    @Override
    public void pourIntoCup() {
        System.out.println("Pouring americano into cup\n");
    }
}

