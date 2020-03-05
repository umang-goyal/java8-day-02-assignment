package com.knoldus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.time.Year.isLeap;

public class Utilities {
    List<Student> studentsWIthNoSecAddress(List<Student> studentList){
        return studentList.stream()
                .filter(student -> !student.address.secondaryAddress.isPresent())
                //.map(student -> student.name)
                .collect(Collectors.toList());
    }

    List<Student> nameStartsWith(String yourName, List<Student> studentList){
        return studentsWIthNoSecAddress(studentList).stream()
                .filter(student -> student.name.toLowerCase().startsWith(yourName.toLowerCase().substring(0,1)))
                .collect(Collectors.toList());
    }

    //DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();

    List<String> days(String birthDate){
        return IntStream.range(LocalDate.parse(birthDate).getYear(), LocalDate.now().getYear())
                .mapToObj(year -> LocalDate.parse( year +"-06-12").getDayOfWeek().toString())
                .collect(Collectors.toList());
    }

    String getTimeFromTimeZone(String zoneId){
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of(zoneId));
        return zonedDateTime.toString();
    }

    long numberOfSecondsManLived(String birthDate, String deathDate){

        return Duration.between(LocalDate.parse(birthDate).atStartOfDay(),
                LocalDate.parse(deathDate).plusDays(1).atStartOfDay()).getSeconds();
    }

    List<Integer> leapYearsAfter1950(){
        return IntStream.range(1950, LocalDate.now().getYear())
                .filter(Year::isLeap)
                .boxed()
                .collect(Collectors.toList());
    }

    Map<String, Long> wordCountForTextFile(String path) throws IOException {
       // Path path = Paths.get("src/main/resources/book.txt");
//        Stream<String> file = Stream.of("hEllo  6hello hello world world world ");
//        Stream<String> file = Files.lines(Paths.get(path))
        List<String> words = Files.lines(Paths.get(path))
                .flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
                .filter(word -> word.length() > 0)
                .collect(Collectors.toList());



        //wordCount.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k, v)));

        System.out.println(words);
        Map<String, Long> wordCount =
                words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //  var map = new HashMap<String, Integer>();
        // HashMap<String, Integer> wordCount= words.forEach(word ->
        // map.compute(word, (w, prev) -> prev != null ? prev + 1 : 1));

//        System.out.println(collect);

        return wordCount;
    }
}
