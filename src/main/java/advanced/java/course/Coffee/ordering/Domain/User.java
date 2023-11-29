package advanced.java.course.Coffee.ordering.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_table")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //ez lehet ne kell
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private String role;
    private String username;
    private String password;

    @JsonManagedReference
    @OneToMany(mappedBy = "user_id")
    private List<Order> orders;

}