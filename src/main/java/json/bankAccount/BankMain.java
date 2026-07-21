package json.bankAccount;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class BankMain {
    public static void main(String[] args) {


        BankAccount bank = new BankAccount(187_000, false, "RUB", "1234567891257846", "MM");
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("bank.json"), bank);
            System.out.println("Файл записан.");
            System.out.println("Владелец: " + bank.getOwner() +
                    "\nномер счета: " + bank.getNumber() +
                    "\nвалюта: " + bank.getCurrency()+
                    "\nблокировка: " + bank.isBlocked());
        }catch (IOException e){

            System.out.println("Oшибка записи в файл json. "+e.getMessage());
        }

        try {
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(bank);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            System.out.println("Ошибка чтения файла Json: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
