package store.softstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.softstore.model.Permission;
import store.softstore.model.User;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
