package userPosition;

import common.Rule;

public class Archer extends Position {
//    @Override
//    public String positionToString() {
//        return Rule.ARCHER;
//    }


    public Archer() {
        super.setPositionType(Rule.ARCHER);
    }

    public void specialSkill() {
        System.out.println(">[특수스킬시전] : 화살을 50샷 발사합니다.");
    }
}
