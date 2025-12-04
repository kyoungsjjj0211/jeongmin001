package com.company.java013;

abstract class Astronaut {
    protected String name; //인스턴스변수 - heap area - this 각각
    protected int stamina; //protected (상속받은 자식 사용가능) 

    public void setName(String name) { this.name = name; }
    public void setStamina(int stamina) { this.stamina = stamina; }
    public int getStamina() { return stamina; }

    abstract void explore();
    abstract void report();
    abstract void rest();
}

class Engineer extends Astronaut {
    @Override void explore() { System.out.println(name + " 엔지니어 탐사: 기계 장치 점검 완료!"); }
    @Override void report() { System.out.println(name + " 보고서: 에너지 시스템 안정적"); }
    @Override void rest() { System.out.println(name + " 휴식: 공구 정리하며 재충전 중..."); }
}

class Biologist extends Astronaut {
    @Override void explore() { System.out.println(name + " 생물학자 탐사: 외계 식물 샘플 채취!"); }
    @Override void report() { System.out.println(name + " 보고서: 생명체 흔적 발견"); }
    @Override void rest() { System.out.println(name + " 휴식: 생체 리듬 조절 중..."); }
}

class Pilot extends Astronaut {
    @Override void explore() {
        System.out.println(name + " 파일럿 탐사: 항로 재설정 및 우주선 조종!");
    }
    @Override void report() {
        System.out.println(name + " 보고서: 궤도 진입 성공");
    }
    @Override void rest() {
        System.out.println(name + " 휴식: 조종석에서 짧은 명상...");
    }
}

public class AbstractEx002 {

	public static void main(String[] args) {
		// Astronaut astro = new Astronaut();  // Q1. 왜 객체 생성이 불가능한가? {} 구현부가 없음 new생성 불가능
		// Astronaut { name, stamina / abstract explore(), report(), rest() } 설계목적으로 설계 클래스로  구현부가 없음{}

        System.out.println("\n--- 우주 탐사 대원 시뮬레이션 ---");
        //   부모     =자식
        //crew[0] = Engineer{explore(), report(),rest()} - {name, stamina/--,--,--}
        //crew[1] = Biologist{explore(), report(),rest()} - {name, stamina/--,--,--}
        //crew[2] = Pilot{explore(), report(),rest()} - {name, stamina/--,--,--}
        Astronaut[] crew = { new Engineer(), new Biologist(), new Pilot() };
        String[] names = { "Nova", "Flora", "Jet" };
        int[] stamina = { 75, 60, 85 };
        
        for (int i = 0; i < crew.length; i++) {
            crew[i].setName(names[i]);
            crew[i].setStamina(stamina[i]);
            crew[i].explore();
            crew[i].report();
            //crew[i].rest();

            //if(crew[i].stamina < 70 { crew[i].rest();}
            // else {System.out.println(crew[i].name + "는 충분한 체력을 유지 중입니다.");}
            if (crew[i].getStamina() < 70) {
           crew[i].rest();
        } else {
            System.out.println(crew[i].name + "는 충분한 체력을 유지 중입니다.");
        }
            //  Q2. 체력이 낮은 대원만 휴식  70미만이 휴식을 취하게 만들기            S
             System.out.println("현재 체력: " + crew[i].getStamina() + "\n");
        
	}
	}
}
	


/*
연습문제2)
패키지명 : com.company.java013_ex 
클래스명 : AbstractEx002.java
다음과 같이 출력되게 main 코드를 작성하시오.
주어진 조건
1) 상속도 구조 
            Object
              ↑
        Astronaut { abstract explore(), report(), rest() }
   ↑            ↑               ↑ 
Engineer     Biologist       Pilot
{ @explore(), @explore(),    @explore(),
  @report(),  @report(),     @report(),
  @rest() }   @rest() }      @rest() }
  
- Astronaut는 추상 클래스이며, 모든 대원이 공통적으로 수행해야 할 기능을 설계함
- 각 대원 클래스는 Astronaut를 상속받아 기능을 구체적으로 구현함
- rest() 메서드는 각 대원의 고유한 휴식 방식 출력  

2) 코드
abstract class Astronaut {
    protected String name;
    protected int stamina;

    public void setName(String name) { this.name = name; }
    public void setStamina(int stamina) { this.stamina = stamina; }
    public int getStamina() { return stamina; }

    abstract void explore();
    abstract void report();
    abstract void rest();
}

class Engineer extends Astronaut {
    @Override void explore() { System.out.println(name + " 엔지니어 탐사: 기계 장치 점검 완료!"); }
    @Override void report() { System.out.println(name + " 보고서: 에너지 시스템 안정적"); }
    @Override void rest() { System.out.println(name + " 휴식: 공구 정리하며 재충전 중..."); }
}

class Biologist extends Astronaut {
    @Override void explore() { System.out.println(name + " 생물학자 탐사: 외계 식물 샘플 채취!"); }
    @Override void report() { System.out.println(name + " 보고서: 생명체 흔적 발견"); }
    @Override void rest() { System.out.println(name + " 휴식: 생체 리듬 조절 중..."); }
}

class Pilot extends Astronaut {
    @Override void explore() {
        System.out.println(name + " 파일럿 탐사: 항로 재설정 및 우주선 조종!");
    }
    @Override void report() {
        System.out.println(name + " 보고서: 궤도 진입 성공");
    }
    @Override void rest() {
        System.out.println(name + " 휴식: 조종석에서 짧은 명상...");
    }
}

3) main
public class AbstractEx002 {
    public static void main(String[] args) {
        // Astronaut astro = new Astronaut();  // Q1. 왜 객체 생성이 불가능한가?

        System.out.println("\n--- 우주 탐사 대원 시뮬레이션 ---");
        Astronaut[] crew = { new Engineer(), new Biologist(), new Pilot() };
        String[] names = { "Nova", "Flora", "Jet" };
        int[] stamina = { 75, 60, 85 };

        // Q2. 체력이 낮은 대원만 휴식  70미만이 휴식을 취하게 만들기 
    }
}

출력화면
--- 우주 탐사 대원 시뮬레이션 ---
Nova 엔지니어 탐사: 기계 장치 점검 완료!
Nova 보고서: 에너지 시스템 안정적
Nova는 충분한 체력을 유지 중입니다.

Flora 생물학자 탐사: 외계 식물 샘플 채취!
Flora 보고서: 생명체 흔적 발견
Flora 휴식: 생체 리듬 조절 중...

Jet 파일럿 탐사: 항로 재설정 및 우주선 조종!
Jet 보고서: 궤도 진입 성공
Jet는 충분한 체력을 유지 중입니다.

*/