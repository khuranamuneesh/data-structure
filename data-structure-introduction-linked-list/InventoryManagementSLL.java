class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    public Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head;

    public void addItem(String name, int id, int quantity, double price, Integer position) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null || position == null || position == 0) {
            newItem.next = head;
            head = newItem;
        } else {
            Item temp = head;
            int count = 0;
            while (temp.next != null && count < position - 1) {
                temp = temp.next;
                count++;
            }
            newItem.next = temp.next;
            temp.next = newItem;
        }
    }

    public void removeItem(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head, prev = null;
        while (temp != null && temp.id != id) {
            prev = temp;
            temp = temp.next;
        }
        if (temp != null) prev.next = temp.next;
    }

    public void updateQuantity(int id, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    public Item searchItemById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    public Item searchItemByName(String name) {
        Item temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public double calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        return total;
    }

    public void displayInventory() {
        Item temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManagementSLL {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItem("Laptop", 101, 10, 800.0, 0);
        inventory.addItem("Mouse", 102, 50, 20.0, 1);
        inventory.addItem("Keyboard", 103, 30, 40.0, 2);

        System.out.println("\nInventory List:");
        inventory.displayInventory();

        System.out.println("\nUpdating Quantity of Item 102:");
        inventory.updateQuantity(102, 60);
        inventory.displayInventory();

        System.out.println("\nTotal Inventory Value: " + inventory.calculateTotalValue());

        System.out.println("\nRemoving Item 103:");
        inventory.removeItem(103);
        inventory.displayInventory();
    }
}

