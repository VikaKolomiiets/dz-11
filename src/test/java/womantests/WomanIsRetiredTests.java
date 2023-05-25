package womantests;

import datesourse.DateForDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import personalization.Woman;

import java.time.LocalDate;

public class WomanIsRetiredTests {
    private static final int RETIRED_AGE = 60;


    @Test(dataProviderClass = DateForDataProvider.class, dataProvider = "person-date-is-retired")
    public void testWomanisRetiredPositive(String firstName, String lastName, LocalDate dateOfBirth){
        Woman woman = new Woman(firstName, lastName, dateOfBirth);
        Integer fullAge = woman.getFullAge();
        if( fullAge>= RETIRED_AGE ){
            Assert.assertTrue(woman.isRetired(), "Man is not retired, check " + RETIRED_AGE);
        } else{
            Assert.assertFalse(woman.isRetired(), "Man is retired, check " + RETIRED_AGE);
        }
        System.out.println(dateOfBirth + " : " + fullAge + " : " + woman.isRetired());
    }
}
