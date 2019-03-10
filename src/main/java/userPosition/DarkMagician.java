package userPosition;

import common.Rule;

public class DarkMagician extends Position {

    public DarkMagician() {
        super.setPositionType(Rule.DARK_MAGICIAN);
        super.setSpecialSkill(specialSkill());
    }

    public String specialSkill() {
        return "***** 전방 30m내 적에게 poison 시전 *****";
    }
}
