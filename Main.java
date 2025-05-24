import java.util.*;

public class Main {
    public static void main(String[] args){
        MenuService menuService = new MenuService();
        OrderService orderService = new OrderService();
        Scanner scanner = new Scanner(System.in);

        menuService.addMenuItem(new MenuItem(1, "Pizza", 2000));
        menuService.addMenuItem(new MenuItem(2, "Burger", 400));
        menuService.addMenuItem(new MenuItem(3, "Fries", 250));
        menuService.addMenuItem(new MenuItem(4, "Coke", 220));
        menuService.addMenuItem(new MenuItem(5, "Ice Cream", 180));

        
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter mobile number: ");
        String mobile = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        User user = new User(1, name, mobile, email);
        Order order = orderService.createOrder(user);


        System.out.println("\nMenu:");
        for (MenuItem item : menuService.getMenu()){
            System.out.println(item);
        }

        String cont = "y";
        while(cont.equalsIgnoreCase("y")){
            System.out.print("Enter item ID to add: ");
            int id = scanner.nextInt();
            MenuItem selected = menuService.getItemById(id);

            if (selected != null){
                System.out.print("Quantity: ");
                int qty = scanner.nextInt();
                order.addItem(selected, qty);
            } else {
                System.out.println("Item not found.");
            }

            System.out.print("Add more? (y/n): ");
            cont = scanner.next();
        }


        System.out.println("\n--- Receipt ---");
        order.printReceipt();


        System.out.print("\nWould you like to track an order? (y/n): ");
        String trackChoice = scanner.next();
        if (trackChoice.equalsIgnoreCase("y")) {
            System.out.print("Enter your Order ID: ");
            int searchId = scanner.nextInt();
            Order trackedOrder = orderService.findOrderById(searchId);
            if (trackedOrder != null) {
                System.out.println("\n--- Tracking Info ---");
                System.out.println("Order ID: " + trackedOrder.getId());
                System.out.println("Status: " + trackedOrder.getStatus());
            } else {
                System.out.println("Order not found.");
            }
        }
    }
}
