package application;

import common.Rule;
import service.UserService;
import service.UserServiceImple;
import user.User;

import java.util.Random;

public class Adventure {

    private UserService service = UserServiceImple.getUserServiceInstance();

    public User start(User user) throws InterruptedException {

        String userName = user.getName();
        int userLevel = user.getLevel();
        int baseExp;
        int addExp = 0;
        Random random = new Random();

        System.out.println(userName + "님의 모험이 시작되었습니다...");

        while (userLevel < Rule.MAX_LEVEL)
        {
            Thread.sleep(1000);
            System.out.println("몬스터를 발견했습니다...");
            Thread.sleep(300);
            System.out.println("결투중...");
            Thread.sleep(300);
            System.out.println("몬스터에게 승리했습니다...");
            Thread.sleep(300);

            //몬스터를 잡고 발생하는 경험치
            addExp = random.nextInt(100) + 10;
            System.out.println("경험치 +" + addExp + "를(을) 얻었습니다.");

            service.addExpAndLevelUp(user, addExp);

            userLevel = user.getLevel();
            baseExp = user.getBaseExp();
            addExp = 0;

            System.out.println("----------------------------------------------------");
            System.out.println("현재 레벨 :" + userLevel + " 현재 경험치 :" + baseExp + "/10");
            System.out.println("----------------------------------------------------");

        }

        //최고레벨일경우 전직
        if(user.isMaxLevel()) {
            System.out.println("전직을 하십시오 :"  + user.getLevel());
            user = service.newPosition(user);
        }


        return user;
    }

}


