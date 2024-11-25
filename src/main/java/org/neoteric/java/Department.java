package org.neoteric.java;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;

    private List<Emp> empList=new ArrayList<>();


    public String getName() {
        return name;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmpList(Emp empList) {
        this.empList.add(empList);
    }
}
