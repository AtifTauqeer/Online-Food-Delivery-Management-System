import java.util.*;

public class Order {
    private int id;
    private User user;
    private List<OrderItem> items = new ArrayList<>();
    private String status = "Processing"; 

    public Order(int id, User user){
        this.id = id;
        this.user = user;
    }

    public void addItem(MenuItem item, int quantity){
        items.add(new OrderItem(item, quantity));
    }

    public double calculateTotal(){
        double total = 0;
        for (OrderItem item : items){
            total += item.getTotalPrice();
        }
        return total;
    }

    public int getId() { return id; }
    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
    }

    public void printReceipt(){
        System.out.println("Order ID: " + id);
        System.out.println("Customer: " + user.getName());
        System.out.println("Mobile: " + user.getMobile());
        System.out.println("Email: " + user.getEmail());
        for (OrderItem oi : items){
            System.out.println(oi.getItem().getName() + " x " + oi.getQuantity() + " = Rs" + oi.getTotalPrice());
        }
        System.out.println("Total: Rs" + calculateTotal());
        System.out.println("Status: " + status);
    }
}
