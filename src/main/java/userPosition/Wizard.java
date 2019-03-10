package userPosition;

import common.Rule;

public class Wizard extends Position {

    public Wizard() {
        super.setPositionType(Rule.WIZARD);
        super.setSpecialSkill(specialSkill());
    }

    public String specialSkill() {
        return "***** 메테오 소환 *****";
    }
}
