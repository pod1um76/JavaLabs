package src;

import java.util.*;

public class Employee {
    private String name, surname, position;
    private double fixedSalary;

    public Employee(String name, String surname, int fixedSalary, String position) {
        this.name = name;
        this.surname = name;
        this.fixedSalary = fixedSalary;
        this.position = position;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getSurname() {
        return surname;
    }
    public void setSalary(int fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
    public double getSalary() {
        return fixedSalary;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getPosition() {
        return position;
    }
}
interface EmployeePosition {
    String getJobTitle();
    double calcSalary();
}
class Manager implements EmployeePosition {
    Company company = new Company();
    public String getJobTitle() {
        return "Manager";
    }
    public double calcSalary() {
        return company.baseSalary + (((115000 + Math.random() * 140000) * 5) / 100);
    }
}
class TopManager implements EmployeePosition {
    Company company = new Company();
    public String getJobTitle() {
        return "TopManager";
    }
    public double calcSalary() {
        if (company.companyIncome > 10000000) {
            return company.baseSalary + ((company.baseSalary * 150) / 100);
        }
        return  0;
    }
}
class Operator implements EmployeePosition {
    Company company = new Company();
    public String getJobTitle() {
        return "Operator";
    }
    public double calcSalary() {
        return company.baseSalary;
    }
}
class Company {
    public List<Employee> employees = new ArrayList<>();
    int index;
    public double baseSalary, companyIncome = 11000000;
    public void hire(Employee employee) {
        Manager manager = new Manager();
        TopManager topManager = new TopManager();
        Operator operator = new Operator();
            if (employee.getPosition() == "Manager") {
                employees.add(new Employee("Vasa", "Pupkin", manager.calcSalary(), "Manager"));
            }
            else if (employee.getPosition() == "TopManager") {
                employees.add(new Employee("Peta", "Kashkov", topManager.calcSalary(), "TopManager"));
            }
            else if (employee.getPosition() == "Operator") {
                employees.add(new Employee("Kola", "Petrov", operator.calcSalary(), "Operator"));
            }
    }
    public void hireAll(String position, double numberEmployees ) {
        Manager manager = new Manager();
        TopManager topManager = new TopManager();
        Operator operator = new Operator();
        for (index = 0; index < numberEmployees; index++) {
            if (position == "Manager") {
                employees.add(index, new Employee("Vasa", "Pupkin", manager.calcSalary(), "Manager"));
            }
            else if (position == "TopManager") {
                employees.add(index, new Employee("Peta", "Kashkov", topManager.calcSalary(), "TopManager"));
            }
            else if (position == "Operator") {
                employees.add(index, new Employee("Kola", "Petrov", operator.calcSalary(), "Operator"));
            }
        }
    }
    public void fire() {
        for (index = 0; index < (employees.size()) / 2; index++) {
            employees.remove(index);
        }
    }
    public double getIncome(double companyIncome) {
        return companyIncome;
    }
    public void show() {
        for (Employee i: employees) {
            System.out.println(i.getName() + " " + i.getSurname() + " " + i.getSalary() + " " + i.getPosition());
        }
    }
    public void sortSalaryTop(){
        Map<Employee, Double> mapSort = new TreeMap<Employee, Double>(new Comparator<Employee>() {
            public int compare(Employee obj1, Employee obj2) {
                return obj1.toString().compareTo(obj2.toString());
            }
        });
        mapSort.putAll((Map<? extends Employee, ? extends Double>) employees);
    }
    public List<Employee> getLowestSalaryStaff(int count) {
        if (count < 0 && count > employees.size()) {
            return null;
        }
        for (int i = 0; i < employees.size(); i++) {
            for (int j = 0; j < employees.size() - 1 - i; j++) {
                if (employees.get(j).getSalary() > employees.get(j + 1).getSalary()) {
                    Employee t;
                    t = employees.get(j);
                    employees.set(j, employees.get(j + 1));
                    employees.set(j + 1, t);
                }

            }
        }
        List<Employee> lowerSalary = new ArrayList<Employee>();
        for (int i = 0; i < count; i++) {
            lowerSalary.add(employees.get(i));
        }
        return lowerSalary;
    }
}
class TestEmployee {
    public static void main() {
        Company company = new Company();
        company.hireAll("Top Manager", 10);
        company.hireAll("Manager", 80);
        company.hireAll("Operator", 180);
        company.show();
        company.fire();
    }
}