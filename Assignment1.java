// Before Refactoring (Violating SRP & OCP)
// class Employee {
//     String name;
//     double salary;

//     Employee(String name, double salary) {
//         this.name = name;
//         this.salary = salary;
//     }

//     void printPaySlip() {
//         System.out.println("Employee: " + name + ", Salary: $" + salary);
//     }

//     void saveToDatabase() {
//         System.out.println("Saving employee to database...");
//     }
// }

// After Refactoring (Following SRP & OCP)

// Employee class now only represents employee data
class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

// SRP: Separate class for printing employee details
class Emp_details {
    public void print(Employee employee) {
        System.out.println("Employee: " + employee.getName() + ", Salary: $" + employee.getSalary());
    }
}

// OCP: Storage mechanism is now extendable
interface Emp_store {
    void save(Employee employee);
}

class Db_store implements Emp_store {
    public void save(Employee employee) {
        System.out.println("Saving employee to database...");
    }
}

class File_save implements Emp_store {
    public void save(Employee employee) {
        System.out.println("Saving employee to file...");
    }
}

// Usage
public class Assignment1 {
    public static void main(String[] args) {
        Employee emp = new Employee("shyam", 5000);
        
        Emp_details printer = new Emp_details();
        printer.print(emp);
        
        Emp_store storage = new Db_store();
        storage.save(emp);
        
        // Easily switch storage method
        storage = new File_save();
        storage.save(emp);
    }
}