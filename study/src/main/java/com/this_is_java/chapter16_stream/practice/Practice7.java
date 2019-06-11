package com.this_is_java.chapter16_stream.practice;

import com.this_is_java.chapter16_stream.practice.Member.Job;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Member 중에서 직업이 "개발자"인 사람만 list로 추출
 */
public class Practice7 {
    public static void main(String[] args) {
        Job searchTypeByJob = Job.DEVELOPER;
        List<Member> members = Arrays.asList(
                new Member("홍길동", searchTypeByJob),
                new Member("김나리", Job.DESIGNER),
                new Member("신용권", searchTypeByJob)
        );

        List<Member> developers = members.stream()
                .filter(member -> member.getJob() == searchTypeByJob)
                .collect(Collectors.toList());

        developers.stream().forEach(member -> System.out.println(member.getName()));
    }


}
