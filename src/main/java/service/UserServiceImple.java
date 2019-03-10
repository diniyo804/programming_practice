package service;

import common.Rule;
import user.User;
import userPosition.*;
import userType.ElfType;
import userType.HumanType;
import userType.OrcType;
import userType.Type;

import java.util.Scanner;

public class UserServiceImple implements UserService {

    private static UserService service = new UserServiceImple();
    private Scanner scanner = new Scanner(System.in);

    public static UserService getUserServiceInstance() {
        if (service == null) {
            service = new UserServiceImple();
        }
        return service;
    }

    //신규유저생성(이름을 입력받아 user 객체 생성)
    public User newUser() {
        System.out.println(">input your name");
        String name = scanner.next();
        User user = new User(name);
        System.out.println(">created the \"" + user.getName() + "\"");
        return user;
    }


    //종족 선택
    public User selectUserType(User user) {
        int pick;
        Type type = null;

        System.out.println(">select your Character Type \n >1.Human   2.Orc   3.Elf ");
        pick = scanner.nextInt();

        if (pick == Rule.PICK_HUMAN) {
            type = new HumanType();
        } else if (pick == Rule.PICK_ORC) {
            type = new OrcType();
        } else if (pick == Rule.PICK_ELF) {
            type = new ElfType();
        }
        user.setUserType(type);
        //종족정보확인 test
        System.out.println(">your character type : " + user.getTypeToString());
        return user;
    }


    //경험치 계산 및 레벨업
    public User addExpAndLevelUp(User user, int addExp) {
        //누적 경험치 = 기본경험치 + 추가경험치
        int allExp = user.getBaseExp() + addExp;
        //레벨업 수치
        int levelUpCnt = allExp / 10;
        //레벨업 후 나머지 경험치
        int baseExp = allExp % 10;

        //set
        user.setLevel(levelUpCnt);
        user.setBaseExp(baseExp);

        if (user.isMaxLevel()) user.setMaxLevel();

        System.out.println(user.getName() + "의 레벨 :" + user.getLevel());

        return user;
    }

    //2차직업
    public User newPosition(User user) {
        String type = user.getTypeToString();
        Position position = null;
        int pick;

        System.out.println(">select your new position");

        if (type == Rule.HUMAN) {
            System.out.println(">1.전사   2.마법사");
            pick = scanner.nextInt();
            if (pick == 1) position = new Warrior();
            else if (pick == 2) position = new Wizard();

        } else if (type == Rule.ORC) {
            System.out.println(">1.흑마법사   2.돌격병");
            pick = scanner.nextInt();
            if (pick == 1) position = new DarkMagician();
            else if (pick == 2) position = new AssaultSoldier();

        } else if (type == Rule.ELF) {
            System.out.println(">1.힐러   2.궁수");
            pick = scanner.nextInt();
            if (pick == 1) position = new Healer();
            else if (pick == 2) position = new Archer();
        }
        System.out.println(">" + position.getPositionType() + "(으)로 전직하였습니다.");
        user.setPosition(position);
        return user;
    }


}
