package org.neoteric.java;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    //        List<Emp> deptList=departmentList.stream().flatMap(department -> department.getEmpList().stream().filter(
//                highpay->{
//                    int a=0;
//                    if(a<highpay.getSal()){
//                        a= highpay.getSal();
//                    }
//                    System.out.println(a);
//                    return ;
//                }
//        ).collect(Collectors.toList())
//        );

//        Optional<Emp> highestPaidEmp = departmentList.stream()
//                .flatMap(department -> department.getEmpList().stream())
//                .max(Comparator.comparingInt(Emp::getSal));
}
