package userPosition;

import common.Rule;

public class Healer extends Position {
    public Healer() {
        super.setPositionType(Rule.HEALER);
    }

    public void specialSkill() {
        System.out.println(">[특수스킬시전] : 죽은 동료를 부활시킵니다.");
    }
}
