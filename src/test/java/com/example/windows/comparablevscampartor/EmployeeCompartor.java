package com.example.windows.comparablevscampartor;

public class EmployeeCompartor {
// here implements the compartor interface
        private String name;
        private Double salary;
        private String departmet ;

        private String gender;

    public String gender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

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

        public EmployeeCompartor(String name, Double salary, String departmet,String gender) {
            this.name = name;
            this.salary = salary;
            this.departmet = departmet;
            this.gender=gender;
        }

        public EmployeeCompartor(){

        }
        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    ", departmet='" + departmet + '\'' +
                    '}';
        }
}
