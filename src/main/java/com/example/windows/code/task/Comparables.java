package com.example.windows.code.task;

public class Comparables  implements Comparable<Comparables>{

    int id;
    String name;

    Comparables(int id, String name) {
        this.id = id;
        this.name = name;
    }
    /**
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Comparables o) {
        return Integer.compare(o.id, this.id); // descending  order 3,2,1
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }


}
