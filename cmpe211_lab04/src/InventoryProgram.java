import java.util.ArrayList;
import java.util.Scanner;

public class InventoryProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> productArrayList = new ArrayList<>();
        ArrayList<Grocery> groceryArrayList = new ArrayList<>();

        System.out.println("Enter command:");
        String commands[] = sc.nextLine().trim().split(" ");
        int id = 0;
        //Product.setProductNo(0);

        while (true) {
            switch (commands[0]) {
                case "np":
                    //id++;
                    productArrayList.add(new Product(commands[1], commands[2], Integer.parseInt(commands[3])));
                    //productArrayList.get(productArrayList.size() - 1).setId(id);
                    System.out.println("Created " + productArrayList.get(productArrayList.size() - 1));
                    break;
                case "ns":
                    boolean checkPID = true;
                    for (int i = 0; i < productArrayList.size(); i++) {
                        if (productArrayList.get(i).getId() == Integer.parseInt(commands[1])){
                            groceryArrayList.add(new Grocery(productArrayList.get(i), Integer.parseInt(commands[3]), Integer.parseInt(commands[2])));
                            System.out.println("Now selling " + groceryArrayList.get(groceryArrayList.size() - 1));
                            checkPID = false;
                        }
                    }
                    if (checkPID)
                        System.out.println("Wrong Product Number.");
                    break;
                case "lp":
                    for (int i = 0; i < productArrayList.size(); i++) {
                        System.out.println(productArrayList.get(i));
                    }
                    break;
                case "ls":
                    for (int i = 0; i < groceryArrayList.size(); i++) {
                        System.out.println(groceryArrayList.get(i));
                    }
                    break;
                case "sp":
                    boolean checkPrice = false;
                    for (int i = 0; i < groceryArrayList.size(); i++) {
                        if (groceryArrayList.get(i).getProduct().getId() == Integer.parseInt(commands[1])) {
                            Grocery grocery = groceryArrayList.get(i);
                            if (grocery.getStockPrice() == Integer.parseInt(commands[3])) {
                                checkPrice = true;
                                if (grocery.getStockAmount() < Integer.parseInt(commands[2])) {
                                    System.out.println("There are not enough products. Amount of the product in the stock: " + grocery.getStockAmount());
                                } else {
                                    grocery.setStockAmount(grocery.getStockAmount() - Integer.parseInt(commands[2]));
                                    System.out.println("Remaining Stock = " + grocery);
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                    if (!checkPrice) {
                        System.out.println("There is no such product selling at " + commands[3] + "$. Please try again with correct price.");
                    }
                    break;
                case "rrs":
                    int count = 0;
                    for (int i = 0; i < groceryArrayList.size(); i++) {
                        if (groceryArrayList.get(i).getStockPrice() < groceryArrayList.get(i).getProduct().getCost()) {
                            groceryArrayList.remove(i);
                            i--;
                            count++;
                        }
                    }
                    System.out.println(count + " times risky stock found and deleted.");
                    break;
                case "dp":
                    boolean checkPNO = true;
                    for (int i = 0; i < productArrayList.size(); i++) {
                        if (productArrayList.get(i).getId() == Integer.parseInt(commands[1])){
                            System.out.println("Deleted: "+productArrayList.get(i));
                            productArrayList.remove(i);
                            checkPNO = false;
                            break;
                        }
                    }
                    if (checkPNO)
                        System.out.println("Wrong Product Number.");
                    break;
                case "q":
                    for (int i = 0; i < groceryArrayList.size(); i++) {
                        System.out.println(groceryArrayList.get(i));
                    }
                    System.exit(0);
                    break;
            }
            System.out.println("Enter command:");
            commands = sc.nextLine().trim().split(" ");
        }
    }
}
