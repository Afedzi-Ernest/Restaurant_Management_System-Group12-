
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Manager extends Employee{
    static String adminname = "admin";
    static int adminpswd = 9999;

    public static final String FILE_NAME = "employee_list";
    public static final String FILE_NAME2 = "employee_password";

    public static void saveListToFile(List<String> list, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveListToFile2(List<Integer> list, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> loadListFromFile(String fileName) {
        List<String> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            list = (List<String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Integer> loadListFromFile2(String fileName) {
        List<Integer> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            list = (List<Integer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }


    static Scanner stringinput = new Scanner(System.in);
    static Scanner input = new Scanner(System.in);

    public static boolean verifyManagerName(String managerName){
        if( adminname.equals( managerName )){
            return (true);
        }
        return (false);
    }

    public static boolean verifyManagerPassword(int managerPswd){
        if( adminpswd == managerPswd){
            return (true);
        }
        return (false);
    }

    public static void showMngOptions(){
        System.out.println("\n1. Add Employee" +
                "\n2. Remove Employee " +
                "\n3. Add Item to Menu\n"+
                "4. Previous Page\n" +
                "5. View All Employees\n"+
                "6. Cancel Operation\n"
        );
    }




    public Manager(){
        new Employee(1,"111","Ernest","Staff",4);
        new Employee(2,"112","Jackson","Staff",5);
        new Employee(3,"113","Jackson","manager",10);
        new Menu("BANKU AND OKRO ",45);
        new Menu("JOLLOF RICE AND CHICKEN ",35);
        new Menu("YAM AND KONTOMIRE  ",25);
        new Menu("PLAIN RICE AND FISH ",30);
        new Menu("FUFU AND GROUNDNUT SOUP ",45);

    }


    public Manager(int a, String b, String c, String d, int e){
//        new Employee(a,b,c,d,e);
        employeesList.add(c);
        employeespassword.add(b);
        EmployeesId.add(a);
        saveListToFile(employeesList,FILE_NAME);
        saveListToFile(employeespassword,FILE_NAME2);
    }
    public static void addNewStaff(){
        System.out.println("Provide the following details of the new Staff");

        System.out.println("Staff Id:");
        int newId = input.nextInt();

        System.out.println("Staff Password:");
        String newPswd = input.next();

        System.out.println("Staff Name: ");
        String newStaff = stringinput.next();

        System.out.println("Staff Position: ");
        String newStaffPosition = stringinput.next();

        System.out.println("Staff hours: ");
        int newStaffHours = input.nextInt();

        //adding employee to the employee list
        new Manager(newId,newPswd,newStaff,newStaffPosition,newStaffHours);
        Home.newOptions();
    }

    public static void removeStaff(String name) {
        employeesList = Manager.loadListFromFile(Manager.FILE_NAME);
        Iterator<String> iterator = employeesList.iterator();
        while (iterator.hasNext()) {
            String seen = iterator.next();
            if (seen.equals(name)) {
                iterator.remove();
            }
        }
        Manager.saveListToFile(employeesList, Manager.FILE_NAME);
        List<String> employeesList = Manager.loadListFromFile(Manager.FILE_NAME);
        if (employeesList.isEmpty()) {
            System.out.println("Employee list is empty.");
        } else {
            System.out.println("\nEmployee list:");
            for (String employee : employeesList) {
                System.out.println(employee);
            }
        }
        showMngOptions();
    }

    public static void addNewMenuItem(){
        System.out.println("Enter item name: ");
        String itemName = stringinput.next();

        System.out.println("Enter item price: ");
        int itemPrice = input.nextInt();

        //adding item to the menu list
        new Menu(itemName,itemPrice);
    }


}
