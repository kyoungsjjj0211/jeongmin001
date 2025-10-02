package com.company.bank5_interface;

import java.util.List;

public class Delete  implements BankController{

	@Override
	public int exec(List<UserInfo> users, int find) {
		//변수
		//처리
		UserInfo u = users.remove(find);
		//출력
		System.out.println("정보를 삭제했습니다 > " + u);
		return 0;
	}

	
}
