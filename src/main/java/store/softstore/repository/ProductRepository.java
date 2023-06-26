package store.softstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.softstore.model.Product;
import store.softstore.model.User;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByPublisher(User publisher);

    List<Product> findProductByTitle(String title);

}
