package datesourse;

import org.testng.annotations.DataProvider;
import personalization.Man;
import personalization.Woman;

import java.time.LocalDate;

    public class DateForDataProvider {
    @DataProvider(name = "person-data-null-mane-exception")
    public static Object[][] setUpPersonDataNullNameException(){
        Object[][] objects = {
                {"Nikola", null, LocalDate.of(1952, 01, 28)},
                {null, "Rango", LocalDate.of(2020, 05, 18)}};
        return objects;
    }
    @DataProvider(name = "person-data")
    public static Object[][] setUpPersonData(){
        Object[][] objects = {
                {"Nikola", "Bange", LocalDate.of(1952, 01, 28)},
                {"Juriiy", "Woo", LocalDate.of(1972, 11, 01)},
                {"Sergiiy", "Rango", LocalDate.of(2020, 05, 18)}};
        return objects;
    }

    @DataProvider(name = "person-data-name-exception")
    public static Object[][] setUpPersonDataNameException(){
        Object[][] objects = {
                {"N", "Bange", LocalDate.of(1952, 01, 28)},
                {"Juriiy", "W", LocalDate.of(1972, 11, 01)},
                {"", "Rango", LocalDate.of(2020, 05, 18)}};
        return objects;
    }

    @DataProvider(name = "woman-data-create-family")
        public static Object[][] setUpForManDataCreateFamily(){
        Object[][] objects = {
                {new Woman("Nina", "BLonde", LocalDate.of(1982, 1, 28)), false, true},
                {new Woman("Lara", "Kruello", LocalDate.of(1968, 9, 19)), false, true},
                {new Woman("Mirra", "Loo", LocalDate.of(1990, 10, 10)), true, false},
                {new Woman("Klara", "Rullo", LocalDate.of(1978, 5, 18)), true, false}};
        return objects;
    }
        @DataProvider(name = "man-data-create-family")
        public static Object[][] setUpForWomanDataCreateFamily(){
            Object[][] objects = {
                    {new Man("Nik", "Bonde", LocalDate.of(1982, 1, 28)), false, true},
                    {new Man("KarLos", "Ruello", LocalDate.of(1968, 9, 19)), false, true},
                    {new Man("Moor", "Loo", LocalDate.of(1990, 10, 10)), true, false},
                    {new Man("Larry", "Kruello", LocalDate.of(1978, 5, 18)), true, false}};
            return objects;
        }

    @DataProvider(name = "person-data-adopt-child")
        public static Object[][] setUpPersonDataAdoptChild(){
            Object[][] objects = {
                    {new Man("Nikola", "Bunge", LocalDate.of(2018, 01, 28)),},
                    {new Woman("Jully", "Woo", LocalDate.of(2020, 11, 01))},
                    {new Man("Serge", "Bingo", LocalDate.of(2022, 05, 18))}};
            return objects;
    }

    @DataProvider(name = "person-date-is-retired")
        public static Object[][] setUpManDataIsRetired(){
        Object[][] objects = {
                {"Lee", "Wong", LocalDate.of(1945, 10, 19)},
                {"Lee", "Wong", LocalDate.of(1962, 10, 19)},
                {"Lee", "Wong", LocalDate.of(1975, 10, 19)},
                {"Lee", "Wong", LocalDate.of(1955, 10, 19)},
        };
        return objects;
    }


}
