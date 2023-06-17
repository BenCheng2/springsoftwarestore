package store.softstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    private Long id;

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
