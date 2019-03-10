package application;

import service.UserService;
import service.UserServiceImple;
import user.User;

public class Game {

    private UserService userService = new UserServiceImple();
    private Adventure adventure = new Adventure();

    public void start() {

        //캐릭터 생성 -> 조건 닉네임 입력
        User user = userService.newUser();
        //종족 선택
        user = userService.selectUserType(user);
        //모험 시작
        try {
            user = adventure.firstAdventure(user);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //전직 후 두번째 모험
        user = adventure.SecondAdventure(user);


    }
}
