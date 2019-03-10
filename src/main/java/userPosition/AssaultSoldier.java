package userPosition;

import common.Rule;

public class AssaultSoldier extends Position {

    public AssaultSoldier() {
        super.setPositionType(Rule.ASSAULT_SOLDIER);
    }

    public void specialSkill() {
        System.out.println(">[특수스킬시전] : 전방 30m내의 적에게 poison을 시전합니다.");
    }
}

