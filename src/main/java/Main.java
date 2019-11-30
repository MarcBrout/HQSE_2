import parsing.CommandLine;
import parsing.Option;
import utils.User;

public final class Main {
    /**
     * Main function.
     *
     * @param argv incoming argument from user.
     */
    public static void main(final String[] argv) {
        Room chat = new Room();
        Option pseudoOption = new Option.Builder("p")
                .setLongOpt("pseudo")
                .setRequired(true)
                .setDescription("This pseudonym will be used in the chat room.")
                .build();

        CommandLine commandLine = new CommandLine();
        commandLine.addOption(pseudoOption);
        commandLine.evaluate(argv);

        if (commandLine.isValid() && commandLine.hasOptions("p")) {
            String username = commandLine.getOptionValue("p");
            chat.setUser(new User(username));
            chat.startRoom();
        }
    }

    private Main() {

    }
}
