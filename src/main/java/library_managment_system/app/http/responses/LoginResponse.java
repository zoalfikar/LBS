package library_managment_system.app.http.responses;
import jakarta.validation.constraints.*;
import lombok.*;
import java.sql.Timestamp;


@NoArgsConstructor
@AllArgsConstructor

@Data
public class LoginResponse {

    @NotNull(message="author name is required")
    private String token;

    @NotNull(message="author name is required")
    private long expiresIn;

}
