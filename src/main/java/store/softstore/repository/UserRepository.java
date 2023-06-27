package store.softstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import store.softstore.model.Product;
import store.softstore.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.username = ?1")
    Optional<User> findUserByUsername(String username);

    @Query("select u from User u where u.Id = ?1")
    Optional<User> findUserById(Long id);

    default boolean buyProduct(User user, Product product){
        user.getPurchasedProducts().add(product);
        save(user);
        return true;
    }

}
