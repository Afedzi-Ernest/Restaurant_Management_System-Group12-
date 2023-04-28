import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    
    private Map<String, Integer> inventory;
    
    public Inventory() {
        inventory = new HashMap<String, Integer>();
    }
    
    public void addInventoryItem(String itemName, int quantity) {
        if (inventory.containsKey(itemName)) {
            int currentQuantity = inventory.get(itemName);
            inventory.put(itemName, currentQuantity + quantity);
        } else {
            inventory.put(itemName, quantity);
        }
    }
    
    public void removeInventoryItem(String itemName, int quantity) {
        if (inventory.containsKey(itemName)) {
            int currentQuantity = inventory.get(itemName);
            if (currentQuantity <= quantity) {
                inventory.remove(itemName);
            } else {
                inventory.put(itemName, currentQuantity - quantity);
            }
        }
    }
    
    public int getInventoryCount(String itemName) {
        if (inventory.containsKey(itemName)) {
            return inventory.get(itemName);
        }
        return 0;
    }
    
    public void printInventory() {
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        
        // Initial inventory items
        inventory.addInventoryItem("Tomatoes", 10);
        inventory.addInventoryItem("Cheese", 20);
        inventory.addInventoryItem("Lettuce", 5);
        
        // Prompt the admin for input
        System.out.println("\nWelcome, admin! What would you like to do?");
        System.out.println("1. View inventory");
        System.out.println("2. Add item to inventory");
        System.out.println("3. Remove item from inventory");
        System.out.println("4. Exit\n");
        
        int choice = scanner.nextInt();
        while (choice != 4) {
            switch (choice) {
                case 1:
                    inventory.printInventory();
                    break;
                case 2:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    inventory.addInventoryItem(itemName, quantity);
                    System.out.println("Item added to inventory.");
                    break;
                case 3:
                    System.out.print("Enter item name: ");
                    itemName = scanner.next();
                    System.out.print("Enter quantity to remove: ");
                    quantity = scanner.nextInt();
                    inventory.removeInventoryItem(itemName, quantity);
                    System.out.println("Item removed from inventory.");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.\n5");
                    break;
            }
            
            // Prompt the admin for input again
            System.out.println("\nWhat would you like to do next?");
            System.out.println("1. View inventory");
            System.out.println("2. Add item to inventory");
            System.out.println("3. Remove item from inventory");
            System.out.println("4. Exit\n");
            
            choice = scanner.nextInt();
        }
        
        // Exit the program
        System.out.println("\nExiting Application. ");
        scanner.close();
    }
}
