package service;

import common.Rule;
import user.User;
import userPosition.*;
import userType.ElfType;
import userType.HumanType;
import userType.OrcType;
import userType.Type;
import weapons.*;

import java.util.Scanner;

public class UserServiceImple implements UserService {

    private static UserService service = new UserServiceImple();
    private Scanner scanner = new Scanner(System.in);
    int pick;

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
        System.out.println("----------------------------------------------------");
        System.out.println("*** created the \"" + user.getName() + "\" ***");
        System.out.println("----------------------------------------------------");
        return user;
    }

    //종족 선택
    public User selectUserType(User user) {
        Type type = null;

        System.out.println(">select your Character Type \n>1.인간   2.오크   3.엘프 ");
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
        System.out.println("----------------------------------------------------");
        System.out.println(">your character type : < " + user.getTypeToString() +" >");
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

        return user;
    }

    //2차직업설정
    public User newPosition(User user) {
        String type = user.getTypeToString();
        Position position = null;

        System.out.println(">select your new position");

        if (type == Rule.HUMAN) {
            System.out.println(">[1]전사   [2]마법사");
            pick = scanner.nextInt();
            if (pick == 1) {
                position = new Warrior();
            } else if (pick == 2) position = new Wizard();

        } else if (type == Rule.ORC) {
            System.out.println(">[1]흑마법사   [2]돌격병");
            pick = scanner.nextInt();
            if (pick == 1) {
                position = new DarkMagician();
            } else if (pick == 2) position = new AssaultSoldier();

        } else if (type == Rule.ELF) {
            System.out.println(">[1]힐러   [2]궁수");
            pick = scanner.nextInt();
            if (pick == 1) {
                position = new Healer();
            } else if (pick == 2) position = new Archer();
        }
        System.out.println("----------------------------------------------------");
        System.out.println("*** " + position.getPositionType() + "(으)로 전직하였습니다 ***");
        System.out.println("----------------------------------------------------");
        user.setPosition(position);
        return user;
    }

    //무기장착
    public User addWeapon(User user) {
        String position = user.getPositionToString();
        int pick;
        Weapon weapon = null;

        System.out.println(">무기를 선택하세요.");
        if (position.equals(Rule.WARRIOR) || position.equals(Rule.ASSAULT_SOLDIER)) {
            System.out.println(">[1]검   [2]도끼");
            pick = scanner.nextInt();
            if (pick == 1) weapon = new Sword();
            else if (pick == 2) weapon = new Ax();

        } else if (position.equals(Rule.DARK_MAGICIAN) || position.equals(Rule.HEALER) || position.equals(Rule.WIZARD)) {
            System.out.println(">[1]지팡이");
            pick = scanner.nextInt();
            if (pick == 1) weapon = new Stick();

        } else if (position.equals(Rule.ELF)) {
            System.out.println(">[1]활");
            pick = scanner.nextInt();
            if (pick == 1) weapon = new Bow();
        }
        user.setWeapon(weapon);
        System.out.println("----------------------------------------------------");
        System.out.println("*** " + user.getWeaponToString() + "을(를) 장착했습니다 ***");
        System.out.println("----------------------------------------------------");

        return user;
    }

    //몬스터사냥
    public User HuntingMonsters(User user) {
        Weapon weapon = user.getWeapon();
        Position position = user.getPosition();
        int pick = 0;

        //무기 내구도 체크
        if (weapon.durabilityCheck()) {
            System.out.println(">사용할 스킬을 선택하세요");
            System.out.println(">[1]기본스킬:힐   [2]기본스킬:분노   [3]특수스킬");

            pick = scanner.nextInt();

            if (pick == 1) user.skillToHeal();
            else if (pick == 2) user.skillToAnger();
            else if (pick == 3) position.specialAttack(weapon);
            weapon.subDurability();
        }
        return user;
    }


}
