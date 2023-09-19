import java.util.Random;

public class VendingMachine {
    public static int updateBalance(int price, int balance) {
        if (balance >= price) {
            return balance - price;
        } else {
            System.out.println("Sorry, your balance is too low to purchase this item.");
            return balance;
        }
    }
    public static int buyItem(int[][] items, int balance, int itemCode) {
        for (int i = 0; i < items.length; i++) {
            if (items[i][0] == itemCode) {
                return updateBalance(items[i][1], balance);
            }
        }
        System.out.println("Sorry, the item #" + itemCode + " does not exist.");
        return balance;
    }
    public static int buyRandomItem(int[][] items, int balance) {
        Random random = new Random();
        int index = random.nextInt(items.length);
        System.out.println("The random item number is " + items[index][0]);
        return buyItem(items, balance, items[index][0]);
    }
    public static void updateItems(int[][] items, int newItemCode, int newPrice) {
        int min = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i][0] == newItemCode) {
                items[i][1] = newPrice;
                return;
            } else if (items[i][1] < items[min][1]) {
                min = i;
            }
        }
        items[min][0] = newItemCode;
        items[min][1] = newPrice;
    }
    public static void main(String[] args) {
        int[][] items = {{104, 5}, {42, 10}, {23, 9}, {90, 3}, {78, 6}, {223, 34}, {45, 8}, {56, 18}};
        int balance = 30;
        System.out.println("The item numbers and the prices are listed below:");
        for (int i = 0; i < items.length; i++) {
            System.out.println("Item #" + items[i][0] + ", $" + items[i][1]);
        }
        System.out.println("Your starting balance is $" + balance);
        balance = buyItem(items, balance, 104);
        System.out.println("Your balance after this purchase is $" + balance);
        balance = buyItem(items, balance, 5);
        System.out.println("Your balance after this purchase is $" + balance);
        balance = buyRandomItem(items, balance);
        System.out.println("Your balance after this random purchase is $" + balance);
        balance = buyRandomItem(items, balance);
        System.out.println("Your balance after this random purchase is $" + balance);
        updateItems(items, 5, 15);
        System.out.println("The updated items list 1 is: ");
        for (int i = 0; i < items.length; i++) {
            System.out.println("Item #" + items[i][0] + ", $" + items[i][1]);
        }
        updateItems(items, 104, 20);
        System.out.println("The updated items list 2 is: ");
        for (int i = 0; i < items.length; i++) {
            System.out.println("Item #" + items[i][0] + ", $" + items[i][1]);
        }
    }
}
