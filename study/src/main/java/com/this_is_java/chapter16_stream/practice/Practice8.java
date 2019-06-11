package com.this_is_java.chapter16_stream.practice;

import com.this_is_java.chapter16_stream.practice.Member.Job;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Member 직업별로 그룹핑하여 Map<String,List<String>> 객체로 생성
 * key : member의 직업
 * value : member의 이름으로 구성된 List<String>
 */
public class Practice8 {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
                new Member("홍길동", Job.DEVELOPER),
                new Member("김나리", Job.DESIGNER),
                new Member("신용권", Job.DEVELOPER)
        );

        Map<Job, List<String>> mapByJob = members.stream()
                .collect(Collectors.groupingBy(Member::getJob, Collectors.mapping(Member::getName, Collectors.toList())));
        for (Map.Entry<Job, List<String>> map : mapByJob.entrySet()) {
            System.out.println(map.getKey().getKo() + ": " + map.getValue());
        }
    }
}
