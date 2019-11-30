package parsing;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class CommandLine {
    private static final int OPTION_NOT_FOUND = -1;
    private boolean parsedOnce = false;

    /**
     * These options are used to parse the arguments passed to the parse() method.
     */
    private ArrayList<Option> options = new ArrayList<>();

    public void addOption(Option o) {
        options.add(o);
    }

    private int findFirstOption(final Option option, final String[] inputs) {
        int i = 0;
        String opt = "-" + option.getOpt();
        String longOpt = "-" + option.getLongOpt();

        while (i < inputs.length) {
            if (inputs[i].equals(opt) || inputs[i].equals(longOpt)) {
                return i;
            }
            ++i;
        }
        return OPTION_NOT_FOUND;
    }

    /**
     * This method parse arguments passed to the program in the main function.
     * It translates the command line arguments directly to a readable map containing their values.
     *
     * @param argumentsToParse are the one received directly by the program.
     */
    public void evaluate(final String[] argumentsToParse) {
        for (Option option : this.options) {
            int pos = findFirstOption(option, argumentsToParse);
            if (isInputValid(argumentsToParse, pos)) {
                option.setValue(argumentsToParse[pos + 1]);
            } else if (option.isRequired()) {
                throw new IllegalArgumentException("Argument : -" + option.getOpt() + " is missing its value!");
            }
        }
    }

    private boolean isInputValid(String[] argumentsToParse, int pos) {
        return pos != OPTION_NOT_FOUND
                && pos + 1 < argumentsToParse.length
                && argumentsToParse[pos + 1].charAt(0) != '-';
    }

    public boolean isValid() {
        AtomicBoolean allOptionsAreValid = new AtomicBoolean(true);
        options.forEach((option -> {
            if (!option.isValid()) {
               allOptionsAreValid.set(false);
            }
        }));
        return allOptionsAreValid.get();
    }

    private Option getOption(String opt) {
        int i = 0;

        while (i < options.size()) {
            Option currentOption = options.get(i);
            if (currentOption.getOpt().equals(opt)) {
                return currentOption;
            }
            ++i;
        }
        return null;
    }

    public String getOptionValue(String opt) {
        Option option = getOption(opt);

        if (option == null || option.getValue() == null) {
            throw new NullPointerException("Call method hasOption() before trying to access options values");
        }

        return option.getValue();
    }

    public boolean hasOptions(String opt) {
        Option option = getOption(opt);
        return option != null && option.isValid() && option.getValue() != null;
    }

    public int size() {
        return options.size();
    }
}

