
import java.util.Scanner;


public class Home extends Manager {
    static int userChoice;
    static int userChoice2;
    static String empname;
    static int emppassword;
    static String mngName;
    static int mngpassword;

    public Home(){
        super();
    }



    public static void showMainMenu(){
        int userChoice;
        System.out.print(
                """

                        ///////////////////////////////////////////////////////////////
                        ///                         WELCOME                         ///
                                           ------ [Main Menu] ---------\s
                        [1]. Log In\s
                        ----------------------------------------------------------- ///
                        [2]. Quit\s
                        ----------------------------------------------------------- ///
                        Select an option to continue:\s""");

        getUserChoice();
    }


    public static void getUserChoice(){
        userChoice = input.nextInt();

        switch (userChoice) {
            case 1 -> {
                System.out.print("""

                        [1]. Log In as an Employee
                        [2]. Log In as a Manager
                        [3]. Return To Previous Page
                        Select an option to continue:\s""");
                manageLogIn();
            }
            case 2 -> System.out.println("Program Exited");
            default -> throw new IllegalStateException("Unexpected value: " + userChoice);
        }
    }

    public static void manageLogIn() {
        Scanner input = new Scanner(System.in);
        userChoice2 = input.nextInt();

        switch (userChoice2) {
            case 1 -> {
                System.out.print("\n Enter your name: ");
                empname = input.next();
                System.out.print(" Enter your Password: ");
                emppassword = input.nextInt();

                //verify employee login

                if(Manager.verifyEmployee(empname) && (Manager.verifyEmployeePassword(emppassword))){
                    System.out.print("\n\nLogged in as " + empname);
                    Menu.showMenu();

                }
                else if (Manager.verifyEmployee(empname) && !(Manager.verifyEmployeePassword(emppassword))) {
                    System.out.println("Incorrect Password");
                }
                else if (!Manager.verifyEmployee(empname) && (Manager.verifyEmployeePassword(emppassword))) {
                    System.out.println("Name not recognized");
                }
                else{
                    System.out.println("Access Denied");
                    showMainMenu();
                }


            }
            case 2 -> {
                System.out.print("\nEnter Manager name: ");
                mngName = input.next();
                System.out.print("Enter Manager password: ");
                mngpassword = input.nextInt();

                //verify manager login
                if(verifyManagerName(mngName) && verifyManagerPassword(mngpassword)){
                    System.out.println("\nLogged in as " + mngName);
                    showMngOptions();
                    userChoice = input.nextInt();
                    switch (userChoice){
                        case 1:
                            while(userChoice != 4){
                                addNewStaff();
                                System.out.print("Do you want to add another Staff (y / n) : ");
                                char mngInput = stringinput.next().charAt(0);
                                switch (mngInput) {
                                    case 'y':
                                    case 'Y':
                                        addNewStaff();
                                    case 'n':
                                    case 'N':
                                        showMngOptions();
                                        userChoice = input.nextInt();
                                        if(userChoice != 4){
                                            showMngOptions();
                                            userChoice = input.nextInt();
                                        }
                                        else if (userChoice == 4){
                                            System.out.print("""
                        
                                                [1]. Log In as an Employee
                                                [2]. Log In as a Manager
                                                [3]. Return To Previous Page
                                                Select an option to continue:\s""");
                                                manageLogIn();
                                        }
                                        else if(userChoice == 5){
                                            System.out.println("Program exits!\n");
                                            return;
                                        }
                                }
                            }


                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                }

                else  {
                    System.out.println("password mismatch");
                    showMainMenu();
                }
            }
            case 3->{
                int userChoice;
                System.out.print(
                        """
        
                                ///////////////////////////////////////////////////////////////
                                ///                         WELCOME                         ///
                                                   ------ [Main Menu] ---------\s
                                [1]. Log In\s
                                ----------------------------------------------------------- ///
                                [2]. Quit\s
                                ----------------------------------------------------------- ///
                                Select an option to continue:\s""");

                getUserChoice();
            }
            default -> {
                System.out.println("Invalid input, please choice another choice: ");
                getUserChoice();
            }
        }
    }



    public static void main(String[] args){
        Home b = new Home();
        b.showMainMenu();


    }
}
