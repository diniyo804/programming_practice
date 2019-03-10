package userPosition;

import weapons.Weapon;

public abstract class Position {
    //2차직업타입
    private String positionType;

    //특수스킬정보
    private String specialSkill;


    // 1. 기본공격한다 (내구도 체크 후 공격)
    public void basicAttack(Weapon weapon) {
        if (weapon.durabilityCheck()) {
            System.out.println(">공격합니다...");
            weapon.subDurability();
            System.out.println(">현재내구도 : " +weapon.getDurability());
        }
        else System.out.println(">무기의 수리가 필요합니다...");
    }

    // 2. 특수스킬을 사용한다
    public void specialAttack(Weapon weapon) {
        if (weapon.durabilityCheck()) {
            System.out.println("----------------------------------------------------");
            System.out.println(">특수스킬을 시전합니다");
            System.out.println(specialSkill);
        } else System.out.println(">무기의 수리가 필요합니다...");
    }



    //getter and setter

    //2차직업정보
    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public String getPositionType() {
        return this.positionType;
    }

    //특수스킬정보
    public String getSpecialSkill() {
        return specialSkill;
    }

    public void setSpecialSkill(String specialSkill) {
        this.specialSkill = specialSkill;
    }
}
