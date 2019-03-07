package application;

import service.UserService;
import service.UserServiceImple;
import user.User;

public class Game {

    private UserService userService = new UserServiceImple();

    public void start() {

        //캐릭터 생성 -> 조건 닉네임 입력
        User user = userService.newUser();

    }
}
