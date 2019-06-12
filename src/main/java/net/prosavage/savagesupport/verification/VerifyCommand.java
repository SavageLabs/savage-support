package net.prosavage.savagesupport.verification;


import me.TechsCode.TechsCodeAPIClient.collections.PurchaseCollection;
import net.dv8tion.jda.core.entities.*;
import net.prosavage.savagesupport.Main;
import net.prosavage.savagesupport.messagebuilder.MessageBuilder;
import net.prosavage.savagesupport.verification.profiles.ProfileComment;
import net.prosavage.savagesupport.verification.profiles.ProfileCommentFetcher;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class VerifyCommand {


    private static String randomCode() {
        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't'};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            stringBuilder.append(chars[ThreadLocalRandom.current().nextInt(0, chars.length)]);
        }
        return stringBuilder.toString();
    }


    public static void verify(Guild guild, MessageChannel channel, String message, User user) {
        if (!message.startsWith("!verify") || message.split(" ").length > 2) return;
        if (!channel.getName().equals("verification")) {
            MessageBuilder messageBuilder = new MessageBuilder();
            messageBuilder.setTitle("Please verify your self in the #verification channel");
            messageBuilder.setDescription("Use the command !verify <spigotname>.");
            channel.sendMessage(messageBuilder.build()).queue();
            return;
        }
        String[] args = message.split(" ");
        if (args.length == 1) {
            MessageBuilder messageBuilder = new MessageBuilder();
            messageBuilder.setTitle("How to verify your self");
            messageBuilder.setDescription("You need to use the command like:");
            messageBuilder.setFields(new MessageEmbed.Field[]{
                    new MessageEmbed.Field("Usage", "!verify <spigotname>", false),
                    new MessageEmbed.Field("Example", "!verify SpigotName", false)
            });
            channel.sendMessage(messageBuilder.build()).queue();
            return;
        }

        if (Main.userData.userData.containsKey(user.getId())) {
            String spigotAcc = Main.userData.userData.get(user.getId()).getSpigotName();
            MessageBuilder messageBuilder = new MessageBuilder();
            messageBuilder.setTitle("You are already synced with the spigot account: " + spigotAcc);
            messageBuilder.setDescription("Use the command !sync to sync your roles.\n" +
                    " If you would like to sync a new account, please contact an admin.");
            channel.sendMessage(messageBuilder.build()).queue();
            return;
        }

        String spigotUsername = args[1];

        if (!VerificationAPIWrapper.checkIfOwnsPlugins(spigotUsername)) {
            MessageBuilder dontOwnPlugins = new MessageBuilder();
            dontOwnPlugins.setTitle("Verification Error");
            dontOwnPlugins.setDescription("The specified username does not own any of our premium plugins on spigot.");
            channel.sendMessage(dontOwnPlugins.build()).queue();
            return;
        }

        String userID = VerificationAPIWrapper.getUserId(spigotUsername);
        String code = randomCode();

        MessageBuilder messageBuilder = new MessageBuilder();
        messageBuilder.setTitle("Verification Process");
        messageBuilder.setDescription("Go to your profile and post the following message in bold:");
        messageBuilder.setFields(new MessageEmbed.Field[]{
                new MessageEmbed.Field("ProSavage Verification -- " + code,
                        "Your profile is https://spigotmc.org/members/" + userID + "\n Do this in the next 3 minutes.", false)
        });
        channel.sendMessage(messageBuilder.build()).queue();

        new Thread(() -> {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < TimeUnit.MINUTES.toMillis(3)) {
                for (ProfileComment all : ProfileCommentFetcher.getComments(userID)) {
                    if (all.getUserId().equals(userID) &&
                            (all.getText().equals("ProSavage Verification -- " + code) || all.getText().equals(code))) {
                        MessageBuilder verificationComplete = new MessageBuilder();
                        verificationComplete.setTitle("Verification Complete");
                        verificationComplete.setDescription("You have been verified " + user.getAsTag() + " make sure to use the !sync command next!");
                        channel.sendMessage(verificationComplete.build()).queue();
                        Main.userData.userData.put(user.getId(), new UserInfo(spigotUsername.toLowerCase(), user.getId(), userID));
                        Role verified = Main.instance.getRolesByName("verified", true).get(0);
                        guild.getController().addRolesToMember(guild.getMember(user), verified).queue();
                        PurchaseCollection purchases = VerificationAPIWrapper.getPurchases(Main.userData.userData.get(user.getId()).getSpigotName());
                        purchases.getStream().forEach(purchase -> {
                            // Check for Savage Buckets
                            if (purchase.getResourceId().equals("63051")) {
                                guild.getController().addRolesToMember(guild.getMember(user), getRole(guild, "savagebuckets")).queue();
                                channel.sendMessage(new net.dv8tion.jda.core.MessageBuilder("You have been given the savagebuckets role.").build()).queue(((m) ->
                                        m.delete().queueAfter(30, TimeUnit.SECONDS)));

                                // Check for Savage FTOP
                            }
                            if (purchase.getResourceId().equals("65205")) {
                                guild.getController().addRolesToMember(guild.getMember(user), getRole(guild, "savageftop")).queue();
                                channel.sendMessage(new net.dv8tion.jda.core.MessageBuilder("You have been given the savageftop role.").build()).queue(((m) ->
                                        m.delete().queueAfter(30, TimeUnit.SECONDS)));
                                ;

                            }
                        });
                        return;
                    }
                }
            }
            MessageBuilder verificationComplete = new MessageBuilder();
            verificationComplete.setTitle("Verification Failed");
            verificationComplete.setDescription("Verification Timed Out " + user.getAsTag());
            channel.sendMessage(verificationComplete.build()).queue();
        }).start();


    }

    private static Role getRole(Guild guild, String name) {
        return guild.getRolesByName(name, true).get(0);
    }

}
