package mantests;

import datesourse.DateForDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import personalization.Man;

import java.time.LocalDate;

public class ManIsRetiredTests {
    private static final int RETIRED_AGE = 65;


    @Test(dataProviderClass = DateForDataProvider.class, dataProvider = "man-date-is-retired")
    public void testisRetiredPositive(String firstName, String lastName, LocalDate dateOfBirth){
        Man man = new Man(firstName, lastName, dateOfBirth);
        Integer fullAge = man.getFullAge();
        if( fullAge>= RETIRED_AGE ){
            Assert.assertTrue(man.isRetired(), "Man is not retired, check " + RETIRED_AGE);
        } else{
            Assert.assertFalse(man.isRetired(), "Man is retired, check " + RETIRED_AGE);
        }
        System.out.println(dateOfBirth + " : " + fullAge + " : " + man.isRetired());

    }
}
