import java.util.*;

public class Employee {
    private final String name;
    private final String surname;
    private final String position;
    private final double fixedSalary;

    public Employee(String name, String surname, double fixedSalary, String position) {
        this.name = name;
        this.surname = surname;
        this.fixedSalary = fixedSalary;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getSalary() {
        return fixedSalary;
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
    public double baseSalary = 5000;
    public double companyIncome = 11000000;

    public void hire(String position) {
        Manager manager = new Manager();
        TopManager topManager = new TopManager();
        Operator operator = new Operator();

        switch (position) {
            case "Manager":
                employees.add(new Employee("Sam", "Crupper", manager.calcSalary(), manager.getJobTitle()));
                break;
            case "TopManager":
                employees.add(new Employee("Dmitriy", "Shirking", topManager.calcSalary(), topManager.getJobTitle()));
                break;
            case "Operator":
                employees.add(new Employee("Gennadi", "Krylov", operator.calcSalary(), operator.getJobTitle()));
                break;
        }
    }

    public void hireAll(String position, double numberEmployees ) {
        Manager manager = new Manager();
        TopManager topManager = new TopManager();
        Operator operator = new Operator();

        for (int i = 0; i < numberEmployees; i++) {
            switch (position) {
                case "Manager":
                    employees.add(i, new Employee("Jon", "Pushkin", manager.calcSalary(), manager.getJobTitle()));
                    break;
                case "TopManager":
                    employees.add(i, new Employee("Peta", "Kharkov", topManager.calcSalary(), topManager.getJobTitle()));
                    break;
                case "Operator":
                    employees.add(i, new Employee("Kola", "Petrov", operator.calcSalary(), operator.getJobTitle()));
                    break;
            }
        }
    }

    public void fire() {
        for (int i = 0; i < (employees.size()) / 2; i++) {
            Employee remove = employees.remove(i);
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

    public void getTopSalaryStuff(int count) {
        if(count < 0 || count > employees.size()) {
            return;
        }
        ArrayList<Employee> top = new ArrayList<>(this.employees);
        top.sort(Comparator.comparing(Employee::getSalary));
        Collections.reverse(top);
        ArrayList<Employee> countOfTop = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            countOfTop.add( top.get(i) );
        }
    }

    public void getLowestSalaryStaff(int count) {
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
        List<Employee> lowerSalary = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lowerSalary.add(employees.get(i));
        }
    }

    public int longList() {
        return employees.size();
    }
}

class TestEmployee {
    public static void main(String []args) {
        Company company = new Company();
        int count = company.longList();

        System.out.println("Доход компании:" + company.getIncome(11000000));
        company.hire("TopManager");
        System.out.println("Найм сотрудника:");
        company.show();
        company.hireAll("Operator", 180);
        company.hireAll("Manager", 80);
        company.hireAll("TopManager", 10);
        System.out.println("Найм списка сотрудников:");
        company.show();
        company.fire();
        System.out.println("Увольнение половины сотрудников");
        company.show();
        company.getTopSalaryStuff(count);
        company.getLowestSalaryStaff(count);

    }
}