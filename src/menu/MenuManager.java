package menu;

import database.ClothingItemDAO;
import com.aknur.clothingstore.*;
import java.util.Scanner;

public class MenuManager implements Menu {

    private ClothingItemDAO itemDAO;
    private Scanner scanner;

    public MenuManager() {
        this.itemDAO = new ClothingItemDAO();
        this.scanner = new Scanner(System.in);
    }

    private void viewAllItems() {
        itemDAO.getAllItems();
    }

    private void addClothingItem() {
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Size: ");
            String size = scanner.nextLine();

            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Brand: ");
            String brand = scanner.nextLine();

            ClothingItem item = new Pants(id, name, size, price, brand, 30);
            item.applyDiscount(10);

            itemDAO.insertItem(item);
            System.out.println("Item saved to database!\uD83C\uDF1F");

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void updateClothingItem() {
        try {
            System.out.print("Enter item ID to update: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("New name: ");
            String name = scanner.nextLine();

            System.out.print("New size: ");
            String size = scanner.nextLine();

            System.out.print("New price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("New brand: ");
            String brand = scanner.nextLine();

            boolean updated =
                    itemDAO.updateItem(id, name, size, price, brand);

            if (updated) {
                System.out.println("Item updated successfully!\uD83C\uDF1F");
            } else {
                System.out.println("Item not found.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        }
    }

    private void deleteClothingItem() {
        try {
            System.out.print("Enter item ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

            ClothingItem item = itemDAO.getItemById(id);

            if (item == null) {
                System.out.println("No item found with ID: " + id);
                return;
            }

            System.out.println("Item to delete:");
            System.out.println(item.toString());

            System.out.print("Are you sure? (yes/no): ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("yes")){
                boolean deleted = itemDAO.deleteItem(id);

                if (deleted) {
                    System.out.println("Item deleted successfully.");
                } else {
                    System.out.println("Deletion failed.");
                }
            }else {
                System.out.println("Deletion cancelled.");
            }

        } catch ( NumberFormatException e){
            System.out.println("Invalid number format.");
        }
    }


    private void searchItemByName() {
        System.out.println(" Please enter name keyword: ");
        String keyword = scanner.nextLine();
        itemDAO.searchByName(keyword);
    }

    private void searchItemByPriceRange() {
        try {
            System.out.println("Enter minimum price: ");
            double min = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter maximum price: ");
            double max = Double.parseDouble(scanner.nextLine());

            itemDAO.searchByPriceRange(min, max);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format");
        }
    }

    private void filterByMinPrice(){
        try {
            System.out.println("Please enter minimum price: ");
            double min = Double.parseDouble(scanner.nextLine());
            itemDAO.filterByMinPrice(min);
        }catch (NumberFormatException e){
            System.out.println("invalid number format, please try again.");
        }
    }

    private void demonstratePolymorphism() {
        System.out.println("\n--- Polymorphism Demo ---");

        ClothingItem demoItem1 =
                new Pants(0, "Demo Pants", "M", 20000, "DemoBrand", 32);
        ClothingItem demoItem2 =
                new Skirt(0, "Demo Skirt", "S", 18000, "DemoBrand", "midi");

        demoItem1.displayInfo();
        demoItem2.displayInfo();
    }

    // MENU

    @Override
    public void displayMenu() {
        System.out.println("\n=== \uD83C\uDF1F CLOTHING STORE SYSTEM \uD83C\uDF1F ===");
        System.out.println("1. Add Clothing Item");
        System.out.println("2. View All Clothing Items");
        System.out.println("3. Update Clothing Item");
        System.out.println("4. Delete clothing item.");
        System.out.println("\n--- SEARCH AND FILTER ---");
        System.out.println("5. Search item by name.");
        System.out.println("6. Search item by price range.");
        System.out.println("7. Filter items by minimum price.");
        System.out.println("\n--- DEMO AND OTHER ---");
        System.out.println("8. Polymorphism Demo");
        System.out.println("0. Exit");
        System.out.print("Please enter your choice: ");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addClothingItem();
                        break;
                    case 2:
                        viewAllItems();
                        break;
                    case 3:
                        updateClothingItem();
                        break;
                    case 4:
                        deleteClothingItem();
                        break;
                    case 5:
                        searchItemByName();
                        break;
                    case 6:
                        searchItemByPriceRange();
                        break;
                    case 7:
                        filterByMinPrice();
                        break;
                    case 8:
                        demonstratePolymorphism();
                        break;
                    case 0:{
                        running = false;
                        System.out.println("Goodbye!\uD83C\uDF1F");
                        break;
                    }
                    default:
                        System.out.println("Invalid input.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid number format, pls try again.");
            }
        }
    }
}
