package com.linkedin.javacodechallenges;

public class Person {
  private String firstName, lastName;
  private int age;

  public Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    setAge(age);
  }

  public String introudction() {
    return firstName + " " + lastName + " age: " + age;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    if (age > 0 && age <= 100) {
      this.age = age;
    }
  }

}