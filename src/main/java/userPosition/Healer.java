package userPosition;

import common.Rule;

public class Healer extends Position
{
    //인스턴스 생성시 해당 클래스 정보를 base class에 set해줌
    public Healer() {
        super.setPositionType(Rule.HEALER);
    }

    //
    public void specialSkill() {
        System.out.println(">[특수스킬시전] : 죽은 동료를 부활시킵니다.");
    }
}
