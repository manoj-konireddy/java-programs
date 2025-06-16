class student{
    String name = "manoj";
    int roll = 262;
    String branch = "EEE";
    float cgpa = 8.6f;
}
class Employee{
    String name = "manoj konireddy";
    String role = "Ethical hacker";
    int id = 21;
    float salary = 250000f;
}
class Main{
    public static void main(String[] args){
        student s = new student();
        System.out.println("--> Student data <--");
        System.out.println("Name: "+s.name);
        System.out.println("Roll: "+s.roll);
        System.out.println("Branch: "+s.branch);
        System.out.println("CGPA: "+s.cgpa);
        System.out.println();
        
        Employee e = new Employee();
        System.out.println("--> Employee data <--");
        System.out.println("Name: "+e.name);
        System.out.println("Role: "+e.role);
        System.out.println("ID: "+e.id);
        System.out.println("Salary: "+e.salary);
    }
}