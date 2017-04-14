package test;

import com.tonyodev.User;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by tonyofrancis on 4/14/17.
 */

@RunWith(JUnit4.class)
public class UserTest {


    @Test
    public void getUserNameTest() {

        User user = new User("Tonyo");
        Assert.assertNotNull(user.getName());
    }

}
