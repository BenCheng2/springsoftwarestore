package store.softstore.service;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;

public class CartRedisImpl {
    @Resource
    private RedisTemplate redisTemplate;

    public void addProduct(String userId, String productId, int productNum) {
        BoundHashOperations<String, String, Integer> ops = redisTemplate.boundHashOps("cart:" + userId);
        Integer oldNum = ops.get(productId);
        if (oldNum == null) {
            oldNum = 0;
        }
        ops.put(productId, oldNum + productNum);
    }

    public void removeProduct(String userId, String productId) {
        BoundHashOperations<String, String, Integer> ops = redisTemplate.boundHashOps("cart:" + userId);
        ops.delete(productId);
    }

    public void clearCart(String userId) {
        redisTemplate.delete("cart:" + userId);
    }


}
