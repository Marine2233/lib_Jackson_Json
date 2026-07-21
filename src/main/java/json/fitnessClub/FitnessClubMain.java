package json.fitnessClub;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FitnessClubMain {
    public static void main(String[] args) {
        Training training = new Training("4 час", "FG",new Trainer("MS","AAR","FG"));
        ObjectMapper mapper = new ObjectMapper();
        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("training.json"),training);
            System.out.println("Файл записан.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            String train = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(training);
            System.out.println("чтение в строку\n " + train);
            Training tr = mapper.readValue(train,Training.class);
            System.out.println("чтение из строки\n " + tr);
            Training training1 = mapper.readValue(new File("training.json"),Training.class);
            System.out.println("чтение из файла" + training1);
        } catch (JsonProcessingException e) {
            System.out.println("Ошибка чтения " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Ошибка чтения IO " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
