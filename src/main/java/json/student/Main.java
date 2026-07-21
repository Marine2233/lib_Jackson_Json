package json.student;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Student student =
                new Student(
                        "Анна",
                        18,
                        4.9);

        ObjectMapper mapper =
                new ObjectMapper();

        mapper.writeValue(
                new File("student.json"),
                student);

        System.out.println("JSON создан.");
    }
}
