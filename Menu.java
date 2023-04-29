
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu extends Orders{

    static List<String> MenuList = new ArrayList<>();
    static List<Integer> MenuListPrice = new ArrayList<>();

    public static final String FILE_NAME = "menu_list";
    public static final String FILE_NAME2 = "menu_price";

    public static void getEmployeeOption() {
        Scanner empInput = new Scanner(System.in);
        System.out.print("How many items is the customer purchasing: ");
        int choice = empInput.nextInt();
        int itemsAdded[] = new int[choice];
        for(int a = 0; a < choice; a++) {
            System.out.print("Enter Customer's purchase "+ (a+1) +": ");
            int purchases = empInput.nextInt();
            itemsAdded[a] = purchases;
        }

        String[] menuArray = new String[MenuList.size()];
        menuArray = MenuList.toArray(menuArray);

        Integer[] menuPrice = MenuListPrice.toArray(new Integer[MenuListPrice.size()]);//[45, 35, 25, 30, 45]

        int size = itemsAdded.length ;
        System.out.print("\n");
        System.out.print("Customer's purchase = " + "[ ");
        for(int b = 0; b < (itemsAdded.length)-1; b++){
            System.out.print(menuArray[itemsAdded[b]-1] + ", ");//123
        }
        System.out.print(" and " + menuArray[itemsAdded[size-1]-1]);
        System.out.print("]");
        System.out.println();

        System.out.print("Is that the correct customer's list? \t (press y to continue or n to restart step): ");
        char input = empInput.next().charAt(0);
        switch (input){
            case 'y': case'Y':
                System.out.print("\n\nITEMS\t\t\t\t\t PRICE ( ₵ )\n");
                for ( int a = 0; a < itemsAdded.length; a++ ){
                    System.out.println(menuArray[itemsAdded[a]-1] + "\t\t\t" + menuPrice[itemsAdded[a]-1]);
                }

                //calculating total amount to be paid

                double sum = 0;
                System.out.print("\nTOTAL AMOUNT : " );
                for(int a = 0; a < itemsAdded.length; a++){
                    sum += menuPrice[itemsAdded[a]-1];
                }
                System.out.print(sum);
                System.out.print("\n\nEnter amount paid by user:");
                double userCash = empInput.nextDouble();

                while (userCash < sum){
                    System.out.print("\nInsufficient fund to complete transaction\nEnter amount paid by user: ");
                    userCash = empInput.nextDouble();
                }
            {
                System.out.println("Balance to be given to customer: " + (userCash - sum));
            }
            System.out.println( " Do you want to perform a new transaction:  (Enter 0 to continue or 1 to abort)" );
            int a = empInput.nextInt();
            switch (a) {
                case 0:
                    showMenu();
                    break;
                case 1:
                    Home.showMainMenu();
            }

            // showMenu();
            break;

            case 'n': case'N':
                System.out.println();
                getEmployeeOption();
        }

//        System.out.println(Arrays.toString(menuPrice));


    }

    public static void calcTotal(){

    }
    public Menu(String itemtoAdd,int itemtoAddPrice){
        MenuList.add(itemtoAdd);
        MenuListPrice.add(itemtoAddPrice);
    }

    public Menu(){

    }

    public static void showMenu(){
        System.out.println(
                "\n***** [WELCOME , MAKE A SELECTION FROM THE MENU BELOW] *******\n" +
                        " \tFOOD \t\t\t\t\t   PRICE IN GH₵\n" +
                        "1. BANKU AND OKRO \t\t\t\t 45\n" +
                        "2. JOLLOF RICE AND CHICKEN \t\t 35\n"+
                        "3. YAM AND KONTOMIRE \t\t\t 25\n" +
                        "4. PLAIN RICE AND FISH \t\t\t 30\n" +
                        "5. FUFU AND GROUNDNUT SOUP \t\t 45\n "

        );
        getEmployeeOption();
    }


}


