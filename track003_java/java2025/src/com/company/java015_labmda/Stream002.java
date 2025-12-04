package com.company.java015_labmda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream002 {
    public static void main(String[] args) {

        Integer[] arr = {1, 3, 4, 5, 4, 3, 2, 1, 3, 5, 2, 3, 4, 5};  // 배열
        List<Integer> list = Arrays.asList(arr);

        // 1단계 - stream
        Stream<Integer> sarr = Arrays.stream(arr);
        Stream<Integer> slist = list.stream();

        // 2단계 - 중간연산 + 3단계 - 최종연산
        System.out.print("홀수, 중복 제거, 정렬 후 skip(1) 결과: ");
        Arrays.stream(arr)
                .filter(t -> t % 2 != 0)     // 홀수 필터링
                .distinct()                 // 중복 제거
                .sorted()                   // 정렬
                .skip(1)                    // 첫 번째 요소 건너뛰기
                .forEach(t -> System.out.print(t + " ")); // 출력
        System.out.println(); // 줄바꿈

        // #3. collect
        System.out.println("배열을 리스트로 변환: " + Arrays.stream(arr).collect(Collectors.toList()));
        System.out.println("리스트 스트림을 다시 리스트로 수집: " + list.stream().collect(Collectors.toList()));
    }
}
