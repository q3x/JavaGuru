import java.util.Scanner;

public class ShoppingList {
    public static final String TITLE = "\nThis is a shopping list application menu:";
    public static final String CHOICE = "\nEnter your choice: ";
    public static final String ERROR = "Wrong choice! Please enter valid number from menu!\n";
    public static final String NO_ITEMS = "There are no items in list!";
    public static final String ENTER_ITEM = "Enter item to add: ";
    public static final String DELETE = "Enter item to delete: ";

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String list[] = new String[0];
        boolean exit = false;

        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            if (choice == 1)
                list = addItem(list);
            else if (choice == 2)
                listItems(list);
            else if (choice == 3)
                list = deleteItem(list);
            else if (choice == 4) {
                System.out.println("Good buy!");
                exit = true;
            } else
                System.out.println(ERROR);
        }
    }


    private static String[] deleteItem(String[] list) {
        if (list.length != 0) {
            System.out.println(DELETE);
            listItems(list);
            int itemToDelete = scanner.nextInt() - 1;

            if (list.length == 0) {
                list[0] = null;
            } else {
                int arraySize = list.length - 1;
                String tempList[] = new String[arraySize];

                list[itemToDelete] = list[arraySize];
                list[arraySize] = null;

                for (int i = 0; i < arraySize; i++) {
                    tempList[i] = list[i];
                }
                list = tempList;

            }
        } else
            System.out.println("List is empty!");
        return list;
    }


    private static void listItems(String[] list) {
        if (list.length != 0) {
            for (int i = 0; i < list.length; i++)
                System.out.println("(" + (i + 1) + ") " + list[i]);
        } else {
            System.out.println(NO_ITEMS);
        }
    }


    public static String[] addItem(String[] list) {
        System.out.print(ENTER_ITEM);
        String item = scanner.next();

        int arraySize = list.length;
        String tempList[] = new String[arraySize + 1];
        tempList[arraySize] = item;

        if (arraySize > 0) {
            for (int i = 0; i < arraySize; i++) {
                tempList[i] = list[i];
            }
        }
        list = tempList;
        System.out.println(item + " was added!");
        return list;
    }


    private static void showMenu() {
        System.out.println(TITLE);
        System.out.println("1 - add an item");
        System.out.println("2 - list items");
        System.out.println("3 - delete an item");
        System.out.println("4 - exit");
        System.out.println(CHOICE);
    }
}