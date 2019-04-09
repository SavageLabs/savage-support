package net.prosavage.savagesupport;


import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;


import javax.security.auth.login.LoginException;

public class Main {


    public static JDA instance;

    public static void main(String[] args) {
        checkArguments(args);
        login();

    }

    private static void checkArguments(String[] args) {
        if (args.length != 1) {
            throw new RuntimeException("You need to add a discord bot token to run this.");
        }
    }

    private static void login() {
        JDABuilder builder = new JDABuilder();
        try {
            instance = builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
