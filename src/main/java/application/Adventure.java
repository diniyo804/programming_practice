package application;

import common.Rule;
import service.UserService;
import service.UserServiceImple;
import user.User;

import java.util.Random;
import java.util.Scanner;

public class Adventure {

    private UserService service = UserServiceImple.getUserServiceInstance();

    public User firstAdventure(User user) throws InterruptedException {

        String userName = user.getName();
        int userLevel = user.getLevel();
        int baseExp;
        int addExp = 0;
        Random random = new Random();

        System.out.println("*** " + userName + "님의 모험이 시작되었습니다 ***" );
        System.out.println("----------------------------------------------------");

        while (userLevel < Rule.MAX_LEVEL) {
            Thread.sleep(500);
            System.out.println("몬스터를 발견했습니다...");
            Thread.sleep(300);
            System.out.println("결투중...");
            Thread.sleep(300);
            System.out.println("몬스터에게 승리했습니다...");
            Thread.sleep(300);

            //몬스터를 잡고 발생하는 경험치
            addExp = random.nextInt(100) + 10;
            System.out.println("경험치 +" + addExp + "를(을) 얻었습니다.");

            user = service.addExpAndLevelUp(user, addExp);

            userLevel = user.getLevel();
            baseExp = user.getBaseExp();
            addExp = 0;

            System.out.println("----------------------------------------------------");
            System.out.println("현재 레벨 :" + userLevel + " 경험치 :" + baseExp + "/10");
            System.out.println("----------------------------------------------------");

        }

        //최고레벨일경우 전직
        if (user.isMaxLevel()) {
            System.out.println(">2차 직업을 가질 수 있습니다.");
            user = service.newPosition(user);
        }

        //무기 장착
        user = service.addWeapon(user);

        return user;
    }

    public User SecondAdventure(User user) {
        boolean playingGames = true;
        Scanner scanner = new Scanner(System.in);
        String select;

        System.out.println(">사냥을 시작합니다.");
        while (playingGames) {
            System.out.println("----------------------------------------------------");
            System.out.println(">몬스터를 발견했습니다. 공격하겠습니까? [y/n]");
            select = scanner.next();
            if (select.equals("y")) {
                user = service.HuntingMonsters(user);
            } else if (select.equals("n")) {
                System.out.println(">돌아갑니다...");
            }

        }
        return user;
    }
}


