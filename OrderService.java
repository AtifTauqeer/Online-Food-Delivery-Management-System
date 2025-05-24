import java.util.*;

public class OrderService {
    private List<Order> orders = new ArrayList<>();
    private int orderCounter = 1;

    public Order createOrder(User user){
        Order order = new Order(orderCounter++, user);
        orders.add(order);
        return order;
    }

    public Order findOrderById(int id){
        for (Order order : orders){
            if (order.getId() == id){
                return order;
            }
        }
        return null;
    }

    public List<Order> getAllOrders(){
        return orders;
    }
}
