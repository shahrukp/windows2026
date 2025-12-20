package com.example.windows.interview_task_2026;

public class Student {


    private String studentname;
    private int id;
    private int mobilenumnber;
    private Double salary;
    private  String Department;
    private int age;
    public Student(){


    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", mobilenumnber=" + mobilenumnber +
                ", salary=" + salary +
                ", Department='" + Department + '\'' +
                ", age=" + age +
                ", studnetname=" + studentname +
                '}';
    }

    public Student( String studentname ,int id, int mobilenumnber, Double salary, String department, int age ) {
        this.id = id;
        this.mobilenumnber = mobilenumnber;
        this.salary = salary;
       this. Department = department;
        this.age = age;
        this.studentname = studentname;
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int mobilenumnber() {
        return mobilenumnber;
    }

    public void setMobilenumnber(int mobilenumnber) {
        this.mobilenumnber = mobilenumnber;
    }

    public Double salary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String Department() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public int age() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String studentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }
}
