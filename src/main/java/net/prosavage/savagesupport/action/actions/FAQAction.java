package net.prosavage.savagesupport.action.actions;

import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.User;
import net.prosavage.savagesupport.action.Action;
import net.prosavage.savagesupport.messagebuilder.MessageBuilder;
import net.prosavage.savagesupport.storage.Questions;

public class FAQAction extends Action {

    String helpText = "Gives a FAQ list.";


    @Override
    public MessageEmbed processCommand(User user) {
        MessageBuilder messageBuilder = new MessageBuilder();
        messageBuilder.setTitle("Command FAQ");
        StringBuilder descriptionBuilder = new StringBuilder();
        Questions.questionAnswerMap.keySet().forEach(question -> descriptionBuilder
                .append("\n")
                .append("!")
                .append(question));
        messageBuilder.setDescription(descriptionBuilder.toString());
        return messageBuilder.build();
    }

    @Override
    public String getHelpText() {
        return this.helpText;
    }
}
