package com.company;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Faker faker = new Faker();

        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student(faker.name().fullName()) )
                .toArray(Student[]::new);
        var h = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School(faker.university().name()) )
                .toArray(School[]::new);

        List<Student> studentList = new LinkedList<Student>();
        studentList.addAll( Arrays.asList(students) );

        Collections.sort(studentList,
                Comparator.comparing(Student::getName));

        Map<Student, List<School>> stdPrefMap = new HashMap<>();

        stdPrefMap.put(students[0], Arrays.asList(h[0], h[1], h[2]));
        stdPrefMap.put(students[1], Arrays.asList(h[0], h[1], h[2]));
        stdPrefMap.put(students[2], Arrays.asList(h[0], h[1]));
        stdPrefMap.put(students[3], Arrays.asList(h[0], h[2]));

        Set<School> sortedHighschool = new TreeSet<School>();
        sortedHighschool.addAll(Arrays.asList(h));

        Map<School, List<Student>> hPrefMap= new TreeMap<School, List<Student>>();
        hPrefMap.put(h[0], Arrays.asList(students[3], students[0], students[1], students[2]));
        hPrefMap.put(h[1], Arrays.asList(students[0], students[2], students[1]));
        hPrefMap.put(h[2], Arrays.asList(students[0], students[1], students[3]));

        for (Map.Entry<School, List<Student>> e : hPrefMap.entrySet()){
            System.out.print(e.getKey().getName() + " -> ");
            e.getValue().forEach(s-> System.out.print(s.getName() + " "));
            System.out.println();
        }

        for (Map.Entry<Student, List<School>> e : stdPrefMap.entrySet()){
            System.out.print(e.getKey().getName() + " -> ");
            e.getValue().forEach(s-> System.out.print(s.getName() + " "));
            System.out.println();
        }
        //printing students who find acceptable the target schools
        List<School> target = Arrays.asList(h[0], h[2]);
        studentList.stream()
                .filter(std -> stdPrefMap.get(std).containsAll(target))
                .forEach(System.out::println);
        //printing school that has a given student as their top preferences
        Student targetStudent = students[0];
        Arrays.stream(h).filter(std -> hPrefMap.get(std).get(0) == targetStudent).forEach(System.out::println);
        
    }
}
