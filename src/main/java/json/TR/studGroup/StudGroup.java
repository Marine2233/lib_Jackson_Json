package json.TR.studGroup;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudGroup {
    public static void main(String[] args) {
        StudGroup group = new StudGroup("Group",LocalDate.of(2026,5,12),new ArrayList<>());
        group.getStudents().add(new Student(1,"student 1 ", "password",LocalDate.of(1996,2,1),new ArrayList<>(),"123"));
        group.getStudents().add(new Student(2,"student 2 ", "password2",LocalDate.of(1996,8,8),List.of("Java","SF"),"123"));

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
//        mapper.findAndRegisterModules();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("studGroup.json"), group);
            System.out.println("write to file done.");
        } catch (IOException e) {
            System.out.println("Exception Write To file." + e.getMessage());
            throw new RuntimeException(e);
        }

        try {
            StudGroup res = mapper.readValue(new File("studGroup.json"),StudGroup.class);
            res.getStudents().forEach(System.out::println);
            System.out.println(res.getGroupName());
            Student maxAge = res.students.stream().min(Comparator.comparing(Student::getBirthDate)).orElse(null);
            System.out.println("Max age "+maxAge);
            List<Student> javaCourse = group.students.stream().filter(student -> student.getCourses().contains("Java")).collect(Collectors.toList());
            System.out.println("Course Java "+javaCourse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @JsonProperty(value = "group_name")
    private String groupName;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate creationDate;
    private List<Student> students;

}
