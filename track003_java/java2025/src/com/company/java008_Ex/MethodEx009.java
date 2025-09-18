package com.company.java008_Ex;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx009 {
	
	////////////////////////////////////////////////////
	public static void main(String[] args) {
		String [][] users = {{ "aaa"  , "111"   , "한국"     } ,     // 00 01 02
                			{ "bbb" , "222"   , "호주"       } ,       // 10 11 12
                			{ "ccc"  , "333"   , "중국"      }};      // 20 21 22
		who_are_you(users);    
		who_pass_change(users); 
		  
	}
	////////////////////////////////////////////////////
	public static void who_are_you(String[][] user) {
		Scanner scanner=new Scanner (System.in);
		
		String tempid="";
		String temppw="";
		String result="정보를 확인해주세요";
		
		
		System.out.println("아이디를 입력해주세요 > "); tempid= scanner.next();
		System.out.println("비밀번호를 입력해주세요 > "); temppw= scanner.next();
		
		for(int i=0; i<user.length; i++) {
			if(tempid.equals(user[i][0])) {result = tempid + "의 나라는" + user[i][2] + "입니다."; break;}
		}
		System.out.println(result);
	}
		/*
		String  tempid = scanner.nextLine();
		
		boolean found = false;
		//처리
		for(int i=0; i<user.length; i++) {
			if(user[i][0].equals(tempid)) {
				System.out.println(tempid + "는 " + user[i][2] + "사람입니다.");
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("해당 아이디를 찾을 수 없습니다.");
		}
	}
	*/
	
	public static void who_pass_change(String[][] users) {
		//변수
		/*String tempid="", temppass="";
		 * Scanner scanner = new Scanner(System.in);
		//입력
		System.out.pring("아이디를 입력해주세요>"); tempid=scanner.next();
		System.out.pring("비밀번호를 입력해주세요>"); temppw=scanner.next();
		
		int findIndex=-1; //유저의 번호를 찾아서 findIndex 담기, 못찾았다라고 하면 -1
		* 처리 if(아이디와 비번이 맞으면){변경하실 비밀번호를 입력해주세요123 - 비번바꾸기}
		* 
		 *처리-입력한아이디와 user[0][0]맞고 입력한 비미번호와 user[0][1]이 같다면 찾은번호는 0층
		 *처리-입력한아이디와 user[1][0]맞고 입력한 비미번호와 user[1][1]이 같다면 찾은번호는 1층
		 for(int i=0; i<users.length; i++){
		 if(tempid.equals(users[i][0]) && temppw.equls(users[i][1])){
		 	System.out.print("변경하실 비밀번호를 입력하세요");
		 	user[i][1] = scanner.next();
		 	findIndex=i;
		 	break;
		 	}
		 }
		 
		 if(findIndex !=-1){
		 System.out.println("정보확인 : " + Arrays.toString(users[findIndex]));
		 }else{System.out.println("정보를 확인해주세요");}
		
		 */
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("아이디를 입력해 주세요 > ");
		String tempid = scanner.nextLine();
		System.out.println("비밀번호를 입력해 주세요 > ");
		String temppw = scanner.nextLine();
		
		boolean matched = false;
		
		for (int i = 0; i < users.length; i++) {
            if (users[i][0].equals(tempid) && users[i][1].equals(temppw)) {
                matched = true;
                System.out.print("변경하실 비밀번호를 입력해주세요> ");
                String newpw = scanner.nextLine();
                users[i][1] = newpw;
                System.out.println("정보확인 : " + Arrays.deepToString(users));
                break;
            }
        }
		if (!matched) {
			System.out.println("유저를 확인해주세요!");
		}
	}
}
/*
연습문제9)  method
패키지명 : com.company.java008_ex
클래스명 :  MethodEx009

public class MethodEx009{ 
   // 변수
   String [][] users = {{ "aaa"  , "111"   , "한국"     } ,     // 00 01 02
                      { "bbb" , "222"   , "호주"       } ,       // 10 11 12
                      { "ccc"  , "333"   , "중국"      }};      // 20 21 22
   // 입력
   who_are_you(users);    
   //  public static void who_are_you(String [][] users){  아이디를입력받아서 나라조회 }
   who_pass_change(users); 
   //  public static void who_pass_change(String [][] users){ 아이디,비밀번호가 맞으면 비밀번호 바꾸기}
}

출력내용) who_are_you(users);    
//  public static void who_are_you(String [][] users){  아이디를입력받아서 나라조회 }
아이디를 입력해주세요>aaa
aaa는 한국사람입니다.


출력내용)
who_pass_change(users); 
//  public static void who_pass_change(String [][] users){ 아이디,비밀번호가 맞으면 비밀번호 바꾸기}

아이디를 입력해 주세요 > bbb
비밀번호를 입력해 주세요 > 123
유저를 확인해주세요!

아이디를 입력해 주세요 > bbb
비밀번호를 입력해 주세요 > 222
변경하실 비밀번호를 입력해주세요123
정보확인 : [bbb, 123, 호주]
*/