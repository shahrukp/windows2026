package com.example.windows.comparablevscampartor;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class EmployeeCompartorInterface implements Comparator<EmployeeCompartor> {

    @Override // compare salary like desecding and ascending
    public int compare(EmployeeCompartor o1, EmployeeCompartor o2) {
        return o1.salary().compareTo(o2.salary());
    }


}
