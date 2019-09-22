package com.java8.others;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/***
 ** Created by Tushar on 2/2/19
 **/
public class SupplierFunInterfaceTest {

    public static void main(String[] args) {

        /* Here lambda expression which don't take and argument but return some result
            can be assign to variable of type Supplier FI */
        Supplier<String> strSupplier = () -> {return "Test String";};
        String name = strSupplier.get();
        System.out.println(name);


        /* Here get the list of employee names in the Supplier Interface and pass it to other method */
        Supplier<List<String>> empList = () -> {return new SupplierFunInterfaceTest().getEmpNameList();};

        printEmpNames(empList);
    }


    public List<String> getEmpNameList() {
        List<String> empNameLst = new ArrayList<>();
        empNameLst.add("Tushar");
        empNameLst.add("Vedika");
        empNameLst.add("Pallavi");

        return empNameLst;
    }



    public static void  printEmpNames(Supplier<List<String>> empNameList) {

        List<String> empNameLst = empNameList.get();

        empNameLst.stream().forEach(System.out::println);
    }
}
