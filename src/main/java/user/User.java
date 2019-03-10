package user;

import common.Rule;
import userPosition.Position;
import userType.Type;
import weapons.Weapon;

public class User {
    //종족
    private Type userType;
    //종족정보
    String typeToString;

    //2차직업
    private Position position;
    //2차직업정보
    private String positionToString;

    //무기
    private Weapon weapon;
    //무기정보
    private String weaponToString;


    //닉네임
    private String name;
    //레벨
    private int level = Rule.BASE_LEVEL;
    //경험치
    private int baseExp = 0;
    //hp
    private int hp = 100;
    //mp
    private int mp = 100;
    //공격력
    private int str = 30;
    //회피
    private int avoidance = 30;
    //방어력
    private int def = 30;

    //constructor : 유저 이름을 입력받아 생성
    public User(String name) {
        this.name = name;
    }


    //getter and setter


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public String getName() {
        return name;
    }

    //종족 생성, 종족정보 set
    public void setUserType(Type userType) {
        this.userType = userType;
        this.typeToString = userType.typeToString();
    }

    //종족정보를 메서드로 받아옴 toString
    public String getTypeToString() {
        return this.userType.typeToString();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level += level;
    }

    public int getBaseExp() {
        return baseExp;
    }

    public void setBaseExp(int baseExp) {
        this.baseExp = baseExp;
    }

    //최고레벨인지 체크
    public boolean isMaxLevel() {
        if (this.level >= Rule.MAX_LEVEL) return true;
        return false;
    }

    //레벨을 99로 설정
    public void setMaxLevel() {
        this.level = Rule.MAX_LEVEL;
    }

    //2차직업정보 set
    public void setPosition(Position position) {
        this.position = position;
        this.positionToString = position.getPositionType();
    }

    public String getPositionToString() {
        return positionToString;
    }

    public Position getPosition() {
        return position;
    }

    //무기 정보 set
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        this.weaponToString = weapon.toString();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public String getWeaponToString() {
        return weaponToString;
    }


    //기본스킬(heal)
    public void skillToHeal() {
        this.hp += 10;
        this.mp -= 20;
        System.out.println("----------------------------------------------------");
        System.out.println("*** 체력이 +10 회복되었습니다 ***");
        System.out.println(">HP: " + this.getHp() + "/100");
        System.out.println(">MP:" + this.getMp() + " /100");
        System.out.println("----------------------------------------------------");
    }

    //기본스킬(anger)
    public void skillToAnger() {
        this.def -= (this.def * 0.2);
        this.str += (this.str * 0.3);
        this.mp -= 10;
        System.out.println("----------------------------------------------------");
        System.out.println("*** 방어력이 -20% 감소, 공격력이 +30% 증가했습니다. ***");
        System.out.println(">방어력: " + this.getDef() + "/30");
        System.out.println(">공격력: " + this.getStr() + "/30");
        System.out.println(">MP   : " + this.getMp() + "/100");
    }

}
