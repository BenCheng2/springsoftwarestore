package store.softstore;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Resource
    private StringRedisTemplate template;

    @Test
    public void testDataSourceConnection() {
        try {
            Connection connection = dataSource.getConnection();
            assertNotNull(connection);
            // Connection successful
            connection.close();
        } catch (SQLException e) {
            // Connection failed
            e.printStackTrace();
            fail("Failed to connect to the data source");
        }
    }

    @Test
    public void testRedisConnection(){
        template.opsForValue().set("22","22");
    }

    @Test
    public void testRedisHash(){

    }

}
