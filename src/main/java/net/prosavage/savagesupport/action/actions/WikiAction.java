package net.prosavage.savagesupport.action.actions;

import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.User;
import net.prosavage.savagesupport.action.Action;
import net.prosavage.savagesupport.messagebuilder.MessageBuilder;

public class WikiAction extends Action {

    String helpText = "Provides a link to the wiki.";

    @Override
    public MessageEmbed processCommand(User user) {
        MessageBuilder messageBuilder = new MessageBuilder();
        messageBuilder.setTitle("Command Wiki");
        StringBuilder descriptionBuilder = new StringBuilder();
        descriptionBuilder.append("[Click here to go to the SavageFactions Wiki.](https://github.com/ProSavage/SavageFactions/wiki)");
        messageBuilder.setDescription(descriptionBuilder.toString());
        return messageBuilder.build();
    }

    @Override
    public String getHelpText() {
        return this.helpText;
    }
}
