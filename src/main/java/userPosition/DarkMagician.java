package userPosition;

import common.Rule;

public class DarkMagician extends Position {
    public DarkMagician() {
        super.setPositionType(Rule.DARK_MAGICIAN);
    }

    public void specialSkill() {
        System.out.println(">[특수스킬시전] : 전방 30m내의 적에게 poison을 시전합니다.");
    }
}
