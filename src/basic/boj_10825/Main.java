package basic.boj_10825;

import java.util.*;
import java.io.*;

public class Main {

    static class Student {
        String name;
        int kor, eng, math;

        Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Student> stuList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            stuList.add(new Student(name, kor, eng, math));
        }

        stuList.sort(Comparator
                .comparing((Student s) -> s.kor, Comparator.reverseOrder()) // comparingInt((Student s) -> -s.kor) 음수로 만들어 내림차순 효과
                .thenComparingInt(s -> s.eng)
                .thenComparing(s -> s.math, Comparator.reverseOrder())
                .thenComparing(s -> s.name));

        StringBuilder sb = new StringBuilder();
        for(Student s : stuList) {
            sb.append(s.name).append("\n");
        }

        System.out.print(sb);
    }
}
