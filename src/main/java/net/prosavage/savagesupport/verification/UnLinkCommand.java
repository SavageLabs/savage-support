package net.prosavage.savagesupport.verification;

import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.User;

public class UnLinkCommand {


    public static void unLinkCommand(Guild guild, User user, Channel channel, String message) {
        if (!message.startsWith("!unlink")
                || !guild.getMember(user).getRoles().contains(guild.getRolesByName("Staff", true).get(0))) {
            return;
        }


    }


}
