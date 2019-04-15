package net.prosavage.savagesupport.action;

import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.User;

public abstract class Action {


    public abstract MessageEmbed processCommand(User user);

    public abstract String getHelpText();
}
