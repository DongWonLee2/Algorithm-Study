package basic.boj_10814;

import java.io.*;
import java.util.*;

public class Main {

    static class Person {
        int seq, age;
        String name;

        Person(int seq, int age, String name) {
            this.seq = seq;
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Person> persons = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            persons.add(new Person(i, age, name));
        }

        persons.sort(Comparator
                .comparingInt((Person p) -> p.age)
                .thenComparingInt(p -> p.seq));

        StringBuilder sb = new StringBuilder();
        for(Person p : persons) {
            sb.append(p.age).append(" ").append(p.name).append("\n");
        }
        System.out.print(sb);
    }
}
