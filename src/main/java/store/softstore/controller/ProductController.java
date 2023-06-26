package store.softstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.softstore.credential.AddProductCredential;
import store.softstore.model.Product;
import store.softstore.model.User;
import store.softstore.repository.ProductRepository;
import store.softstore.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProductController(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @RequestMapping("/getProductByUserId")
    public List<Product> getProductByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            return productRepository.findProductByPublisher(user);
        } else {
            return null;
        }
    }

    @RequestMapping("/addProduct")
    public String addProduct(@RequestBody AddProductCredential addProductCredential){
        List<Product> productOptional = productRepository.findProductByTitle(addProductCredential.title);
        if (!productOptional.isEmpty()){
            return "Product already exists";
        } else {
            Product new_product = new Product();
            new_product.setTitle(addProductCredential.title);
            new_product.setSubheader(addProductCredential.subheader);
            new_product.setProduct(addProductCredential.product);
            new_product.setFirstYearPrice(addProductCredential.firstYearPrice);
            new_product.setSecondYearPrice(addProductCredential.secondYearPrice);
            productRepository.save(new_product);
            return "Product create success";
        }
    }


}
