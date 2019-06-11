package com.this_is_java.chapter16_stream.practice;

class Member {

    public enum Job{
       DEVELOPER("개발자"),
       DESIGNER("디자이너");

        private final String ko;

        Job(String ko) {
            this.ko = ko;
        }

        public String getKo() {
            return ko;
        }
    }

    private final String name;
    private final Job job;

    public Member(String name,
                  Job job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public Job getJob() {
        return job;
    }

}
