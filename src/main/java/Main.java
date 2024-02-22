import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoffeeMenu coffeeMenu = new CoffeeMenu();
        List<Coffee> coffee_list = new ArrayList<>();

        System.out.println("Welcome to the coffee shop!");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        while (true) {
            coffeeMenu.displayMenu();

            System.out.print("Enter the coffee you want: ");
            String userInput = sc.nextLine();

            try {
                CoffeeType chosenCoffeeType = CoffeeType.valueOf(userInput.toUpperCase());
                Coffee coffee = coffeeMenu.orderCoffee(chosenCoffeeType);
                if (coffee == null) {
                    System.out.println("Sorry, this coffee is not available in the menu.");
                    break;
                } else {
                    coffee.grindCoffee();
                    coffee.makeCoffee();
                    coffee.pourIntoCup();
                    coffee_list.add(coffee);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid coffee choice. Please select from the available options.");
                 continue;
            }

            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Do you want to order another coffee? ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Great!");
            } else if (choice == 2) {
                System.out.println("See you next time, " + name + "!");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }

        try (Connection con = DriverManager.getConnection(DbConnection.getConUrl(),
                DbConnection.getConUsername(),
                DbConnection.getConPassword())) {
            String sql = "INSERT INTO coffee_shop (client_name, client_order) VALUES (?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, name);
                StringBuilder strB = new StringBuilder();

                for (int i = 0; i < coffee_list.size(); i++) {
                    strB.append(coffee_list.get(i).coffeeKind());
                    if (i < coffee_list.size() - 1) {
                        strB.append(", ");
                    }
                }

                pstmt.setString(2, strB.toString());

                pstmt.executeUpdate();
                System.out.println("Order inserted successfully into the database.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting order into the database.", e);
        }


        sc.close();
    }

}
