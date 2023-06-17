package store.softstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.softstore.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
