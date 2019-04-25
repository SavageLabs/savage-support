package net.prosavage.savagesupport.action.actions;

import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.User;
import net.prosavage.savagesupport.action.Action;
import net.prosavage.savagesupport.messagebuilder.MessageBuilder;

public class VerifyAction extends Action {

    private String helpText = "verify your account.";

    @Override
    public MessageEmbed processCommand(User user) {
        MessageBuilder messageBuilder = new MessageBuilder();
        messageBuilder.setTitle("Command Verify");
        StringBuilder descriptionBuilder = new StringBuilder();
        descriptionBuilder.append("Go to your ");
        messageBuilder.setDescription(descriptionBuilder.toString());
        return messageBuilder.build();
    }

    @Override
    public String getHelpText() {
        return this.helpText;
    }
}
