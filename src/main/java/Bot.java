import java.util.HashMap;
import java.util.Map;

public class Bot {

    private String              name;
    private Map<String, String> botTags;

    public Bot() {
        this.name = null;
        this.botTags = new HashMap<>();
        botTags.put("@hello", "hello");
        botTags.put("@time", "time");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getBotTags() {
        return botTags;
    }
    public void setBotTags(Map<String, String> botTags) {
        this.botTags = botTags;
    }

    public String getNameBotFromTag(String tag) {
        return botTags.get(tag);
    }

    public void callBotByEntry(String userEntry) {
        String value = this.botTags.get(userEntry);

        if (value != null && !value.isEmpty()) {
            this.setName(value);
        }
        this.setName("system");
    }
}
