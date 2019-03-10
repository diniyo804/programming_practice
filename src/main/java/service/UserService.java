package service;

import user.User;

public interface UserService {

    //유저생성
    User newUser();

    //종족선택
    User selectUserType(User user);

    //경험치 계산과 레벨업
    User addExpAndLevelUp(User user, int addExp);

    //2차직업설정
    User newPosition(User user);

    //무기장착
    User addWeapon(User user);

    //2차 전직 후 사냥
    User HuntingMonsters(User user);

}
