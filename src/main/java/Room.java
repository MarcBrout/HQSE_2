import utils.CurrentDate;
import utils.User;

import java.util.Scanner;

public class Room {

    private Bot         bot;
    private User        user;
    private String      name;

    public Room() {
        this.name = null;
        this.bot = new Bot();
        this.user = null;
    }

    public Bot getBot() {
        return bot;
    }
    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void startRoom() {
        String  entry = getEntryUser();


        this.checkEntry(entry);
        while (!entry.equals("++")) {
            entry = getEntryUser();
            this.checkEntry(entry);
        }
    }

    private void    checkEntry(String entry) {
        if (this.bot.isBotCalledByEntry(entry)) {
            this.displayBotMessage();
        }
    }

    private String  getEntryUser() {
        Scanner input = new Scanner(System.in);

        System.out.print("[" + this.user.getName() + "] ");

        return input.next();
    }

    private void    displayBotMessage() {
        CurrentDate currentDate = new CurrentDate();

        System.out.println("[" + this.bot.getName() + "] Salut " + this.user.getName()
                + "! Nous sommes " + currentDate.getCurrentDate()
                + " et il est " + currentDate.getCurrentHour() + ".");
    }
}
