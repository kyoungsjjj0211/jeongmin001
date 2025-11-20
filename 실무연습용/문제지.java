
// 🔹 문제 1 — 로그인 검증 (if문)

// 회사 내부 시스템에서 입력한 ID와 Password가 일치하는지 검사하는 프로그램을 작성하시오.

// 저장된 ID: admin

// 저장된 PW: 1234

// 요구사항

// 사용자에게 ID와 PW를 입력받는다.

// 둘 다 맞으면 “로그인 성공”

// ID만 틀리면 “아이디 오류”

// PW만 틀리면 “비밀번호 오류”

// 둘 다 틀리면 “아이디와 비밀번호 오류”

public class logintest {
public static void main(String[] args) {

Scannser sc = new Scanner(System.in);
//변수
String ID = "admin";
String PW = "1234";


//입력
System.out.print("ID 입력 : ");
String inputId = sc.nextLine();
//사용자가 입력한 값을 inputId에 넣는다. 스캐너로 nextLine 문자열을 읽어들인다. (숫자,문자,공백등)
System.out.print("PW 입력 : ");
String inputPw = sc.nextLine();

//처리 + //출력
if (inputId.equals(ID) && inputPw.equals(PW)) {
    System.out.println("로그인 성공");
} else if (!inputId.equals(ID) && inputId.equals(PW)){
    System.out.println("아이디 오류");
}else if(!inputPw.equals(PW) && inputPw.equals(PW)){
    System.out.println("비밀번호 오류");
}else{
    System.out.println("아이디와 비밀번호 오류")
}
}
}
//else if (!inputId.equals(ID) && inputId.equals(PW)){ System.out.println("아이디 오류");  //! 부정연산자 true->false, false->true inputId는 ID와 같지 않다
//inputId.equals(ID)      inputId와 ID의 내용이 같은가?        equals :문자열(또는 객체)의 값이 같은지 비교하는 기능
//&& 두가지의 전부 정답일때 true 하나라도 틀리면 false


// 🔹 문제 2 — 근무시간 초과 수당 계산 (if문)

// 직원의 하루 근무 시간이 주어졌을 때 급여를 계산한다.

// 기본 근무 시간: 8시간

// 초과 근무 수당: 기본 시급 * 1.5

// 기본 시급: 10,000원

// 입력 예: 근무시간(정수)
// 출력: 총 급여

public class gunmu{
    public static void main(String[] args){
//변수        
    //기본 시급
        int pay = 10000;
    //기본 근무 시간
        int baseTime = 8;
    //초과 근무 수당
        double overwork = *1.5;
       
        int total ;
    Scanner sc = new Scanner(System.in);
//입력
    System.out.println("근무시간을 입력하세요 : ");
    int worktime = sc.nextInt();
//nextLine()은 문자열을 반환합니다. 근무시간은 정수로 받아야 하므로 nextInt()를 써야 합니다.
//처리
if(worktime <= baseTime){ //기본근무만 한경우, 일한시간이 기본 근무 시간보다 작거나 같을때
    total = worktime * pay;
} else { //초과근무가 있는경우
    int overtime = worktime - baseTime;
    total = (baseTime * pay) + (int)(overtime * pay * 1.5);
}
//출력
System.out.println("총 급여 : " + total + "원");
    }
}

// 🔹 문제 3 — 상품 재고 경고 메시지 (if문)

// 상품 재고량(stock)에 따라 다음 메시지를 출력하시오.

// 50개 이상: “재고 충분”

// 20~49개: “재고 보충 필요”

// 1~19개: “재고 위험”

// 0개: “품절!”

public class error{
    public static void main(String[] args){
//변수
//입력
//처리
//출력
    }
}