package mantests;

import exceptions.NameException;
import exceptions.StringNullException;
import org.testng.Assert;
import org.testng.Assert.ThrowingRunnable;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import personalization.Man;

import java.time.LocalDate;

public class ManConstructorTests {

    @Test(dataProvider = "person-data")
    public void testManConstructorPositive(String firstName, String lastName, LocalDate dateOfBirth ) {
        Man innerMan = new Man(firstName, lastName, dateOfBirth);
        Assert.assertEquals(innerMan.getFirstName(), firstName, "Constructor Man doesn't set first Name");
        Assert.assertEquals(innerMan.getLastName(), lastName, "Constructor Man doesn't set last Name");
        Assert.assertEquals(innerMan.getDateOfBirth(), dateOfBirth);
    }


    @Test(dataProvider = "person-data-name-exception")
    public void testManConstructorException(String firstName, String lastName, LocalDate dateOfBirth ) {
        Assert.assertThrows( NameException.class,() -> new Man(firstName, lastName, dateOfBirth));
    }

    @Test(dataProvider = "person-data-null-mane-exception")
    public void testManConstructorNullNameException(String firstName, String lastName, LocalDate dateOfBirth){
        Assert.assertThrows(StringNullException.class,() -> new Man(firstName, lastName, dateOfBirth));
    }

    @DataProvider(name = "person-data")
    public Object[][] setUpPersonData(){
        Object[][] objects = {
                {"Nikola", "Bange", LocalDate.of(1952, 01, 28)},
                {"Juriiy", "Woo", LocalDate.of(1972, 11, 01)},
                {"Sergiiy", "Rango", LocalDate.of(2020, 05, 18)}};
        return objects;
    }

    @DataProvider(name = "person-data-name-exception")
    public Object[][] setUpPersonDataNameException(){
        Object[][] objects = {
                {"N", "Bange", LocalDate.of(1952, 01, 28)},
                {"Juriiy", "W", LocalDate.of(1972, 11, 01)},
                {"", "Rango", LocalDate.of(2020, 05, 18)}};
        return objects;
    }
    @DataProvider(name = "person-data-null-mane-exception")
    public Object[][] setUpPersonDataNullNameException(){
        Object[][] objects = {
                {"Nikola", null, LocalDate.of(1952, 01, 28)},
                {null, "Rango", LocalDate.of(2020, 05, 18)}};
        return objects;
    }
}
