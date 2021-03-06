package weapons;

import common.Rule;

public class Weapon {

    //무기타입
    private String weaponType;

    //무기공격력
    private int str;
    //내구도 : 0이하이면 사용 X 100번 이상 공격하면 -1씩 줄어든다.
    private int durability = Rule.BASIC_DURABLIITY;
    //공격범위(사거리)
    private int rangeOfAttack;

    @Override
    public String toString() {
        return "Weapon{}";
    }

    //
    //내구성체크 (0보다 크면 사용가능)
    public boolean durabilityCheck() {
        if (this.durability > 0) return true;
        return false;
    }

    //공격시 (내구도 -1)
    public void subDurability() {
        this.durability -= 1;
        System.out.println(">무기내구도:" + this.getDurability());
    }

    // getter and setter
    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public String getWeaponType() {
        return weaponType;
    }
}


