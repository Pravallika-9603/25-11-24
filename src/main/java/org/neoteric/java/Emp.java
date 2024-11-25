package org.neoteric.java;

public class Emp {

    private String name;

    private String empid;

    private String dept;

    private int sal;

    public Emp(String name, String empid, int sal,String dept) {
        this.name = name;
        this.empid = empid;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public String getEmpid() {
        return empid;
    }

    public  int getSal() {
        return sal;
    }

    public String getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", empid='" + empid + '\'' +
                ", sal=" + sal +
                '}';
    }
}
