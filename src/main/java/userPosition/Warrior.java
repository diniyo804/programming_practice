package userPosition;

import common.Rule;

public class Warrior extends Position {
    public Warrior() {
        super.setPositionType(Rule.WARRIOR);
    }

    public void specialSkill() {
        System.out.println(">[특수스킬시전] : 10초동안 무적상태입니다.");
    }
}
