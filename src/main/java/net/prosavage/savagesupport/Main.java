package net.prosavage.savagesupport;


import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.prosavage.savagesupport.messages.MessageListener;

import javax.security.auth.login.LoginException;

public class Main {


    public static JDA instance;

    public static void main(String[] args) {
        checkArguments(args);
        login(args[0]);
        instance.addEventListener(new MessageListener());

    }

    private static void checkArguments(String[] args) {
        if (args.length != 1) {
            throw new RuntimeException("You need to specify a discord bot token in arguments to run the bot.");
        }
    }

    private static void login(String token) {
        JDABuilder builder = new JDABuilder(token);
        try {
            instance = builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
