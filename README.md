
### 프로그래밍 실습 과제

**설명을 보고 해당 모델을 solid 원칙을 준수하여 개발 한 후, github repository url을 결과물로 제출.**  
**가능하면 테스트 케이스(junit) 작성하여 제출 하시오.**  
**주제 : 게임 프로그래밍**  
**기한 :  3월1일 6시반**  

#### 게임 시작 : application.PlayGame.java

-------------------------------------------------

#### 종족
>게임속 캐릭터는 여러 종족이 있다.  
1.사람 2.오크 3.엘프  
각각의 캐릭터에는 hp와 mp가 존재함.  
hp는 생명력이고 mp는 스킬 사용시 필요 함.  
hp는 0이 되면 죽는다.  
mp는 스킬 필요 마나보다 적거나 0이되면  스킬을 사용할 수 없다.  
각각의 스킬에는 mp가 소모되는데 소모되는 mp는 임의로 지정.     


#### 스킬
> 각각의 종족에는 특수한 스킬이 존재 함.        
기본적으로 회복 스킬(hp+)과 분노 스킬(방어력-20% 공격력+30%) 은 모든 캐릭터에 존재.    
사람은 방어력을 올려주는 스킬을 가지고 있다.  
오크는 공격력을 올려주는 스킬을 가지고 있다.  
엘프는 회피력을 올려주는 스킬을 가지고 있다.  
 
#### 전직
>각각 종족별 캐릭터 별로 99레벨이 되면 전직을 할 수 있다.  
사람은 전사와 마법사로 전직이 가능하다.  
오크는 돌격병과 흑마술사로 전직이 가능하다.  
엘프는 궁수와 힐러로 전직이 가능하다.  
 
 #### 특수스킬
>전직시 특수 스킬을 가지게 되는데 공통적으로 궁극 필살기를 하나씩 가지게 된다.  
각각 종족 별로    
전사는 10초동안 무적이 된다.    
마법사는 메테오를 소환한다.    
돌격병은 30초동안 공격력이 5배 증가 한다.    
흑마술사는 전방 30m 내 포이즌을 시전한다.    
엘프는 적1명에게 순간적으로 활 50여방을 발사한다.    
힐러는 죽은 동료를 부활 시킨다.    
 
 
#### 무기
>각각의 무기에는 공격력과 내구성이 존재.  
무기의 공격력과 내구성은 임의로 지정  
내구성이 0이하 이면 사용할 수 없고, 100번이상 공격시 1씩 줄어 든다.    
모든 무기는 사거리가 있다.     
검과 도끼는 3의 사거리를 가진다.  
지팡이는 2의 사거리를 가진다.  
활은 10의 사거리를 가진다.    


#### 직업별 무기
>각각의 직업별로 전용 무기가 존재 한다.  
각각의 무기별로 특성이 있지만 모든 무기는 기본 공격이 가능하다.  
전사와 돌격병은 검과 도끼를 사용할 수 있다.  
흑마술사와 마법사 힐러는 지팡이를 사용할 수 있다.  
엘프는 활을 사용할 수 있다.  
 
 
#### 아래 해당 프로세스를 구현하세요.
>캐릭터를 생성  
99레벨이 되어 전직  
무기를 장착  
장착한 무기로 공격 (사거리내에 몬스터가 있다고 가정)  
스킬을 사용  
몬스터에게 공격을 당했을 때   
 **수치가 없는 부분은 임의로 수치를 할당**

-------------------------------------------------

#### 피드백 
>**프로세스와 도메인 분리하기**  
도메인 클래스 구현 후, 클래스들을 가지고 프로세스를 만들 수 있도록 모델링  
도메인 : 직업, 스킬, 무기, 캐릭터  
캐릭터 생성시 반드시 필요한 값만 들고있을 수 있도록 모델링(hp,mp,level..)  
필수로 입력받아야 하는 값은 생성자를 이용해 객체 생성

> **사용 권장 패턴**  
프로세스 : 팩토리 메서드 패턴  
도메인 : 전략 패턴 (확장편의)  
무기/스킬 : 전략패턴  

>**기능 설계 예시**  
공격한다 (필요인자 : 공격주체, 공격대상)  
공격대상 여러명일경우 -> list 
