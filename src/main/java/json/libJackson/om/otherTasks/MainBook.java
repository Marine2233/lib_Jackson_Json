package json.libJackson.om.otherTasks;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainBook {
    public static void main(String[] args) {
        List<Book>books = List.of(new Book(1,"Java base","Author1",2018,2000),
                new Book(2,"Java pro","Author2",2010,1500),
                new Book(3,"SF","Author3",2014,3500),
                new Book(4,"Thread","Author4",2011,1000));

        Set<String>language = Set.of("Java","C#","Python","JS");

        Map<String,Integer> grads = new HashMap<>();

        grads.put("ELan",4);
        grads.put("Java",5);
        grads.put("SF",3);
        grads.put("Algorithms",3);

        ObjectMapper mapper = new ObjectMapper();

      try {
          mapper.writerWithDefaultPrettyPrinter().writeValue(new File("Grads.json"),grads);
          System.out.println("Файл записан.\n");
      } catch (Exception e) {
          System.out.println("Ошибка записи.");
          throw new RuntimeException(e);
      }

      try{
          Map<String,Integer> copy = mapper.readValue(new File("Grads.json"),new TypeReference<Map<String,Integer>>(){});
          copy.forEach((key,value)-> {
              System.out.println(key + " " + value);

              if (value < 4) {
                  System.out.println("Оценка ниже 4");
                  System.out.println(key);
              }
          });
          double avg = copy.values().stream().mapToInt(Integer::intValue).average().orElse(0.0);
          System.out.println("Средняя "+avg);
          int min = copy.values().stream().mapToInt(Integer::intValue).min().orElse(0);
          System.out.println("Минимальная оценка "+min);

      }catch (IOException e){
          System.out.println("Ошибка чтения файла."+e.getMessage());
          throw new RuntimeException();
      }

      /**
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("languages.json"),language);
            System.out.println("Файл записан.");
        } catch (IOException e) {
            System.out.println("Ошибка записи файла " + e.getMessage());
            throw new RuntimeException(e);
        }

        try{
            Set<String>readFile = mapper.readValue(new File("languages.json"), new TypeReference<Set<String>>() {});
            readFile.forEach(System.out::println);
            System.out.println("\n");
            readFile.stream().filter(string->string.contains("Java")).forEach(System.out::println);
            language.add("Kotlin");
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("languages.json"),language);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
*/

//        try {
//            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("books.json"),books);
//            System.out.println("Файл записан.");
//        } catch (IOException e) {
//            System.out.println("Ошибка записи файла " + e.getMessage());
//            throw new RuntimeException(e);
//        }
//
//        try {
//            List<Book> copy = mapper.readValue(new File("books.json"), new TypeReference<List<Book>>() {
//            });
//            System.out.println("Чтение файла.");
//            copy.forEach(System.out::println);
//            System.out.println("\nbooks after 2015 year.\n");
//            copy.stream().filter( book -> book.getYear() > 2015).forEach(System.out::println);
//        } catch (IOException e) {
//            System.out.println("Ошибка чтения.");
//            throw new RuntimeException(e);
//        }
   }
}
