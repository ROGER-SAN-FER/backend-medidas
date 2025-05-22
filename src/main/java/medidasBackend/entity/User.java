package medidasBackend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.MergedAnnotationSelector;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_USER")
    @SequenceGenerator(name = "generator_USER", sequenceName = "USER_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name= "SEX")
    private String sex;

    @Column(name= "BIRTHDAY")
    private LocalDate birthday;

    @Column(name = "EMAIL")
    @Email
    private String email;

    @Column(name = "PHONE")
    @Size(min = 9, max = 9)
    private String phone;

    @Column(name = "TOWN")
    private String town;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(
            targetEntity = Measure.class,
            mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<Measure> measures;
}