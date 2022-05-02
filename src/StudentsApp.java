import java.util.ArrayList;
import java.util.List;

//main class of the app
public class StudentsApp{
    public static void main(String[] args){
    Student st1 = new Student("Marcos", "78959514");
    st1.enroll("Java", 500);
    st1.enroll("Python", 400);
    st1.enroll("SQL", 300);
    st1.pay(1000);
    st1.showCourses();
    st1.checkBalance();
    st1.setPhone("+4915731428024");
    st1.setCity("Leipzig");
    st1.setState("Saxony");
    System.out.println(st1);
    }
}

//Student class
class Student{
    private static int schoolID = 1000;
    private String SSN;
    private String email;
    private String userID;
    private String name;
    private String phone;
    private String city;
    private String state;
    private List<String> courses;
    private double balance;

    //constructor
    public Student(String name, String SSN){
        this.SSN = SSN;
        this.name = name;
        this.email = generateEmail();
        this.userID = generateUserID();
        this.courses = new ArrayList<>();
        this.balance = 0.0;
        schoolID++;
    }

    //generates an email address based on name and SSN
    private String generateEmail(){
        return this.name + this.SSN.substring(0, 4) + "@university.com";
    }

    //generates the userID based on a random number and the SSN
    private String generateUserID(){
        int randomNumber = (int) (Math.random() * 10000);
        return schoolID + "" + randomNumber + this.SSN.substring(0, 4);
    }

    //Getters
    public String getSSN(){
        return this.SSN;
    }

    public String getEmail(){
        return this.email;
    }

    public String getUserID(){
        return this.userID;
    }

    public String getName(){
        return this.name;
    }

    public String getPhone(){
        return this.phone;
    }

    public String getCity(){
        return this.city;
    }

    public String getState(){
        return this.state;
    }

    public double getBalance(){
        return this.balance;
    }

    //Setters
    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setState(String state){
        this.state = state;
    }

    //other methods
    public void enroll(String courseName, double price){
        this.courses.add(courseName);
        this.balance -= price;
        System.out.println("Student " + this.name + " is now enrolled in " + courseName);
    }

    public void showCourses(){
        System.out.println("Student " + name + " courses: " + this.courses);
    }

    public void pay(double amount){
        this.balance += amount;
    }

    public void checkBalance(){
        System.out.println(name + "'s current balance: $" + this.balance);
    }

    @Override
    public String toString(){
        String s = "[";
        s += "name: " + this.getName() + "; ";
        s += "SSN: " + this.getSSN() + "; ";
        s += "userID: " + this.getUserID() + "; ";
        s += "Balance: " + this.getBalance() + "; ";
        s += "phone: " + this.getPhone() + "; ";
        s += "city: " + this.getCity() + "; ";
        s += "state: " + this.getState() + "]";
        return s;    
    }
}