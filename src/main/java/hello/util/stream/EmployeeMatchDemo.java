
package hello.util.stream;
 
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class EmployeeMatchDemo {
  public static void main(String[] args) {
     Predicate<Employee> p1 = e -> e.id < 10 && e.name.startsWith("A");
     Predicate<Employee> p2 = e -> e.age < 10000;
     List<Employee> list = Employee.getEmpList();
     //using allMatch
     boolean b1 = list.stream().allMatch(p1);
     System.out.println(b1);
     boolean b2 = list.stream().allMatch(p2);
     System.out.println(b2);
     //using anyMatch
     boolean b3 = list.stream().anyMatch(p1);
     System.out.println(b3);
     boolean b4 = list.stream().anyMatch(p2);
     System.out.println(b4);
     //using noneMatch
     boolean b5 = list.stream().noneMatch(p1);
     System.out.println(b5);
     
     list.forEach(System.out::println);
     
     list.forEach(Employee::getName);
     String name="A";
     for(Employee employee:list){
    	 System.out.println("name:"+employee.getName());
    	 if(list.stream().anyMatch(t->t.getName().equals(name))){
    		 
    		 System.out.println("a is correct");
    	 }
     }
     
     Employee c1 = new Employee(1, "A1", 45);
     Employee c2 = new Employee(2, "A2", 55);
     Employee c3 = new Employee(3, "A3", 65);
     
     Arrays.asList(c1, c2, c3).forEach(System.out::println);
    
    // boolean b6=list.stream().anyMatch(t->t.getName().equals(name));
    // System.out.println(b6);
     
     
     
     boolean allEmpAbove21 = list.stream()
             .allMatch(emp -> emp.age > 21);
     System.out.println("All employees are above 21:" + allEmpAbove21);

	boolean allEmpAbove2 = list.stream()
	.allMatch(employ -> employ.getAge() > 30);
	System.out.println("All employees are above 30:" + allEmpAbove2);

     
    /* Output 
     true
     true
     true
     false*/

	
	List<String> myList =  Arrays.asList("a1", "a2", "b1", "c2", "c1");
	
	Stream<String> myList2= myList.stream()
		    .filter(s -> s.startsWith("c"))
		    .map(String::toUpperCase)
		    .sorted();
			
	
	System.out.println("All employees are above 30:" + myList2);
/*	myList
    .stream()
    .filter(s -> s.startsWith("c"))
    .map(String::toUpperCase)
    .sorted()
    .forEach(System.out::println);*/

	
  }    
} 