import org.junit.jupiter.api.Test;
import utils.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void setUserNameTest() {
        User user = new User("toto");

        assertEquals("toto", user.getName());
    }

    @Test
    public void setNullUserNameTest() {
        User user = new User();

        assertEquals("", user.getName());
    }
}
