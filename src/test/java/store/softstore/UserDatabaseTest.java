package store.softstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.persistenceunit.PersistenceManagedTypesScanner;
import org.springframework.test.context.junit4.SpringRunner;
import store.softstore.model.Permission;
import store.softstore.model.User;
import store.softstore.repository.PermissionRepository;
import store.softstore.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "store.softstore")
public class UserDatabaseTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PermissionRepository permissionRepository;


}