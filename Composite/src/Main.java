import java.util.ArrayList;
import java.util.List;

// Component interface
interface OrganizationalUnit {
    void add(OrganizationalUnit unit);
    void remove(OrganizationalUnit unit);
    double getSalary();
    void print();
}

// Leaf class representing an employee
class Employee implements OrganizationalUnit {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void add(OrganizationalUnit unit) {
        // This method is not applicable to employees
    }

    @Override
    public void remove(OrganizationalUnit unit) {
        // This method is not applicable to employees
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void print() {
        System.out.println("Employee: " + name + ", Salary: €" + salary);
    }
}

// Composite class representing a department
class Department implements OrganizationalUnit {
    private String name;
    private List<OrganizationalUnit> units;

    public Department(String name) {
        this.name = name;
        this.units = new ArrayList<>();
    }

    @Override
    public void add(OrganizationalUnit unit) {
        units.add(unit);
    }

    @Override
    public void remove(OrganizationalUnit unit) {
        units.remove(unit);
    }

    @Override
    public double getSalary() {
        double totalSalary = 0;
        for (OrganizationalUnit unit : units) {
            totalSalary += unit.getSalary();
        }
        return totalSalary;
    }

    @Override
    public void print() {
        System.out.println("Department: " + name);
        for (OrganizationalUnit unit : units) {
            unit.print();
        }
    }

    // Additional method to print XML format
    public void printXML() {
        System.out.println("<department name=\"" + name + "\">");
        for (OrganizationalUnit unit : units) {
            unit.print();
        }
        System.out.println("</department>");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Creating organizational units
        Employee employee1 = new Employee("Kekkonen", 1000);
        Employee employee2 = new Employee("Irmeli", 1000);

        Department development = new Department("Development");
        Department marketing = new Department("Marketing");

        development.add(employee1);
        development.add(employee2);

        Department company = new Department("Company");
        company.add(development);
        company.add(marketing);

        // Printing total salary
        System.out.println("Total Salary: €" + company.getSalary());

        // Printing organizational structure
        company.print();

        // Printing organizational structure in XML format
        System.out.println("\nOrganizational Structure (XML):");
        company.printXML();
    }
}
