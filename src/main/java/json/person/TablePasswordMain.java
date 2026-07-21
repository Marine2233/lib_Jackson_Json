package json.person;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TablePasswordMain {
    public static void main(String[] args) {
        Person person = new Person(30, "Ann", new Passport("kjhjvg", "888888", "0000"));
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("onlinepassport.json"), person);
            System.out.println("Файл успешно записан");
        } catch (IOException e) {
            System.out.println("Ошибка чтения "+e.getMessage() );
            throw new RuntimeException(e);
        }

        try {
            Person pers = mapper.readValue(new File("onlinepassport.json"),Person.class);
            System.out.println("Чтение из файла в объект: \n" + pers);
            String persLine = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pers);
            System.out.println("\nЧтение  в строку: \n" + persLine);
            Person pars = mapper.readValue(persLine,Person.class);
            System.out.println("\nпарсинг строки:\n" + pars);
        } catch (IOException e) {
            System.out.println("Ошибка чтения "+e.getMessage() );
            throw new RuntimeException(e);
        }
    }

}
