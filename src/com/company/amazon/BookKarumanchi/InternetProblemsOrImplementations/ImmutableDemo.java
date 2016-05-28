package com.company.amazon.BookKarumanchi.InternetProblemsOrImplementations;

/**
 * Created by v-dsindhi on 3/27/15.
 */
import java.util.Date;

/* Making class final, prevents it's methods from overriden in subclasses */
final class IAmImmutable {

    private Integer id;
    private String name;
    private Date currentDate;

    /*
     * private constructor ensured no unwanted object creation
     */
    private IAmImmutable(Integer id, String name, Date currentDate) {
        this.id = id;
        this.name = name;
        this.currentDate = currentDate;
    }

    /* this hold the logic of object creation, only point to get an object */
    static IAmImmutable getInstance(Integer fld1, String fld2, Date fld3) {
        return new IAmImmutable(fld1, fld2, fld3);
    }

    /* Integer is a immutable class, this can be served directly */
    public Integer getId() {
        return id;
    }

    /* String is a immutable class, this can be served directly */
    public String getName() {
        return name;
    }

    /*
     * Date class is mutable so we don't provide an direct object, instead we
     * provide a copy of it
     */
    public Date getCurrentDate() {
        return new Date(currentDate.getTime());
    }

}

public class ImmutableDemo {

    /**
     * @Author Nagesh Chauhan
     */
    public static void main(String[] args) {
  /*
   * getting an instance of immutable class
   */
        IAmImmutable iAmImmutable = IAmImmutable.getInstance(2, "Andrew",
                new Date());
        System.out.println("Id: " + iAmImmutable.getId() + " Name: "
                + iAmImmutable.getName() + " Date:"
                + iAmImmutable.getCurrentDate());

  /*
   * Try to modify object's states
   */
        // iAmImmutable.getId() = 5; not permitted
        // iAmImmutable.getName() = "Stuart" not permitted
        iAmImmutable.getCurrentDate().setDate(23);
  /*
   * Printing values again to test
   */
        System.out.println("Id: " + iAmImmutable.getId() + " Name: "
                + iAmImmutable.getName() + " Date:"
                + iAmImmutable.getCurrentDate());
    }

}



