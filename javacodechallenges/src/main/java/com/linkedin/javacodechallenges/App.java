package com.linkedin.javacodechallenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class App {

    private static int MINI = 2;

    public static List<String> findStudentsWithIncompleteVolunteerEvents(
            List<String> students,
            Map<String, List<String>> attendeesMapping) {
                List<String> result = new ArrayList<>();



                for (String currentSudent : students) {
                    int count = 0;
                    for(Map.Entry<String,List<String>> event: attendeesMapping.entrySet() ){
                        String eventName = event.getKey();
                        List<String> studentList = event.getValue();
                        if(studentList.contains(currentSudent)){
                            count++;
                        }

                    }
                    if(count < MINI){
                        result.add(currentSudent);
                    }
                }

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
