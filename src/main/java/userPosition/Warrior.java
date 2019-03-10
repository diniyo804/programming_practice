package userPosition;

import common.Rule;

public class Warrior extends Position {

    public Warrior() {
        this.setPositionType(Rule.WARRIOR);
        super.setSpecialSkill(specialSkill());
    }

    public String specialSkill() {
        return "***** 10초동안 무적상태 *****";
    }
}
