package json.TR.uProfile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
@NoArgsConstructor
@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserProfile {
    public static void main(String[] args) {
        UserProfile profile = new UserProfile("full Name","Email","pass",
                "","desc");
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("uprof.json"),profile);
            System.out.println("information write to file");
        } catch (IOException e) {
            System.out.println("Exception write " + e.getMessage());
            throw new RuntimeException(e);
        }

        try {
            UserProfile res = mapper.readValue(new File("uprof.json"),UserProfile.class);
            System.out.println(res);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @JsonProperty(value = "full_name")
    private String fullName;
    private String email;
    @JsonIgnore
    private String password;
    private String phone;
    private String description;

}
