import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.LinkedList;

public class ClosestCommonManager {
 
    // IMPORTANT: DO NOT MODIFY THIS CLASS
    public static class Employee {
 
        private final int id;
        private final String name;
        private List<Employee> reports;
 
        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
            this.reports = new ArrayList<Employee>();
        }
 
        public int getId() {
            return id;
        }
 
        public String getName() {
            return name;
        }
 
        public List<Employee> getReports() {
            return reports;
        }
 
        public void addReport(Employee employee) {
            reports.add(employee);
        }

        public String toString() {
            return name;
        }
    }
 
    /*
     * Read the attached PDF for more explanation about the problem
     * Note: Don't modify the signature of this function
     * @param ceo
     *
     * @param firstEmployee
     *            
     * @param secondEmployee
     *            
     * @return common manager for both employees that is closest to them.
     */
    @SuppressWarnings("unused")
    public static Employee closestCommonManager(Employee ceo, Employee firstEmployee, Employee secondEmployee) {
       // Implement me

       LinkedList<Employee> firstManagers = new LinkedList<>();
       LinkedList<Employee> secondManagers = new LinkedList<>();
       boolean firstFound = getManagers(ceo, firstEmployee, firstManagers);
       boolean secondFound = getManagers(ceo, secondEmployee, secondManagers);

        System.out.println(firstManagers);
        System.out.println(secondManagers);

       if (firstFound && secondFound) {
           int i = 0, j = 0;
           for (; i < firstManagers.size() && j < secondManagers.size(); i++, j++) {
               if (firstManagers.get(i) != secondManagers.get(j)) {
                   break;
               }
           }
           return firstManagers.get(i-1);
       }
        return null;
    }

    public static boolean getManagers(Employee root, Employee person, Deque<Employee> managers) {
        managers.add(root);
        if (isSame(root, person)) {
            return true;
        }
        for (int i = 0; i < root.getReports().size(); i++) {
            if (getManagers(root.getReports().get(i), person, managers)) {
                return true;
            }
        }
        managers.removeLast();
        return false;
    }

    public static boolean isSame(Employee a, Employee b) {
        if (a.getId() == b.getId() && a.getName().equals(b.getName())) {
            return true;
        }
        return false;
    }

    public static void print(Employee a) {
        System.out.println(a.getName() + " " + a.getId());
    }

    public static void main(String[] args) {
        Employee ceo = new Employee(1, "BILL");
        Employee dom = new Employee(2, "DOM");
        ceo.addReport(dom);
        ceo.addReport(new Employee(3, "SAMIR"));
        ceo.addReport(new Employee(4, "MICHAEL"));

        dom.addReport(new Employee(5, "BOB"));
        Employee peter = new Employee(6, "PETER");
        dom.addReport(peter);
        dom.addReport(new Employee(7, "PORTER"));

        peter.addReport(new Employee(8, "MILTON"));
        peter.addReport(new Employee(9, "NINA"));

        // Employee a = closestCommonManager(ceo, new Employee(8, "MILTON"), new Employee(9, "NINA"));
        // print(a);
        Employee a = closestCommonManager(ceo, new Employee(7, "PORTER"), new Employee(9, "NINA"));
        print(a);
        a = closestCommonManager(ceo, new Employee(3, "SAMIR"), new Employee(9, "NINA"));
        print(a);
        a = closestCommonManager(ceo, new Employee(6, "PETER"), new Employee(9, "NINA"));
        print(a);

    }
};