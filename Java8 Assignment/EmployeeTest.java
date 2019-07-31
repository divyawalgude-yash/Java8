package com.java8.Assignment;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeTest {

	public static void main(String[] args) {
        Employee employee1 = new Employee(
                "Yash",
                20,
                new Address("1234"),
                Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));
     
            Employee employee2 = new Employee(
                "Ram",
                20,
                new Address("1235"),
                Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));
     
            Employee employee3 = new Employee(
                "Sita",
                20,
                new Address("1236"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
            
            
            List<Employee> employees = Arrays.asList(employee1, employee2, employee3);
            System.out.println(employees);
           
           //Get employee with exact match name "Yash", if not found print "Not found".
           Optional employee=employees.stream().filter(s->s.getName().equalsIgnoreCase("yash")).findFirst();
           System.out.println("Employee  with exact match name Yash.= ");
           System.out.print(employee.orElse("not found"));
            
            
           // Get employee with matching address "1235"
           employees.stream().filter(s->s.getAddress().getZipcode().equals("1235")).forEach(s->System.out.println("Employee with matching address 1235 = "+s));
           
            
               
           // Get all employee having mobile numbers 3333.
           List<Employee>moblielist= employees.stream().filter(s->s.getMobileNumbers().stream().anyMatch(x->x.getNumber().equalsIgnoreCase("3333"))).collect(Collectors.toList());
           System.out.println("All employee having mobile numbers 3333 = "+moblielist);
           
            
            
          
            // Convert List<Employee> to List<String> of employee name
            List<String> empNameList=employees.stream().map(s->s.getName()).collect(Collectors.toList());
            System.out.println("List Of Employee Names = "+empNameList);
           
            // Sort List<String>
            Stream<String> sortedList=empNameList.stream().sorted();
            System.out.println("Sorted Employee List= ");
            sortedList.forEach(System.out::println);
            
            
             // Collect all the names of employees in a string separated by ||
            String empNameWithJoin=employees.stream().map(s->s.getName()).collect(Collectors.joining("||"));
            System.out.print("Employee Names With Separated by || =:     ");
            System.out.println(empNameWithJoin);
            
            // Change the case of List<String>
            System.out.println("Employee Names With Different Cases (LowerCase and UpperCase)");
            empNameList.stream().map(s->s.toLowerCase()).forEach(System.out::print);
            System.out.println();
            empNameList.stream().map(s->s.toUpperCase()).forEach(System.out::print);
           
            
            // sort List<Employee> based on name
            System.out.print("Sorting Employee based on Name");
            Collections.sort(employees,Comparator.comparing(Employee::getName));
            System.out.println(employees);
            
             
        
            
	}
}
