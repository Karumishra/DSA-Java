public class Movie implements Comparable<Movie> {
    String name;
    Long budget;
    Integer year;

    @Override
    public int compareTo(Movie o) {
        return this.year - o.year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Movie(String name, Long budget, Integer year) {
        this.name = name;
        this.budget = budget;
        this.year = year;
    }

}
