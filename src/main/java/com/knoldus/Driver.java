package com.knoldus;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

public class Driver {
    public static void main(String[] args) throws IOException {
        Utilities obj = new Utilities();
        List<Student> studentList = Arrays.asList(new Student(56, "umang",34,new Address("delhi","noida")),
                new Student(56, "upanshu",34,new Address("delhi")),
                new Student(566, "suraj",34,new Address("delhi","noida")),
                new Student(56, "sparsh",34,new Address("delhi","noida")),
                new Student(5666, "utsav",34,new Address("delhi")),
                new Student(56646, "muskan",34,new Address("delhi","noida")),
                new Student(556, "yamini",34,new Address("delhi")),
                new Student(536, "mansi",34,new Address("delhi","noida"))
                );
        System.out.println(obj.studentsWIthNoSecAddress(studentList));
        System.out.println(obj.nameStartsWith("umang",studentList));
        System.out.println(obj.days("1997-12-10"));
        System.out.println(obj.numberOfSecondsManLived("1997-12-31", "2020-03-09"));
        System.out.println(obj.getTimeFromTimeZone("GMT-5"));
        System.out.println(obj.leapYearsAfter1950());
        System.out.println(obj.wordCountForTextFile("/home/knoldus/knoldus-assignments/textFile.txt"));
    }
}
