package model.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by SkaaRJ on 12.01.2018.
 */
public class ValidatorTest {



    Validator validator = new Validator();
    @Test
    public void isOnlyNumbers() throws Exception {
        String id = "1234";
        Assert.assertEquals(true, validator.isOnlyNumbers(id));
        id = "12а4";
        Assert.assertEquals(false, validator.isOnlyNumbers(id));
        id = "fа4";
        Assert.assertEquals(false, validator.isOnlyNumbers(id));
        id = "Ё4";
        Assert.assertEquals(false, validator.isOnlyNumbers(id));
        id = "ё";
        Assert.assertEquals(false, validator.isOnlyNumbers(id));
    }



    @Test
    public void checkFullNameFalse() throws Exception {
        String fullname = "Абрамова И. И.";
        Assert.assertEquals(false, validator.checkFullName(fullname));
        fullname = "Абрамова Ива И.";
        Assert.assertEquals(false, validator.checkFullName(fullname));
        fullname = "Певрое Второе";
        Assert.assertEquals(false, validator.checkFullName(fullname));
        fullname = "Певрое Второе Третье";
        Assert.assertEquals(true, validator.checkFullName(fullname));
        fullname = "Певрое Второе Третье Четвертое";
        Assert.assertEquals(false, validator.checkFullName(fullname));
        fullname = "Певрое Второе-Еще Третье";
        Assert.assertEquals(true, validator.checkFullName(fullname));
    }

}