
import java.util.Scanner;

public class Manager extends Employee{
    static String adminname = "admin";
    static int adminpswd = 9999;

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
                "\n2. Add Item to Menu" +
                "\n3. Check Elements in Menu");
    }




    public Manager(){
        new Employee(1,111,"Ernest","Staff",4);
        new Employee(2,112,"Jackson","Staff",5);
        new Employee(3,113,"Jackson","manager",10);
        new Menu("BANKU AND OKRO ",45);
        new Menu("JOLLOF RICE AND CHICKEN ",35);
        new Menu("YAM AND KONTOMIRE  ",25);
        new Menu("PLAIN RICE AND FISH ",30);
        new Menu("FUFU AND GROUNDNUT SOUP ",45);

    }


    public Manager(int a, int b, String c, String d, int e){
//        new Employee(a,b,c,d,e);
        employeesList.add(c);
        employeespassword.add(b);
        EmployeesId.add(a);
    }
    public static void addNewStaff(){
        System.out.println("Provide the following details of the new Staff");

        System.out.println("Staff Id:");
        int newId = input.nextInt();

        System.out.println("Staff Password:");
        int newPswd = input.nextInt();

        System.out.println("Staff Name: ");
        String newStaff = stringinput.next();

        System.out.println("Staff Position: ");
        String newStaffPosition = stringinput.next();

        System.out.println("Staff hours: ");
        int newStaffHours = input.nextInt();

        //adding employee to the employee list
        new Manager(newId,newPswd,newStaff,newStaffPosition,newStaffHours);

    }


}
