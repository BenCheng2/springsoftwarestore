package store.softstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Data
@Entity
public class User  {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long Id;

    private String username;

    private String password;

    private String email;


}
