package userPosition;

import common.Rule;

public class AssaultSoldier extends Position {

    public AssaultSoldier() {
        super.setPositionType(Rule.ASSAULT_SOLDIER);
        super.setSpecialSkill(specialSkill());
    }

    public String specialSkill() {
        return "***** 30초동안 공격력 5배 증가 *****";
    }
}


