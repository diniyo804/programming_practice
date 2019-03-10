package userPosition;

import common.Rule;

public class Archer extends Position {

    public Archer() {
        super.setPositionType(Rule.ARCHER);
        super.setSpecialSkill(specialSkill());
    }

    public String specialSkill() {
        return "***** 화살 50샷 발사 *****";
    }
}
