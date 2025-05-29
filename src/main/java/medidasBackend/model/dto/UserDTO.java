package medidasBackend.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String sex;

    private LocalDate birthday;

    @Email @NotBlank
    private String email;

    @Size(min = 9, max = 9)
    private String phone;

    @NotBlank
    private String town;

    /** Ahora incluimos password en el DTO */
    @NotBlank @Size(min = 8)
    private String password;

    private List<MeasureDTO> measures;
}


