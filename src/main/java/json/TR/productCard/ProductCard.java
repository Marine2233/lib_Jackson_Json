package json.TR.productCard;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductCard {
    public static void main(String[] args) {
        ProductCard card = new ProductCard("p1","",new ArrayList<>(),18000,false);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("card.json"),card);
            System.out.println("Information write to file.");
        } catch (IOException e) {
            System.out.println("Exception write to file.");
            throw new RuntimeException(e);
        }

        try {
            ProductCard reserve = mapper.readValue(new File("card.json"),ProductCard.class);
            System.out.println(reserve);
        } catch (IOException e) {
            System.out.println("Exception read file. "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
    private String name;
    private String description;
    private List<String> images;
    private double price;
    private boolean available;

}
