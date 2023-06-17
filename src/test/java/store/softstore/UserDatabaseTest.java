package store.softstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.persistenceunit.PersistenceManagedTypesScanner;
import org.springframework.test.context.junit4.SpringRunner;
import store.softstore.model.Permission;
import store.softstore.model.Role;
import store.softstore.model.User;
import store.softstore.repository.PermissionRepository;
import store.softstore.repository.RoleRepository;
import store.softstore.repository.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static cn.dev33.satoken.stp.StpUtil.getRoleList;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "store.softstore")
public class UserDatabaseTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private RoleRepository roleRepository;

    //private Role role_company = roleRepository.findById(2L);
    //private Role role_admin = roleRepository.findById(3L);



    @Test
    public void addUser() {
        Optional<Role> roleOptional = roleRepository.findById(1L);
        Role role = roleOptional.orElse(new Role(1L, "DEFAULT_ROLE"));

        User user = new User();
        user.setId(1L);
        user.setUsername("user");
        user.setPassword("user");
        user.setEmail("..");
        user.setRole(role);
        userRepository.save(user);
    }

    @Test
    public void getRoleString(){
        //Optional<Role> roleOptional = roleRepository.findById(1L);
        Optional<User> useroptional = userRepository.findById(1L);
        User user =  useroptional.orElse(new User());
        System.out.println(getRoleList(user));
    }

}