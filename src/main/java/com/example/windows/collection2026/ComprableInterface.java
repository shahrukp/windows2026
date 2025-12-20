package com.example.windows.collection2026;

public class ComprableInterface implements  Comparable<ComprableInterface> {


    private  int id;
    private  int pincode;
    private String  username ;
    private  int age;


    public ComprableInterface(){

    }

    public ComprableInterface(int id, int pincode, String username, int age) {
        this.id = id;
        this.pincode = pincode;
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ComprableInterface{" +
                "id=" + id +
                ", pincode=" + pincode +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int pincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String username() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int age() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(ComprableInterface o) {
        return Integer.compare(o.age, this.age); // decendig order
    }
}
