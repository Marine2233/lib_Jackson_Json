package json.libJackson.Employee;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    public static void main(String[] args) {
        Map<String,Employee> mapEmp = new HashMap<>();
        mapEmp.put("E-1",new Employee("E1","S-ADMIN",80000));
        mapEmp.put("Ë-4",new Employee("E-2","DEW-J",150000));
        mapEmp.put("Ë-2",new Employee("E4","TL",600000));
        mapEmp.put("Ë-1",new Employee("E-3","DEW-M",230000));

        Map<String,Employee>empReserve = new HashMap<>();

        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("Employee.json"),mapEmp);
            System.out.println("Файл записан.");
        } catch (IOException e) {
            System.out.println("Ошибка записи. " + e.getMessage());
            throw new RuntimeException(e);
        }

        try{
            empReserve = mapper.readValue(new File("Employee.json"), new TypeReference<Map<String, Employee>>() {});
            System.out.println("Файл считан.");
            empReserve.forEach((key,emp)-> {
                System.out.println(key + " " + emp);
                System.out.println();
            });
            Optional<Employee> maxSal = mapEmp.values().stream().max(Comparator.comparing(Employee::getSalary));
            System.out.println("Cотрудник с максимальной оплатой: "+maxSal);
            mapEmp.forEach((k, emp) -> {
                System.out.println(emp.getSalary());
                emp.setSalary(emp.getSalary() * 1.1);
                System.out.println(emp.getName() + " новая зарплата: " + emp.getSalary());
            });
        } catch (IOException e) {
            System.out.println("Ошибка чтения." + e.getMessage());
            throw new RuntimeException(e);
        }

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("Employee.json"),mapEmp);
            System.out.println("Файл записан.");
        } catch (IOException e) {
            System.out.println("Ошибка записи. " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    private String name;
    private String position;
    private double salary;

}
