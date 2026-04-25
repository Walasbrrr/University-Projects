import java.util.Comparator;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int age;
    private String cell;
    private String ssn;

    Person() {}

    Person(String first, String last, int aa, String cell, String ssn) {
        firstName = first;
        lastName = last;
        age = aa;
        this.cell = cell;
        this.ssn = ssn;
    }

    @Override
    public int compareTo(Person other) {
        int byLast = this.lastName.compareToIgnoreCase(other.lastName);
        if (byLast != 0) return byLast;
        return this.firstName.compareToIgnoreCase(other.firstName);
    }

    public static final Comparator<Person> SSNComparator =
            Comparator.comparing(Person::getSsn);

    public static final Comparator<Person> AgeComparator =
            Comparator.comparingInt(Person::getAge);

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getCell() { return cell; }
    public String getSsn() { return ssn; }

    public String toString() {
        return firstName + " " + lastName + ": \n    age " + age
                + "\n    SSN: " + ssn + "\n    cell: " + cell;
    }
}
