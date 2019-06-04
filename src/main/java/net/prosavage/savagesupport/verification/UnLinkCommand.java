package net.prosavage.savagesupport.verification;

import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

import java.util.Arrays;
import java.util.List;

public class UnLinkCommand {


    private List<String> string = Arrays.asList("savagebuckets", "savageftop");

    public static void unLinkCommand(Guild guild, User user, MessageChannel channel, String message) {
        System.out.println("Checking message.");
        if (!message.startsWith("!unlink")
                || !guild.getMember(user).getRoles().contains(guild.getRolesByName("Staff", true).get(0))) {
            return;
        }

        if (message.split(" ").length != 2) {
            channel.sendMessage(new MessageBuilder("!unlink <user#0000>").build()).queue();
            return;
        }

        String[] args = message.split(" ");


        List<Member> members = guild.getMembersByName(args[1], true);
        if (members.size() != 1) {
            channel.sendMessage(new MessageBuilder("No users or more than one user found, please try again... '" + args[1] + "' did not match anything.").build()).queue();
            return;
        }

        Member member = members.get(0);

        if (member.getRoles().contains(guild.getRolesByName("savagebuckets", true).get(0)) ||)


    }


}
