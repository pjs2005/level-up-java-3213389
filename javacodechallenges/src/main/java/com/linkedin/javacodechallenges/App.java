package com.linkedin.javacodechallenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {

    private static int MINI = 2;

    public static List<String> findStudentsWithIncompleteVolunteerEvents2(
            List<String> students,
            Map<String, List<String>> attendeesMapping) {
        List<String> result = new ArrayList<>();

        for (String currentSudent : students) {
            int count = 0;
            for (Map.Entry<String, List<String>> event : attendeesMapping.entrySet()) {
                String eventName = event.getKey();
                List<String> studentList = event.getValue();
                if (studentList.contains(currentSudent)) {
                    count++;
                }

            }
            if (count < MINI) {
                result.add(currentSudent);
            }
        }

        return result;
    }

    public static List<String> findStudentsWithIncompleteVolunteerEvents(
            List<String> students,
            Map<String, List<String>> attendeesMapping) {
        List<String> result = new ArrayList<>();

        Map<String, Integer> studentsEventCount = students
                .stream()
                .collect(Collectors.toMap(s -> s, n -> 0));

        attendeesMapping.values().forEach(list -> list.stream().filter(student -> studentsEventCount
                .containsKey(student))
                .forEach(filteredStudent -> studentsEventCount.put(filteredStudent,
                        studentsEventCount.get(filteredStudent) + 1)));

        result = studentsEventCount
                .entrySet()
                .stream()
                .filter(map -> map.getValue() < MINI)
                .map(StudentEventsMap -> StudentEventsMap.getKey())
                .collect(Collectors.toList());

        return result;
    }

    public static void main(String[] args) {
        List<String> students = List.of("Sally", "Polly", "Molly",
                "Tony", "Harry");

        Map<String, List<String>> attendeesMapping = Map.of("Farmer's Market", List.of("Sally", "Polly"),
                "Car Wash Fundraiser", List.of("Molly", "Tony", "Polly"),
                "Cooking Workshop", List.of("Sally", "Molly", "Polly"),
                "Midnight Breakfast", List.of("Polly", "Molly"));

        System.out.println(findStudentsWithIncompleteVolunteerEvents(
                students, attendeesMapping));
    }

}
