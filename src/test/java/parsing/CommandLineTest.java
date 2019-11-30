package parsing;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CommandLineTest {
    Option optionP;
    Option optionO;
    Option optionL;
    CommandLine commandLine;

    @BeforeEach
    void prepare() {
        commandLine = new CommandLine();
        optionP = new Option.Builder("p")
                .setLongOpt("pseudo")
                .setRequired(true)
                .setDescription("This is the pseudonym that will be displayed to other users")
                .build();

        optionO = new Option.Builder("o")
                .setLongOpt("optional")
                .setRequired(false)
                .setDescription("Optional Option")
                .build();

        optionL = new Option.Builder("l")
                .setLongOpt("long")
                .setRequired(true)
                .setDescription("long option")
                .build();

        commandLine.addOption(optionP);
        commandLine.addOption(optionO);
        commandLine.addOption(optionL);
    }

    @AfterEach
    void clean() {
        commandLine = null;
        optionL = null;
        optionO = null;
        optionP = null;
    }

    @Test
    void addOption() {
        assertEquals(3, commandLine.size());
    }

    @Test
    void evaluate() {
        assertThrows(IllegalArgumentException.class, () -> commandLine.evaluate(new String[] { "-p", "pseudo", "-l" }));
        assertDoesNotThrow(() -> commandLine.evaluate(new String[] { "-p", "pseudo", "-l", "longArgument" }));
    }

    @Test
    void isValid() {
        assertDoesNotThrow(() -> commandLine.evaluate(new String[] { "-p", "pseudo", "-l", "longArgument" }));
        assertTrue(commandLine.isValid());
    }

    @Test
    void getOptionValue() {
        assertDoesNotThrow(() -> commandLine.evaluate(new String[] { "-p", "pseudo", "-l", "longArgument" }));
        assertTrue(commandLine.isValid());

        assertThrows(RuntimeException.class, () -> commandLine.getOptionValue("o"));
        assertDoesNotThrow(() -> commandLine.getOptionValue("p"));
        assertDoesNotThrow(() -> commandLine.getOptionValue("l"));
    }

    @Test
    void hasOptions() {
        assertDoesNotThrow(() -> commandLine.evaluate(new String[] { "-p", "pseudo", "-l", "longArgument" }));
        assertTrue(commandLine.hasOptions("p"));
        assertFalse(commandLine.hasOptions("o"));
        assertTrue(commandLine.hasOptions("l"));
    }
}