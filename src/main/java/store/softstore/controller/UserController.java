package store.softstore.controller;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.softstore.model.Permission;
import store.softstore.model.User;
import store.softstore.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/user/")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // 测试登录，浏览器访问： http://localhost:8081/user/doLogin?username=zhang&password=123456
    @RequestMapping("doLogin")
    public String doLogin(String username, String password) {
        Optional<User> userOptional = userRepository.findIdByUsername(username);
        if (userOptional.isEmpty()) {
            return "User not found";
        } else{
            User login_user = userOptional.orElse(new User());
            if (login_user.getPassword().equals(password)){
                StpUtil.login(login_user.getId());
                SaSession session = StpUtil.getTokenSession();
                Long login_id = login_user.getId();
                session.set("login_id", login_id);
                return "Login success";
            } else {
                return "Login failure";
            }
        }

    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    // 查询 Token 信息  ---- http://localhost:8081/acc/tokenInfo
    @RequestMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    // 测试注销  ---- http://localhost:8081/acc/logout
    @RequestMapping("logout")
    public SaResult logout() {
        if (StpUtil.isLogin()) {
            SaSession session = StpUtil.getTokenSession();
            Long login_id = session.getLong("login_id");
            System.out.println(login_id);
            StpUtil.logout(login_id);
            return SaResult.data("Logout Success");
        } else {
            return SaResult.data("Not login");
        }
    }



}
