import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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

        // Group by location
        Map<String, List<Integer>> groupedByLocation = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getLocation,                        // Grouping key
                        Collectors.mapping(Person::getId, Collectors.toList()) // Map to IDs
                ));

        // Print the result
        groupedByLocation.forEach((location, ids) -> {
            System.out.println("Location: " + location + ", Person IDs: " + ids);
        });

        //Count Persons in each location
        Map<String, Long> countByLocation = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getLocation, Collectors.counting()
                ));
        countByLocation.forEach((location, count) -> {
            System.out.println("Location: " + location + ", Person Count: " + count);
        });

        //Get all locations
        persons.stream().map(Person::getLocation).distinct().forEach(System.out::println);

        //Get all employees having age > 30
        persons.stream().filter(p->p.getAge()>30).forEach(s->System.out.println(s.getId()));

        //Find max age
        persons.stream().max((p1, p2) -> p1.getAge() - p2.getAge()).ifPresent(s->System.out.println(s.getAge()));

        //Find avg age
        double avgAge = persons.stream().collect(Collectors.averagingInt(Person::getAge));
        System.out.println("Average age: " + avgAge);

        //Find sum of ages
        int sumOfAges = persons.stream().collect(Collectors.summingInt(Person::getAge));
        System.out.println("Sum of ages: " + sumOfAges);

        //Find avg age by location
        persons.stream().collect(Collectors.groupingBy(Person::getLocation, Collectors.averagingInt(Person::getAge)))
                .forEach((location, avgAge1) -> System.out.println(location + " : " + avgAge1));

        //Find max age by location
        persons.stream().collect(Collectors.groupingBy(Person::getLocation, Collectors.maxBy((p1, p2) -> p1.getAge() - p2.getAge())))
                .forEach((location, person) -> System.out.println(location + " : " + person.get().getAge()));

        //Find oldest person
        persons.stream().collect(Collectors.maxBy((p1, p2) -> p1.getAge() - p2.getAge())).ifPresent(s->System.out.println(s.getAge()));

        // Find persons with age between 30 and 40
        persons.stream().filter(p -> p.getAge() > 30 && p.getAge() < 40).forEach(s->System.out.println(s.getId()));

        // Find maximum age of persons with location New York
        persons.stream().filter(p -> p.getLocation().equals("New York")).map(Person::getAge).max(Integer::compare).ifPresent(System.out::println);

        //Find maximum age by location
        persons.stream().collect(Collectors.groupingBy(Person::getLocation, Collectors.maxBy((p1, p2) -> p1.getAge() - p2.getAge())))
                .forEach((location, person) -> System.out.println(location + " : " + person.get().getAge()));

        //Find location where person > 1
        persons.stream().collect(Collectors.groupingBy(Person::getLocation, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).forEach(e -> System.out.println(e.getKey()));

        //Find all persons with location New York
        persons.stream().filter(p -> p.getLocation().equals("New York")).forEach(s->System.out.println(s.getId()));

        //Total persons
        long totalPersons = persons.stream().count();
        System.out.println("Total persons: " + totalPersons);

        //Sort based on Age and Location
        persons.stream().sorted((p1, p2) -> {
            if (p1.getAge() == p2.getAge()) {
                return p1.getLocation().compareTo(p2.getLocation());
            } else {
                return p1.getAge() - p2.getAge();
            }
        }).forEach(s->System.out.println(s.getId()));

        Comparator<Person> comparator1 = Comparator.comparing(Person::getAge);
        Comparator<Person> comparator2 = Comparator.comparing(Person::getLocation);
        persons.stream().sorted(comparator1.thenComparing(comparator2)).forEach(System.out::println);

        // Find avg and total age of persons
        persons.stream().collect(Collectors.summarizingInt(Person::getAge)).getAverage();
        persons.stream().collect(Collectors.summarizingInt(Person::getAge)).getSum();

        // Find highest age
        persons.stream().collect(Collectors.summarizingInt(Person::getAge)).getMax();

        // Find second highest age
        persons.stream().map(Person::getAge).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);

        // Find nth highest age
        int n = 3;
        persons.stream().map(Person::getAge).distinct().sorted(Comparator.reverseOrder()).skip(n-1).findFirst().ifPresent(System.out::println);

        // Find person based on descending order of age
        persons.stream().sorted(Comparator.comparing(Person::getAge).reversed()).forEach(System.out::println);

        // Find person based on ascending order of age
        persons.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);

        // Find person based on descending order of age and location
        persons.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getLocation).reversed()).forEach(System.out::println);

        // Find person based on ascending order of age in each location
        persons.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.groupingBy(Person::getLocation)).forEach((location, person) -> {
            System.out.println(location);
            person.forEach(System.out::println);
        });

        // Find person based on descending order of age in each location
        persons.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.groupingBy(Person::getLocation)).forEach((location, person) -> {
            System.out.println(location);
            person.forEach(System.out::println);
        });

        // Find second highest age in each location
        persons.stream().collect(Collectors.groupingBy(Person::getLocation, Collectors.mapping(Person::getAge, Collectors.toList())))
                .forEach((location, ages) -> {
                    ages.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(age -> {
                        System.out.println(location + " : " + age);
                    });
                });

    }
}