package store.softstore.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.softstore.model.Product;
import store.softstore.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @SaCheckRole("ROLE_USER")
    @GetMapping("")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @SaCheckRole("ROLE_USER")
    @GetMapping("hi")
    public boolean Hello (){
        return StpUtil.isLogin();
    }
}
