package json.TR.classWork;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        String json = """
                [
                  {
                    "name": "Анна",
                    "age": 18
                  },
                  {
                    "name": "Иван",
                    "age": 19
                  }
                ]
                """;

        ObjectMapper mapper = new ObjectMapper();


        try {
            JsonNode root =
                    mapper.readTree(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        try {
            List<Student> students = mapper.readValue(
                    json,
                    new TypeReference<List<Student>>() {
                    }
            );

            for (Student student : students) {
                System.out.println(student);
            }

        } catch (IOException e) {
            System.out.println(
                    "Ошибка чтения JSON: " + e.getMessage()
            );
        }
    }
}