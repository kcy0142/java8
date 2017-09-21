
package hello.util.stream;
 

import java.util.ArrayList;
import java.util.List;
public class Employee {
    public int id;
    public String name;
    public int age;
    
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Employee(int id,String name,int age  ){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public static List<Employee> getEmpList(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "A", 45));
        list.add(new Employee(2, "B", 25));
        list.add(new Employee(3, "C", 65));
        list.add(new Employee(4, "D", 22));
        return list;
    }
} 