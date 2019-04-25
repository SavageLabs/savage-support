package net.prosavage.savagesupport;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.prosavage.savagesupport.files.FileReader;
import net.prosavage.savagesupport.messages.MessageListener;
import net.prosavage.savagesupport.verification.UserData;

import javax.security.auth.login.LoginException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {


    public static JDA instance;
    public static UserData userData;

    public static void main(String[] args) {
        checkArguments(args);
        login(args[0]);
        instance.addEventListener(new MessageListener());
        loadData(args[1]);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Saving user data...");
            saveData(args[1]);
        }));

    }


    private static void saveData(String path) {
        new File(path + File.separator).mkdirs();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File(path + File.separator + "userdata.json");
        String userDataJson = gson.toJson(userData);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file.getPath(), false));
            writer.write(userDataJson);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private static void loadData(String path) {
        new File(path + File.separator).mkdirs();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File(path + File.separator + "userdata.json");
        if (file.exists()) {
            System.out.println("Loading User Data.");
            userData = gson.fromJson(new FileReader(file.getPath()).getFileContents(), UserData.class);
        } else {
            System.out.println("No UserData Found, creating new instance.");
            userData = new UserData();
            try {
                System.out.println("Trying to create " + file.getPath());
                if (file.createNewFile()) System.out.println("File Created");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


    }

    private static void checkArguments(String[] args) {
        if (args.length != 2) {
            throw new RuntimeException("You need to specify a discord bot token in arguments to run the bot & a path for userdata.");
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
