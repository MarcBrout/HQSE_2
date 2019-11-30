import java.util.HashMap;
import java.util.Map;

public class Bot {

    private String              name;
    private Map<String, String> botTags;

    public Bot() {
        this.name = null;
        this.botTags = new HashMap<>();
        botTags.put("@hello", "hello");
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

    public Boolean isBotCalledByEntry(String userEntry) {
        for (Map.Entry<String,String> entry : this.botTags.entrySet()) {
            if (entry.getKey().equals(userEntry)) {
                return true;
            }
        }
        return false;
    }
}
