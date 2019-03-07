package user;

import common.Rule;
import userPosition.Position;
import userType.Type;

public class User {
    //종족
    private Type userType;
    //종족정보
    String typeToString;

    //2차직업
    private Position position;


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

    //생성자 : 유저 이름을 입력받아 생성
    public User(String name) {
        this.name = name;
    }


    //getter and setter

    public String getName() {
        return name;
    }

    //종족 객체 생성 및 종족정보 set , 이렇게 쓰면 아래 메서드는 필요 X
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

    //2차직업 설정
    public void setPosition(Position position) {
        this.position = position;
    }

    //기본스킬(heal)
    public void skillToHeal() {
        this.hp += 10;
        this.mp -= 20;
    }

    //기본스킬(anger)
    public void skillToAnger() {
        this.def -= (this.def * 0.2);
        this.str += (this.str * 0.3);
        this.mp -= 10;
    }

}
