package org.neoteric.java;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

public class FlatMapTest {

    public static void main(String[] args) {

        List<Department> departmentList=new ArrayList<>();

        Emp emp1=new Emp("hari","ep01",5000,"IT");
        Emp emp2=new Emp("jai","ep02",6000,"IT");
        Emp emp3=new Emp("rani","ep03",7000,"IT");

        Department dept1=new Department();
        dept1.setName("IT");
        dept1.setEmpList(emp1);
        dept1.setEmpList(emp2);
        dept1.setEmpList(emp3);

        Emp emp4=new Emp("akhi","ep04",8000,"CSE");
        Emp emp5=new Emp("ravi","ep05",9000,"CSE");
        Emp emp6=new Emp("lekhya","ep06",5000,"CSE");

        Department dept2=new Department();
        dept2.setName("CSE");
        dept2.setEmpList(emp4);
        dept2.setEmpList(emp5);
        dept2.setEmpList(emp6);

        Emp emp7=new Emp("karthik","ep07",4000,"ECE");
        Emp emp8=new Emp("venkat","ep08",50000,"ECE");
        Emp emp9=new Emp("churi","ep09",5000,"ECE");

        Department dept3=new Department();
        dept3.setName("ECE");
        dept3.setEmpList(emp7);
        dept3.setEmpList(emp8);
        dept3.setEmpList(emp9);

        departmentList.add(dept1);
        departmentList.add(dept2);
        departmentList.add(dept3);



        List<Emp> empList= departmentList.stream().flatMap(department -> department.getEmpList().stream()).collect(Collectors.toList());
        System.out.println(empList.size());
        System.out.println(empList);


//in company
        Optional<Emp> higheestsalaryinCompany=departmentList.stream().flatMap(
                department -> department.getEmpList().stream()).max(Comparator.comparingDouble(Emp::getSal));

        higheestsalaryinCompany.ifPresent(employee ->
                System.out.println("Highest salary employee in company " + employee.getName() + " with salary " + employee.getSal())
        );

        Optional< Emp> lowestsalaryinCompany=departmentList.stream().flatMap(
                department -> department.getEmpList().stream()).min(Comparator.comparingDouble(Emp::getSal));

        lowestsalaryinCompany.ifPresent(employee ->
                System.out.println("lowest salary employee in company " + employee.getName() + " with salary " + employee.getSal())
        );


        //in it
        Optional< Emp> higheestsalaryinIT=dept1.getEmpList().stream().max(Comparator.comparingDouble(Emp::getSal));
        higheestsalaryinIT.ifPresent(employee ->
                System.out.println("Highest salary employee in IT: " + employee.getName() + " with salary " + employee.getSal())
        );

        //in CSE
        Optional< Emp> higheestsalaryinCSE=dept2.getEmpList().stream().max(Comparator.comparingDouble(Emp::getSal));
        higheestsalaryinCSE.ifPresent(employee ->
                System.out.println("Highest salary employee in CE: " + employee.getName() + " with salary " + employee.getSal())
        );

        //in ECE
        Optional< Emp> higheestsalaryinECE=dept3.getEmpList().stream().max(Comparator.comparingDouble(Emp::getSal));
        higheestsalaryinECE.ifPresent(employee ->
                System.out.println("Highest salary employee in ECE: " + employee.getName() + " with salary " + employee.getSal())
        );



      Map<String,List<Emp>> depEmpmap= dept1.getEmpList().stream().collect(
                groupingBy(emp->emp.getDept(),Collectors.toList())
        );

        Map<String,Double> deptEmp= dept1.getEmpList().stream().collect(
                groupingBy(emp->emp.getDept(),Collectors.averagingDouble(Emp::getSal))
        );

        Map<String,Optional<Emp>> deptMaxEmp=dept1.getEmpList().stream().collect(
                groupingBy(Emp::getDept,maxBy(Comparator.comparingDouble(Emp::getSal))));


      //  Map<>



        List<String> emplistType1=dept1.getEmpList().stream().map(Emp::getDept).collect(Collectors.toList());

        List<String> empListType2=dept1.getEmpList().stream().map(emp->emp.getDept()).collect(Collectors.toList());



    }
}
