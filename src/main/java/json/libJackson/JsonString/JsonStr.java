package json.libJackson.JsonString;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class JsonStr {
    public static void main(String[] args) {
        String json = """
        {
          "orderId": 1057,
          "customer": {
            "name": "Анна Смирнова",
            "email": "anna@mail.ru"
          },
          "paid": true,
          "items": [
            {
              "name": "Клавиатура",
              "price": 4500.0,
              "count": 1
            },
            {
              "name": "Мышь",
              "price": 2300.0,
              "count": 2
            },
            {
              "name": "Коврик",
              "price": 900.0,
              "count": 1
            }
          ]
        }
        """;

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode node = mapper.readTree(json);
           int orderId = node.get("orderId").asInt();
            System.out.println("Num order: " + orderId);
           String nameCustomer = node.get("customer").get("name").asText();
            System.out.println("Customers:" + nameCustomer);
           String mail = node.get("customer").get("name").asText();
            System.out.println("Mail: "+mail);
           boolean paid = node.get("paid").asBoolean();
            System.out.println("Paid: "+paid);

            System.out.println("Prods: ");

            List<String>namesProd = node.get("items").findValuesAsText("name");
            System.out.println("names: ");
            namesProd.forEach(System.out::println);

            List<Integer>counts = new ArrayList<>();
            int totalPrice = 0;

            for (JsonNode item : node.get("items")) {
                counts.add(item.get("count").asInt());
                if (!node.has("deliveryAddress")) {
                    System.out.println("Адрес доставки не указан");
                }

                int cost = item.get("price").asInt() + item.get("count").asInt();
                System.out.println("final price: "+cost);
                totalPrice += item.get("price").asInt();
            }

            counts.forEach(System.out::println);
            System.out.println("Total price: " + totalPrice);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
