import java.util.*;

class Employee {
    int id;
    String name;
    double salary;
    String dept;

    Employee(int id, String name, double salary, String dept) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {

        ArrayList<Employee> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 Add Employee");
            System.out.println("2 View Employees");
            System.out.println("3 Update Employee");
            System.out.println("4 Delete Employee");
            System.out.println("5 Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("Enter id: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter name: ");
                String name = sc.nextLine();

                System.out.print("Enter salary: ");
                double sal = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter dept: ");
                String dept = sc.nextLine();

                Employee e = new Employee(id, name, sal, dept);
                list.add(e);
                System.out.println("Added");

            } else if (ch == 2) {

                if (list.size() == 0) {
                    System.out.println("No data");
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        Employee e = list.get(i);
                        System.out.println(e.id + " " + e.name + " " + e.salary + " " + e.dept);
                    }
                }

            } else if (ch == 3) {

                System.out.print("Enter id to update: ");
                int id = sc.nextInt();
                sc.nextLine();

                for (int i = 0; i < list.size(); i++) {
                    Employee e = list.get(i);
                    if (e.id == id) {

                        System.out.print("New name: ");
                        e.name = sc.nextLine();

                        System.out.print("New salary: ");
                        e.salary = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("New dept: ");
                        e.dept = sc.nextLine();

                        System.out.println("Updated");
                    }
                }

            } else if (ch == 4) {

                System.out.print("Enter id to delete");
                int id = sc.nextInt();

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).id == id) {
                        list.remove(i);
                        System.out.println("Deleted");
                        break;
                    }
                }

            } else if (ch == 5) {
                break;
            }
        }
    }
}
