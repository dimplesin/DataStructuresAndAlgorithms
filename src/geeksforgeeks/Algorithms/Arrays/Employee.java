package geeksforgeeks.Algorithms.Arrays;

/**
 * Created by v-dsindhi on 12/8/15.
 */
public class Employee {

    int id;
    String firstname;
    String lastname;
    int salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!firstname.equals(employee.firstname)) return false;
        return lastname.equals(employee.lastname);

    }

    @Override
    public int hashCode() {
        int result = firstname.hashCode();
        result = 31 * result + lastname.hashCode();
        return result;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
}
