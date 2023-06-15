package store.softstore;

import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
}
