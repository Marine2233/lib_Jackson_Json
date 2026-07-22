package json.libJackson.studGroup;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties({"id","password"})//перечисление нежелательных полей
public class Student {
    private int id;
    @JsonProperty(value = "full_name")
    private String fullName;
    private String password;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthDate;
    private List<String> courses;
    private String phone;

}
