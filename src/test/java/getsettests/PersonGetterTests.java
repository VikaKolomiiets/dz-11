package getsettests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import personalization.Man;
import personalization.Person;
import personalization.Status;
import personalization.Woman;

import java.time.LocalDate;

public class PersonGetterTests {

    @Parameters("name")
    @Test
    public void testGetFirstNamePositive(String firstName){
        Person man = new Man(firstName, "secondName", LocalDate.of(2000, 1, 2));
        Assert.assertEquals(man.getFirstName(), firstName, "Getter first name doesn't work.");
    }

    @Test
    @Parameters("name")
    public void testGetLastNamePositive(String lastName){
        Person woman = new Woman("Anna", lastName, LocalDate.of(2000, 1, 2));
        Assert.assertEquals(woman.getLastName(), lastName, "Getter last name doesn't work.");
    }

    @Test
    @Parameters("name")
    public void testGetBirthLastNamePositive(String lastName){
        Person woman = new Woman("Anna", lastName, LocalDate.of(2000, 1, 2));
        Assert.assertEquals(woman.getBirthLastName(), lastName, "Getter BIRTH_LAST_NAME doesn't work.");
    }

    @Test
    @Parameters({"yyyy", "mm", "dd"})
    public void testGetDateOfBirthPositive(int year, int month, int day){
        Person man = new Man("Gans", "Andersen", LocalDate.of(year, month, day));
        Assert.assertEquals(man.getDateOfBirth().getYear(), year, "Getter of DateOfBirth doesn't give correct year ");
        Assert.assertEquals(man.getDateOfBirth().getMonth(), month, "Getter of DateOfBirth doesn't give correct month");
        Assert.assertEquals(man.getDateOfBirth().getDayOfMonth(), day, "Getter of DateOfBirth doesn't give correct day");
    }

    @Test
    @Parameters({"yyyy", "mm", "dd"})
    public void testPersonGetDateOfDeath(int year, int month, int day){
        Person man = new Man("Gans", "Andersen", LocalDate.of(1960, 12, 30));
        man.setDateOfDeath(LocalDate.of(year, month, day));
        Assert.assertEquals(man.getDateOfDeath().getYear(), year, "Getter of DateOfDeath doesn't give correct year ");
        Assert.assertEquals(man.getDateOfDeath().getMonth(), month, "Getter of DateOfDeath doesn't give correct month");
        Assert.assertEquals(man.getDateOfDeath().getDayOfMonth(), day, "Getter of DateOfDeath doesn't give correct day");
    }

    @Test
    @Parameters({"name1", "name2"})
    public void testPersonGetPartner(String firstName, String lastName){
        Person man = new Man("Gans", "Andersen", LocalDate.of(1960, 12, 30));
        man.setPartner(new Woman(firstName, lastName, LocalDate.of(1974, 01, 01)));
        Assert.assertEquals(man.getPartner().getFirstName(), firstName, "Getter Partner first name is not correct");
        Assert.assertEquals(man.getPartner().getLastName(), lastName, "Getter Partner last name is not correct");
    }
    @Test
    @Parameters("status")
    public void testPersonGetStatus(String status){
        Person woman = new Woman("Hanna", "Ghoo", LocalDate.of(1985, 10, 5));
        woman.setStatus(Status.valueOf(status));
        Assert.assertEquals(woman.getStatus().name(), status, "Getter of Status doesn't work");
    }
}
