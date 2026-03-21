import java.util.*;
import java.util.stream.Collectors;

class Person {

    int id;
    int age;
    String location;

    public Person(String location, int age, int id) {
        this.location = location;
        this.age = age;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

public class CollectorDemo {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        List<Person> persons = Arrays.asList(
                new Person("New York", 25, 1),
                new Person("Veticon City", 30, 2),
                new Person("New York", 35, 3),
                new Person("London", 40, 4),
                new Person("London", 45, 5)
        );

        //Get all locations
        persons.stream().map(Person::getLocation).distinct().forEach(System.out::println);

        //Get all employees having age > 30
        persons.stream().filter(p->p.getAge()>30).forEach(s->System.out.println(s.getId()));


        //Find max age
        persons.stream().max((p1, p2) -> p1.getAge() - p2.getAge()).ifPresent(s->System.out.println(s.getAge()));
        // Or
        persons.stream().map(Person::getAge).max(Integer::compare).ifPresent(System.out::println);
        // Or
        Person per = persons.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .orElse(null);


        //Find avg age
        double avgAge = persons.stream().collect(Collectors.averagingInt(Person::getAge));
        System.out.println("Average age: " + avgAge);

        //Find sum of ages
        int sumOfAges = persons.stream().collect(Collectors.summingInt(Person::getAge));
        System.out.println("Sum of ages: " + sumOfAges);

        //Find oldest person
        persons.stream().collect(Collectors.maxBy((p1, p2) -> p1.getAge() - p2.getAge())).ifPresent(s->System.out.println(s.getAge()));

        // Find persons with age between 30 and 40
        persons.stream().filter(p -> p.getAge() > 30 && p.getAge() < 40).forEach(s->System.out.println(s.getId()));


        // Find maximum age of persons with location New York
        persons.stream().filter(p -> p.getLocation().equals("New York")).map(Person::getAge).max(Integer::compare).ifPresent(System.out::println);

        //Find location where more than one person are living
        persons.stream().collect(Collectors.groupingBy(Person::getLocation, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).forEach(e -> System.out.println(e.getKey()));

        // Or
        persons.stream()
                .collect(Collectors.groupingBy(p -> p.location, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();


        //Find all persons with location New York
        persons.stream().filter(p -> p.getLocation().equals("New York")).forEach(s->System.out.println(s.getId()));

        // Find avg and total age of persons
        persons.stream().collect(Collectors.summarizingInt(Person::getAge)).getAverage();
        persons.stream().collect(Collectors.summarizingInt(Person::getAge)).getSum();

        // Find highest age
        persons.stream().collect(Collectors.summarizingInt(Person::getAge)).getMax();

        //Total persons
        long totalPersons = persons.stream().count();
        System.out.println("Total persons: " + totalPersons);

        //Find avg age by location
        persons.stream().collect(Collectors.groupingBy(Person::getLocation, Collectors.averagingInt(Person::getAge)))
                .forEach((location, avgAge1) -> System.out.println(location + " : " + avgAge1));

        //Find max age by location
        persons.stream().collect(Collectors.groupingBy(Person::getLocation, Collectors.maxBy(Comparator.comparingInt(Person::getAge))))
                .forEach((location, person) -> System.out.println(location + " : " + person.get().getAge()));


        //Sort based on Age and Location
        Comparator<Person> comparator1 = Comparator.comparing(Person::getAge);
        Comparator<Person> comparator2 = Comparator.comparing(Person::getLocation);
        persons.stream().sorted(comparator1.thenComparing(comparator2)).forEach(System.out::println);

        // Find person based on descending order of age
        persons.stream().sorted(Comparator.comparing(Person::getAge).reversed()).forEach(System.out::println);

        // Or
        persons.stream().map(Person::getAge).sorted(Collections.reverseOrder()).forEach(System.out::println);

        // Find person based on ascending order of age
        persons.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);

        // Find person based on descending order of age and location
        persons.stream()
                .sorted(Comparator.comparing(Person::getAge, Comparator.reverseOrder())
                        .thenComparing(Person::getLocation, Comparator.reverseOrder()))
                .forEach(System.out::println);

        // Find person based on descending order of age and ascending location
        persons.stream()
                .sorted(Comparator.comparing(Person::getAge, Comparator.reverseOrder())
                        .thenComparing(Person::getLocation))
                .forEach(System.out::println);

        //Count Persons in each location
        Map<String, Long> countByLocation = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getLocation, Collectors.counting()
                ));
        countByLocation.forEach((location, count) -> {
            System.out.println("Location: " + location + ", Person Count: " + count);
        });
        // Or
        persons.stream().collect(Collectors.groupingBy(Person::getLocation, Collectors.counting())).forEach((l,c)->System.out.println(l+" "+c));

        // Find person based on ascending order of age in each location i.e. Group by location and sort each group by age ascending
        Map<String, List<Person>> personsByLocation = persons.stream()
                .collect(Collectors.groupingBy(
                        p -> p.location,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingInt(Person::getAge))
                                        .collect(Collectors.toList())
                        )
                ));
        personsByLocation.forEach((location, person) -> {
            System.out.println("Location: " + location);
            person.forEach(System.out::println);
        });


        // Find person based on descending order of age in each location i.e. Group by location and sort each group by age descending
        Map<String, List<Person>> personsByLocations = persons.stream()
                .collect(Collectors.groupingBy(
                        p -> p.location,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingInt(Person::getAge).reversed())
                                        .collect(Collectors.toList())
                        )
                ));

        // Print results
        personsByLocations.forEach((location, person) -> {
            System.out.println("Location: " + location);
            person.forEach(System.out::println);
        });


        // Find second highest age
        persons.stream().map(Person::getAge).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);

        // Find nth highest age
        int n = 3;
        persons.stream().map(Person::getAge).distinct().sorted(Comparator.reverseOrder()).skip(n-1).findFirst().ifPresent(System.out::println);

        // Find second highest age in each location
        Map<String, Optional<Person>> secondHighestByLocation = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getLocation,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingInt(Person::getAge).reversed())
                                        .skip(1) // skip the highest
                                        .findFirst()
                        )
                ));

        secondHighestByLocation.forEach((location, personOpt) -> {
            System.out.println("Location: " + location);
            personOpt.ifPresent(System.out::println);
        });


    }
}