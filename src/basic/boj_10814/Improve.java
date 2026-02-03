package basic.boj_10814;

import java.io.*;
import java.util.*;

public class Improve {

    static class Person {
        int age;
        String name;

        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Person> persons = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            persons.add(new Person(age, name));
        }

        // Collections.sort()나 List.sort()는 내부적으로 Timsort 알고리즘을 사용. 이 알고리즘은 Stable Sort(안정 정렬)
        // 안정정렬: 정렬 기준이 같은 요소들이 있을 때 원래 순서가 유지되는 정렬.
        // seq를 제거해 메모리 절약 가능
        // 메서드 참조 형식
        persons.sort(Comparator.comparingInt(Person::getAge));

        StringBuilder sb = new StringBuilder();
        for(Person p : persons) {
            sb.append(p.age).append(" ").append(p.name).append("\n");
        }
        System.out.print(sb);
    }
}

