package json.onlineShop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class OnlineShopMain {
    public static void main(String[] args) {
        OnlineShop onlineShop = new OnlineShop(4,12,"PrI","prod",12000);
        ObjectMapper mapper = new ObjectMapper();
        try{
            mapper.writeValue(new File("online.json"),onlineShop);
            System.out.println("Файл записан.");
        } catch (IOException e) {
            System.out.println("Ошибка записи: "+e.getMessage());
            throw new RuntimeException(e);
        }

        try {
            String shop = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(onlineShop);
            OnlineShop shop1 = mapper.readValue(new File("online.json"),OnlineShop.class);
            System.out.println("чтение Json из объекта:\n"+shop1);
            shop1 = mapper.readValue(shop,OnlineShop.class);
            System.out.println("Парсинг строки\n" + shop1);
        } catch (JsonProcessingException e) {
            System.out.println("Ошибка чтения:");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("ÏOEx" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
