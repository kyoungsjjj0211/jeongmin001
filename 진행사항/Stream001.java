package com.company.java015_labmda_stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Stream001 {
	public static void main(String[] args) {
		//데이터 종류에 상관없이 (Stream) 같은 방식으로 처리
		
		Integer[]     arr  = {1,2,3,4,5};  //배열
		List<Integer> list = Arrays.asList(arr);
		
		//    stream (흐름)
		Arrays.stream(arr).forEach(null);
		
		//void java.util.function.Consumer.accept( T t )

	}
}
