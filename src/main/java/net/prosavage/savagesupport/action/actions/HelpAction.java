package net.prosavage.savagesupport.action.actions;

import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.User;
import net.prosavage.savagesupport.action.Action;
import net.prosavage.savagesupport.messagebuilder.MessageBuilder;
import net.prosavage.savagesupport.storage.Commands;

public class HelpAction extends Action {

    private String helpText = "Displays all valid commands and info about them.";


    @Override
    public MessageEmbed processCommand(User user) {
        MessageBuilder messageBuilder = new MessageBuilder();
        messageBuilder.setTitle("Command Help");
        StringBuilder descriptionBuilder = new StringBuilder();
        Commands.commands.keySet().forEach(command -> descriptionBuilder
                .append("\n")
                .append("!")
                .append(command)
                .append(" - ")
                .append(Commands.commands.get(command).getHelpText()));
        messageBuilder.setDescription(descriptionBuilder.toString());
        return messageBuilder.build();
    }

    @Override
    public String getHelpText() {
        return this.helpText;
    }

}
