import java.util.ArrayList;
import java.util.List;

public class Employee {
    int employeeId;
    int emppassword;
    String Name;
    String position;
    int hours;

    static List<String> employeesList = new ArrayList<>();
    static List<Integer> employeespassword = new ArrayList<>();
    static List<Integer> EmployeesId = new ArrayList<>();

    public static boolean verifyEmployee(String employeename){
        for(String name : employeesList){
            if(name.equals(employeename)){
                return (true);
            }
        }
        return false;
    }

    public static boolean verifyEmployeePassword(int employeepswd){
        for(int pswd : employeespassword){
            if(pswd == employeepswd){
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

    public Employee(int employeeId,int emppassword, String Name, String position, int hours){
        EmployeesId.add(employeeId);
        employeesList.add(Name);
        employeespassword.add(emppassword);
        setEmppassword(emppassword);
        setEmployeeId(employeeId);
        setName(Name);
        setPosition(position);
        setHours(hours);

    }
    public int getEmployeeId() {
        return employeeId;
    }

    public int getEmppassword() {
        return emppassword;
    }

    public String getName() {
        return Name;
    }


    public String getPosition() {
        return position;
    }

    public int getHours() {
        return hours;
    }

    public int getEmployeeSchedules(int ID){
        return employeeId;
    }
    public int getEmployeeHours(int ID) {
        return hours;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmppassword(int emppassword) {
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



    public void displayEmpInfo(int ID){
        System.out.println("Employee Id: " + employeeId +
                " \n Name: " + Name + " \n Position: " + position
        );
    }

    public static void main(String[] args) {
    }

}
