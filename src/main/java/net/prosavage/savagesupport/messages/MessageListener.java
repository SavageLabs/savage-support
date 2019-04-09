package net.prosavage.savagesupport.messages;

import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.prosavage.savagesupport.messages.parser.parsers.QuestionParser;

public class MessageListener extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw().toLowerCase();
        QuestionParser questionParser = new QuestionParser();
        MessageEmbed messageEmbed = questionParser.parseQuestion(message);
        event.getChannel().sendMessage(messageEmbed).queue();
    }


}
