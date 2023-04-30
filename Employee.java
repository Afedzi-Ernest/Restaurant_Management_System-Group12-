import java.util.ArrayList;
import java.util.List;



public class Employee {
    int employeeId;
    String emppassword;
    String Name;
    String position;
    int hours;

    static List<String> employeesList = new ArrayList<>();
    static List<String> newemployeeList = new ArrayList<>();
    static List<String> employeespassword = new ArrayList<>();
    static List<String> newemployeepassword = new ArrayList<>();
    static List<Integer> EmployeesId = new ArrayList<>();

    public static boolean verifyEmployee(String employeename){
        newemployeeList = Manager.loadListFromFile(Manager.FILE_NAME);
        for(String name : newemployeeList){
            if(name.equals(employeename)){
                return (true);
            }
        }
        return false;
    }

    public static boolean veriryOldEmployee(String employeename){
        for(String name :employeesList){
            if(name.equals(employeename)){
                return true;
            }
        }
        return  false;
    }

    public static boolean verifyOldEmployeePassword(String employeepswd){
        for(String pswd : employeespassword){
            if(pswd.equals(employeepswd)){
                return (true);
            }
        }
        return false;
    }

    public static boolean verifyEmployeePassword(String employeepswd){
        newemployeepassword= Manager.loadListFromFile(Manager.FILE_NAME2);
        for(String pswd : newemployeepassword){
            if(pswd.equals(employeepswd)){
                return (true);
            }
        }
        return false;
    }



    public Employee(){
        employeeId = 0;
        Name = "";
        position = "";
        hours = 0;
    }

    public Employee(int employeeId,String emppassword, String Name, String position, int hours){
        EmployeesId.add(employeeId);
        employeesList.add(Name);
        employeespassword.add(emppassword);
        setEmppassword(emppassword);
        setEmployeeId(employeeId);
        setName(Name);
        setPosition(position);
        setHours(hours);

    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmppassword(String emppassword) {
        this.emppassword = emppassword;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setName(String Name) {
        this.Name = Name;
    }





    public static void main(String[] args) {
    }

}
