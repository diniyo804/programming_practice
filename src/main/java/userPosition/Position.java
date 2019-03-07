package userPosition;

public abstract class Position {

    //2차직업
    String positionType;

    //특수스킬사용
    public abstract void specialSkill();



    //2차직업
    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public String getPositionType() {
        return positionType;
    }
}
