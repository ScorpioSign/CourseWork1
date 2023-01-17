public class Employee {
    private String name;
    private int department;
    private int salary;
    public static int counter;
    private int id;


    public Employee(String name,int department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        counter ++;
        id = counter;
    }
    public String getName(){
        return this.name;
    }
    public int getDepartment() {
        return this.department;
    }
    public int getSalary(){
        return this.salary;
    }
    public int getId(){
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "ID " + id + " Ф.И.О " + this.name +" ; отдел " + this.department + " ; зарплата: " + this.salary;
    }
}
