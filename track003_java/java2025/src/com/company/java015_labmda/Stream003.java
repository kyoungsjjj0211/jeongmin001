package com.company.java015_labmda;

import java.util.Arrays;
import java.util.List;

public class Stream003 {
    public static void main(String[] args) {
        // Ex1 평균 나이 계산
        System.out.println("\n\nEx1");
        Integer[] ages = {17, 21, 26, 45, 18};
        double avg = Arrays.stream(ages) // Stream<Integer>
                .mapToInt(Integer::intValue) // IntStream으로 변환
                .average() // OptionalDouble
                .orElse(0.0); // 값 없으면 0.0 반환
        System.out.println("평균나이 : " + avg);

        // Ex2 짝수만 출력
        System.out.println("\n\nEx2");
        System.out.println("짝수 나이:");
        Arrays.stream(ages)
                .filter(age -> age % 2 == 0) 
                .forEach(System.out::println); 

        // Ex3 성이 김씨인 친구들 출력
        System.out.println("\n\nEx3");
        List<String> names = Arrays.asList("김수지", "이나영", "김나영", "유재석", "강호동");
        System.out.println(names.get(0).startsWith("김" ));
        
        names.stream()
                .filter(name -> name.startsWith("김")) 
                .forEach(System.out::println); // 출력
        
        // Ex4 name 정렬후 출력
        System.out.println("\n\nEx4");
        names.stream()
        	.sorted()
        	.forEach(System.out::print);
        
        // Ex5 제일 나이가 많은(max) 사람
        System.out.println("\n\nEx5");
        // 1단계-스트림        객체를 숫자로        최대값     못찾으면 -1
        int max = Arrays.stream(ages).mapToInt(age->age).max().orElse(-1);
        System.out.println(max);
    }
}
