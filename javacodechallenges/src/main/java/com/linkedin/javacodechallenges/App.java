package com.linkedin.javacodechallenges;

public class App 
{
    public static void main( String[] args )
    {
        Person Poojan = new Person("Mark", "Smith", 22);
        Person Navik = new Person("Lvie", "Smith", 22);

        System.out.println(Poojan.introudction());
        System.out.println(Navik.introudction());
    }
}
