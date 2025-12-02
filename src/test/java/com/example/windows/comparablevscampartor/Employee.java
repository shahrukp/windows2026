package com.example.windows.comparablevscampartor;

public class Employee  implements  Comparable<Employee>{


    private String name;
    private Double salary;
    private String departmet ;

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double salary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String departmet() {
        return departmet;
    }

    public void setDepartmet(String departmet) {
        this.departmet = departmet;
    }

    public Employee(String name, Double salary, String departmet) {
        this.name = name;
        this.salary = salary;
        this.departmet = departmet;
    }

    public Employee(){

    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", departmet='" + departmet + '\'' +
                '}';
    }

    /**
     * @param o the object to be compared.
     * @return
     */
//    returns:
//< 0 if a < b
//0 if a == b
//> 0 if a > b

    @Override
    public int compareTo(Employee o) {
       return o.salary.compareTo(this.salary); // retrun ascending order
    }
//    @Override
//    public int compareTo(Employee o) {
//        if (this.salary > o.salary) {
//            return -1; // this comes before o
//        } else if (this.salary < o.salary) {
//            return 1;  // this comes after o
//        } else {
//            return 0;  // equal
//        }
//    }



//    @Override
//    public int compareTo(Employee o) {
//        int salaryCompare = o.salary.compareTo(this.salary); // descending
//        if (salaryCompare != 0) {
//            return salaryCompare;
//        } else {
//            return this.name.compareTo(o.name); // ascending name as tie-breaker
//        }
//    }



//    @Override
//    public int compareTo(Employee o) {
//        if (o.salary == null && this.salary == null) return 0;
//        if (o.salary == null) return -1;
//        if (this.salary == null) return 1;
//
//        return o.salary.compareTo(this.salary);
//    }



    // THIS BELOW IS USE FOR WHEN EMPLOYEE HAS SAME SALARY THEN COMPARE WITH DEPARMEENT AS ALPHA
//    @Override
//    public int compareTo(Employee o) {
//        // Primary: Salary descending
//        int salaryCompare = o.salary.compareTo(this.salary);
//        if (salaryCompare != 0) {
//            return salaryCompare;
//        }
//
//        // Secondary: Department ascending
//        int deptCompare = this.department.compareTo(o.department);
//        if (deptCompare != 0) {
//            return deptCompare;
//        }
//
//        // Tertiary: Name ascending
//        return this.name.compareTo(o.name);
//    }










}
