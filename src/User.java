import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private List<Product> cart;
    private List<Order> orderHistory;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.cart = new ArrayList<>();
        this.orderHistory = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public void addToCart(Product product) {
        cart.add(product);
    }

    public void removeFromCart(Product product) {
        cart.remove(product);
    }

    public void placeOrder(OrderService orderService) {
        Order newOrder = orderService.createOrder(this, new ArrayList<>(cart));
        orderHistory.add(newOrder);
        cart.clear();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cart=" + cart +
                ", orderHistory=" + orderHistory +
                '}';
    }
}