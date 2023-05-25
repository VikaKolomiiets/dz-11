package womantests;

import datesourse.DateForDataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import personalization.Man;
import personalization.Woman;

import java.time.LocalDate;

public class WomanCreateFamilyTests {
    private Woman woman;
    @BeforeMethod
    public void setUpWoman(){
        this.woman = new Woman("Inna", "Krassovsky", LocalDate.of(1980, 01, 06 ));
    }

    @AfterMethod
    public void tearDown(){
        this.woman = null;
    }

    @Test(dataProviderClass = DateForDataProvider.class, dataProvider = "man-data-create-family")
    public void testWomanCreateFamilyPositive(Man newHusband, boolean isChangeLastName, boolean isChangeLastNameNewHusband){

        this.woman.createFamily(newHusband, isChangeLastName, isChangeLastNameNewHusband);
        Assert.assertNotNull(this.woman.getPartner(), "Family was not created");
        Assert.assertEquals(this.woman.getPartner().getFirstName(), newHusband.getFirstName(), "The FirstName of Husband doesn't correct");
        Assert.assertEquals(this.woman.getPartner().getLastName(), newHusband.getLastName(), "The LastName of Husband doesn't correct");
        Assert.assertEquals(this.woman.getPartner().getDateOfBirth(), newHusband.getDateOfBirth(), "The LastName of Husband doesn't correct");
    }
    
}
