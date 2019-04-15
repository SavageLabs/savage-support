package net.prosavage.savagesupport.messages;

import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.prosavage.savagesupport.messages.parser.parsers.CommandParser;
import net.prosavage.savagesupport.messages.parser.parsers.LinkParser;
import net.prosavage.savagesupport.messages.parser.parsers.QuestionParser;

public class MessageListener extends ListenerAdapter {

    private QuestionParser questionParser = new QuestionParser();
    private LinkParser linkParser = new LinkParser();
    private CommandParser commandParser = new CommandParser();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw().toLowerCase()
                // the word "the" is not required in the language.
                .replace(" the", "").replace("the", "");
        MessageEmbed messageEmbed = questionParser.parseQuestion(message);
        if (messageEmbed != null) event.getChannel().sendMessage(messageEmbed).queue();
        messageEmbed = linkParser.parseLink(message, event.getAuthor().getName());
        if (messageEmbed != null) {
            event.getMessage().delete().queue();
            event.getChannel().sendMessage(messageEmbed).queue();
        }
        messageEmbed = commandParser.parseCommand(message, event.getAuthor());
        if (messageEmbed != null) event.getChannel().sendMessage(messageEmbed).queue();



    }


}
