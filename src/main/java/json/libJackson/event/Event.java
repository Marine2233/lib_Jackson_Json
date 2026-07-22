package json.libJackson.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        //mapper.findAndRegisterModules();
        List<Event>events = List.of(
        new Event("Title1",LocalDate.of(2026,5,14),
                LocalDateTime.of(2026,5,14,13,0),
                LocalDateTime.of(2026,5,14,16,0)),
        new Event("Title2",LocalDate.of(2026,8,12),
                LocalDateTime.of(2026,8,12,10,0),
                LocalDateTime.of(2026,8,12,16,0)),
        new Event("Title3",LocalDate.of(2026,10,22),
                LocalDateTime.of(2026,10,22,17,0),
                LocalDateTime.of(2026,10,22,22,0)),
        new Event("Title4",LocalDate.of(2026,7,30),
                LocalDateTime.of(2026,7,30,0,0),
                LocalDateTime.of(2026,7,30,6,0)));

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("event. json"),events);
            System.out.println("File writer.");
        } catch (IOException e) {
            System.out.println("Exception writer." + e.getMessage());
            throw new RuntimeException(e);
        }
        try {
            List<Event>reserve = mapper.readValue(new File("event. json"), new TypeReference<List<Event>>() {});
            System.out.println("Json readers: ");
            reserve.forEach(System.out::println);

            reserve.forEach(event ->{
                    Duration dur = Duration.between(event.getStartTime(),event.getEndTime());
                System.out.println("duration: "+dur.toMinutes());
            });
        } catch (IOException e) {
            System.out.println("Exception reader File." + e.getMessage());
            throw new RuntimeException(e);
        }


    }
    private String title;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;
    @JsonFormat(pattern = "dd.MM.yyyyHH:mm")
    private LocalDateTime startTime;
    @JsonFormat(pattern = "dd.MM.yyyyHH:mm")
    private LocalDateTime endTime;

}
