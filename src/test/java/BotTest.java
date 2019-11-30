import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BotTest {

    @Test
    public final void   assignName() {
        Bot test = new Bot();

        test.setName("hello");
        assertNotNull(test.getName());
        assertEquals("hello", test.getName());
    }

    @Test
    public final void   retrieveBotTags() {
        Bot test = new Bot();

        assertNotNull(test.getNameBotFromTag("@hello"));
        assertEquals("hello", test.getNameBotFromTag("@hello"));
    }

    @Test
    public final void   retrieveBotTagsWithBadValue() {
        Bot test = new Bot();

        assertNull(test.getNameBotFromTag("Bad"));
    }

    @Test
    public final void   assignNameWithBotTag() {
        Bot     test = new Bot();
        String  name = null;

        name = test.getNameBotFromTag("@hello");
        assertNotNull(name);
        assertEquals("hello", name);
        test.setName(name);
        assertNotNull(test.getName());
        assertEquals("hello", test.getName());
    }

}
