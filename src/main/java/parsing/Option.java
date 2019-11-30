package parsing;

/**
 * An option represents an argument command line option.
 * It implements the builder pattern to allow for custom properties.
 */
public final class Option {
    private String opt;
    private String longOpt;
    private String description;
    private boolean isRequired = false;
    private String value;

    private Option(final Option.Builder builder) {
        this.opt = builder.opt;
        this.longOpt = builder.longOpt;
        this.description = builder.description;
        this.isRequired = builder.isRequired;
    }

    public String getOpt() {
        return opt;
    }

    public String getLongOpt() {
        return longOpt;
    }

    public String getDescription() {
        return description;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isValid() {
        return !this.isRequired || this.value != null;
    }

    public static final class Builder {
        private String opt;
        private String longOpt;
        private String description;
        private boolean isRequired = false;

        public Builder(final String opt) {
            this.opt = opt;
        }

        public Option build() {
            return new Option(this);
        }

        public Builder setLongOpt(final String longOpt) {
            this.longOpt = longOpt;
            return this;
        }

        public Builder setDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder setRequired(final boolean required) {
            isRequired = required;
            return this;
        }
    }
}
