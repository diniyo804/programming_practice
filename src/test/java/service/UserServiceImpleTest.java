package service;

import org.junit.Test;
import user.User;
import static org.junit.Assert.*;

public class UserServiceImpleTest {

    @Test
    public void newUser() {
        UserService service = new UserServiceImple();
        String nickname = "diniyo";
   //     assertArrayEquals("diniyo", nickname, service.newUser());
    }

}