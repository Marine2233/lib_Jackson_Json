package json.SystemSaveCars;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestCarsMain {
    public static void main(String[] args) {
        SaveCars saveCars = new SaveCars(List.of(new Car("Brand",false,"120","dc",850000,"19"),
                new Car("Brand4",true,"120","kj",1000000,"22"),
                new Car("Brand7",false,"120","qq",12000000,"26"),
                new Car("Brand18",false,"190","dc",50000000,"26")));
        ObjectMapper mapper = new ObjectMapper();

        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("cars.json"),saveCars);
            System.out.println("Файл записан.");
        } catch (IOException e) {
            System.out.println("Ошибка записи " + e.getMessage());
            throw new RuntimeException(e);
        }

        try {
            String saves = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(saveCars);
            System.out.println("Чтение в строку\n"+saves);
            SaveCars cars  = mapper.readValue(new File("cars.json"),SaveCars.class);
            System.out.println("чтение из пути \n" + cars);
            SaveCars read = mapper.readValue(saves, new TypeReference<>() {
            });
            System.out.println("Чтение из строки:\n" + read);

        } catch (JsonProcessingException e) {
            System.out.println("Ошибка чтения "+e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Ошибка чтения "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
