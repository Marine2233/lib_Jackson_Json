package json.moovieStorage;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MovieApp {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        Movie movie = new Movie("Dir","1:40",4,"1.0","2023");

        File file = new File("movie.json");
        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(file,movie);
            System.out.println("Фильм сохранен.\n");

            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(movie);
            System.out.println("Json: " );
            System.out.println(json);
            System.out.println();
            Movie movie1 = mapper.readValue(file, Movie.class);
            System.out.println("Файл считан");
            System.out.println(movie1);

        }catch (IOException e){
            throw new RuntimeException("Ошибка чтения Json.");
        }

    }


}
