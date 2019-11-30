package parsing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OptionTest {
    private Option requiredOption;
    private Option optionalOption;

    @BeforeEach
    void prepare() {
        requiredOption = new Option.Builder("p")
                .setLongOpt("pseudo")
                .setRequired(true)
                .setDescription("This is the pseudonym that will be displayed to other users")
                .build();

        optionalOption = new Option.Builder("o")
                .setLongOpt("optional")
                .setRequired(false)
                .setDescription("Optional Option")
                .build();
    }

    @AfterEach
    void reset() {
        requiredOption = null;
        optionalOption = null;
    }

    @Test
    void getOpt() {
        Assertions.assertEquals("p", requiredOption.getOpt());
        Assertions.assertEquals("o", optionalOption.getOpt());
    }

    @Test
    void getLongOpt() {
        Assertions.assertEquals("pseudo", requiredOption.getLongOpt());
        Assertions.assertEquals("optional", optionalOption.getLongOpt());
    }

    @Test
    void getDescription() {
        Assertions.assertEquals("This is the pseudonym that will be displayed to other users",
                requiredOption.getDescription());
        Assertions.assertEquals("Optional Option", optionalOption.getDescription());
    }

    @Test
    void isRequired() {
        Assertions.assertTrue(requiredOption.isRequired());
        Assertions.assertFalse(optionalOption.isRequired());
    }

    @Test
    void setValue() {
        Assertions.assertNull(requiredOption.getValue());
        Assertions.assertNull(optionalOption.getValue());

        requiredOption.setValue("RoxorDu40");
        optionalOption.setValue("option");

        Assertions.assertEquals("RoxorDu40", requiredOption.getValue());
        Assertions.assertEquals("option", optionalOption.getValue());
    }

    @Test
    void getValue() {
        setValue();
    }

    @Test
    void isValid() {
        Assertions.assertFalse(requiredOption.isValid());
        Assertions.assertTrue(optionalOption.isValid());

        requiredOption.setValue("RoxorDu40");

        Assertions.assertTrue(requiredOption.isValid());
        Assertions.assertTrue(optionalOption.isValid());
    }
}
