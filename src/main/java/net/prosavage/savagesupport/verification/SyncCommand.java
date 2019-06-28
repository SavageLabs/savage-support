package net.prosavage.savagesupport.verification;

import me.TechsCode.TechsCodeAPIClient.collections.PurchaseCollection;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import net.prosavage.savagesupport.Main;

import java.util.concurrent.TimeUnit;

public class SyncCommand {

    public static void syncCommand(Guild guild, User user, MessageChannel channel, String message) {
        if (!message.startsWith("!sync")) {
            return;
        }

        if (!Main.userData.userData.containsKey(user.getId())) {
            channel.sendMessage(new MessageBuilder("I dont have your data cached because I was restarted! Please make sure verified again or for the first time!").build()).queue();
            return;
        }


        PurchaseCollection purchases = VerificationAPIWrapper.getPurchases(Main.userData.userData.get(user.getId()).getSpigotName());


        purchases.getStream().forEach(purchase -> {
            // Check for Savage Buckets
            if (purchase.getResourceId().equals("63051")) {
                guild.getController().addRolesToMember(guild.getMember(user), getRole(guild, "savagebuckets")).queue();
                channel.sendMessage(new MessageBuilder("You have been given the savagebuckets role.").build()).queue(((m) ->
                        m.delete().queueAfter(30, TimeUnit.SECONDS)));

                // Check for Savage FTOP
            }
            if (purchase.getResourceId().equals("65205")) {
                guild.getController().addRolesToMember(guild.getMember(user), getRole(guild, "savageftop")).queue();
                channel.sendMessage(new MessageBuilder("You have been given the savageftop role.").build()).queue(((m) ->
                        m.delete().queueAfter(30, TimeUnit.SECONDS)));

            }
            if (purchase.getResourceId().equals("67574")) {
                guild.getController().addRolesToMember(guild.getMember(user), getRole(guild, "savagehoppers")).queue();
                channel.sendMessage(new net.dv8tion.jda.core.MessageBuilder("You have been given the savagehoppers role.").build()).queue(((m) ->
                        m.delete().queueAfter(30, TimeUnit.SECONDS)));

            }
        });


    }


    private static Role getRole(Guild guild, String name) {
        return guild.getRolesByName(name, true).get(0);
    }

}
