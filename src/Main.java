import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Cupcake {
        public double price;
        public double getPrice() {
            return price;
        }
        public void setPrice(double price) {
            this.price = price;
        }
        public void type() {
            System.out.println("A basic, generic cupcake, with vanilla frosting.");
        }
    }

    static class RedVelvet extends Cupcake {
        public void type() {
            System.out.println("A red velvet based cupcake, with cream cheese frosting.");
        }
    }

    static class Chocolate extends Cupcake {
        public void type() {
            System.out.println("A chocolate based cupcake, with chocolate frosting.");
        }
    }

    static class Drink {
        public double price;
        public double getPrice() {
            return price;
        }
        public void setPrice(double price) {
            this.price = price;
        }
        public void type() {
            System.out.println("A bottle of water.");
        }
    }

    static class Soda extends Drink {
        public void type() {
            System.out.println("A bottle of soda.");
        }
    }

    static class Milk extends Drink {
        public void type() {
            System.out.println("A bottle of milk.");
        }
    }

    public static void main(String[] args) throws Exception {
    
            ArrayList<Cupcake> cupcakeMenu = new ArrayList<>();

            ArrayList<Drink> drinkMenu = new ArrayList<>();

            Cupcake cupcake = new Cupcake();
            RedVelvet redVelvet = new RedVelvet();
            Chocolate chocolate = new Chocolate();

            Drink water = new Drink();
            Soda soda = new Soda();
            Milk milk = new Milk();

            System.out.println("We are in the middle of creating the cupcake menu. " + 
                                "We currently have three cupcakes on the menu but we need to decide on pricing.");
            
            Scanner input = new Scanner(System.in);

            System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");
            cupcake.type();
            System.out.print("How much would you like to charge for the cupcake? " +
            "\n(Input a numerical number taken to 2 decimal places)\t");
            String priceText = input.nextLine();
            double price = Double.parseDouble(priceText);
            cupcake.setPrice(price);

            System.out.println("We are deciding on the price for our red velvet cupcake. Here is the description:");
            redVelvet.type();
            System.out.print("How much would you like to charge for the cupcake? " +
            "\n(Input a numerical number taken to 2 decimal places)\t");
            priceText = input.nextLine();
            price = Double.parseDouble(priceText);
            redVelvet.setPrice(price);

            System.out.println("We are deciding on the price for our chocolate cupcake. Here is the description:");
            chocolate.type();
            System.out.print("How much would you like to charge for the cupcake? " +
            "\n(Input a numerical number taken to 2 decimal places)\t");
            priceText = input.nextLine();
            price = Double.parseDouble(priceText);
            chocolate.setPrice(price);

            cupcakeMenu.add(cupcake);
            cupcakeMenu.add(redVelvet);
            cupcakeMenu.add(chocolate);


            System.out.println("We are in the middle of creating the drink menu. " + 
                                "We currently have three drinks on the menu but we need to decide on pricing.");

            System.out.println("We are deciding on the price for a bottle of water. Here is the description:");
            water.type();
            System.out.print("How much would you like to charge for a bottle of water? " +
            "\n(Input a numerical number taken to 2 decimal places)\t");
            priceText = input.nextLine();
            price = Double.parseDouble(priceText);
            water.setPrice(price);

            System.out.println("We are deciding on the price for a bottle of soda. Here is the description:");
            soda.type();
            System.out.print("How much would you like to charge for a bottle of soda? " +
            "\n(Input a numerical number taken to 2 decimal places)\t");
            priceText = input.nextLine();
            price = Double.parseDouble(priceText);
            soda.setPrice(price);

            System.out.println("We are deciding on the price for a bottle of milk. Here is the description:");
            chocolate.type();
            System.out.print("How much would you like to charge for a bottle of milk? " +
            "\n(Input a numerical number taken to 2 decimal places)\t");
            priceText = input.nextLine();
            price = Double.parseDouble(priceText);
            milk.setPrice(price);

            drinkMenu.add(water);
            drinkMenu.add(soda);
            drinkMenu.add(milk);

            new Order(cupcakeMenu, drinkMenu);
            

            input.close();
            

    }

    
     
}
