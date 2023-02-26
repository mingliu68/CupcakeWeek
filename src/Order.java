import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;



public class Order {
    public Order(ArrayList<Main.Cupcake> cupcakeMenu, ArrayList<Main.Drink> drinkMenu) {
        System.out.println("Hello customer. Would you like to place an order? (Y or N)");

        Scanner scanner = new Scanner(System.in);

        String placeOrder = scanner.nextLine();

        ArrayList<Object> order = new ArrayList<>();

        if(placeOrder.equalsIgnoreCase("Y")) {

            order.add(LocalDate.now());
            order.add(LocalTime.now());
            System.out.println("Here is the menu.");
            System.out.println("CUPCAKES:");
            int itemNumber = 0;
            for(int i = 0; i < cupcakeMenu.size(); i++) {
                itemNumber++;
                System.out.print(itemNumber + " - ");
                cupcakeMenu.get(i).type();

                System.out.println("Price: $" + cupcakeMenu.get(i).getPrice());
                System.out.println();
            }
            System.out.println("DRINKS:");
            for(int i = 0; i < drinkMenu.size(); i++) {
                itemNumber++;
                System.out.print(itemNumber + " - ");
                drinkMenu.get(i).type();

                System.out.println("Price: $" + drinkMenu.get(i).getPrice());
                System.out.println();
            }
            boolean ordering = true;

            while(ordering) {
                System.out.println("What would you like to order? \nPlease use the number associated with each item to order.");
                int orderChoice = scanner.nextInt();
                scanner.nextLine();
                if( orderChoice > 0 && orderChoice < 4) {
                    order.add(cupcakeMenu.get(orderChoice - 1));
                    System.out.println("Item added to order.");
                } else if ( orderChoice > 3 && orderChoice < 7) {
                    order.add(drinkMenu.get(orderChoice - 4));
                    System.out.println("Item added to order.");
                } else {
                    System.out.println("Sorry, we don’t seem to have that on the menu.");
                    System.out.print("Would you like to continue ordering? (Y/N)\t");
                    placeOrder = scanner.nextLine();
                    if(!placeOrder.equalsIgnoreCase("Y")) {
                        ordering = false;
                    }
                }
            }

            System.out.println(order.get(0));
            System.out.println(order.get(1));
            double subtotal = 0.0;
            double price = 0.0;
            for(int i = 2; i < order.size(); i++) {
                
                if (order.get(i).equals(cupcakeMenu.get(0))) {
                    cupcakeMenu.get(0).type();
                    price = cupcakeMenu.get(0).getPrice();
                    System.out.println("$" + price);
                    subtotal += price;        
                } else if (order.get(i).equals(cupcakeMenu.get(1))) {
                    cupcakeMenu.get(1).type();
                    price = cupcakeMenu.get(1).getPrice();
                    System.out.println("$" + price);
                    subtotal += price;        
                } else if (order.get(i).equals(cupcakeMenu.get(2))) {
                    cupcakeMenu.get(2).type();
                    price = cupcakeMenu.get(2).getPrice();
                    System.out.println("$" + price);
                    subtotal += price;        
                } else if (order.get(i).equals(drinkMenu.get(0))) {
                    drinkMenu.get(0).type();
                    price = drinkMenu.get(0).getPrice();
                    System.out.println("$" + price);
                    subtotal += price;        
                } else if (order.get(i).equals(drinkMenu.get(1))) {
                    drinkMenu.get(1).type();
                    price = drinkMenu.get(1).getPrice();
                    System.out.println("$" + price);
                    subtotal += price;        
                } else if (order.get(i).equals(drinkMenu.get(2))) {
                    drinkMenu.get(2).type();
                    price = drinkMenu.get(2).getPrice();
                    System.out.println("$" + price);
                    subtotal += price;        
                }

            }
            System.out.println("$" + subtotal + "\n");
            new CreateFile();
            new WriteToFile(order);

        } else {
            System.out.println("Have a nice day then.");
        }
        
        scanner.close();
    }

    public class CreateFile {
        public CreateFile() {
            try {
                File salesData = new File("salesData.txt");
                if(salesData.createNewFile()) {
                    System.out.println("A new file created: " + salesData.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
    }

    public class WriteToFile {
        public WriteToFile(ArrayList<Object> order) {
            try {
                FileWriter fw = new FileWriter("salesData.txt", true);
                PrintWriter salesWriter = new PrintWriter(fw);
                for(int i = 0; i < order.size(); i++) {
                    salesWriter.println(order.get(i));
                }
                salesWriter.close();
                System.out.println("Successfully wrote to file.");
            } catch(IOException e) {
                System.out.println("An error occurred");
            }


        }
    }
}
