package json.TR.studGroup;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Student {
    private int id;
    @JsonProperty(value = "full_name")
    private String fullName;
    @JsonIgnore
    private String password;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthDate;
    private List<String> courses;
    private String phone;

}
