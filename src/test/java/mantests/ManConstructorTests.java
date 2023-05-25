package mantests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import personalization.Man;

import java.time.LocalDate;

public class ManConstructorTests {

    @Test(dataProvider = "man-data")
    public void testManConstructorPositive(String firstName, String lastName, LocalDate dateOfBirth ) throws Exception {
        Man innerMan = new Man(firstName, lastName, dateOfBirth);
        Assert.assertEquals(innerMan.getFirstName(), firstName, "Constructor Man doesn't set first Name");
        Assert.assertEquals(innerMan.getLastName(), lastName, "Constructor Man doesn't set last Name");
        Assert.assertEquals(innerMan.getDateOfBirth(), dateOfBirth);
    }


    @Test(dataProvider = "man-data-name-exseption")
    public void testManConstructorException(String firstName, String lastName, LocalDate dateOfBirth ) throws Exception {
        Man innerMan = new Man(firstName, lastName, dateOfBirth);
        //Assert.assertThrows();

    }

    @DataProvider(name = "man-data")
    public Object[][] setUpPersonData(){
        Object[][] objects = {
                {"Nikola", "Bange", LocalDate.of(1952, 01, 28)},
                {"Juriiy", "Woo", LocalDate.of(1972, 11, 01)},
                {"Sergiiy", "Rango", LocalDate.of(2020, 05, 18)}};
        return objects;
    }

    @DataProvider(name = "man-data-name-exseption")
    public Object[][] setUpPersonDataNameException(){
        Object[][] objects = {
                {"N", "Bange", LocalDate.of(1952, 01, 28)},
                {"Juriiy", "W", LocalDate.of(1972, 11, 01)}};
        return objects;
    }
}
