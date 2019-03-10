package userPosition;

import common.Rule;

public class Wizard extends Position {

    public Wizard() {
        super.setPositionType(Rule.WIZARD);
    }

    public void specialSkill() {
        System.out.println(">[특수스킬시전] : 메테오를 소환합니다.");
    }
}
