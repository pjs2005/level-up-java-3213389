package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        String firstName = "Mark";
        String lastName = "Smith";
        int age = 10;
        Person person = new Person(firstName, lastName, age);

        assertEquals(age, person.getAge());
        assertEquals(firstName + " " + lastName + " age: " + age, person.introudction());
    }

    @Test
    public void shouldAnswerWithAge() {
        String firstName = "Mark";
        String lastName = "Smith";
        int age = 101;
        Person person = new Person(firstName, lastName, age);

        assertEquals(0, person.getAge());
        assertEquals(firstName + " " + lastName + " age: " + 0, person.introudction());
    }
}
