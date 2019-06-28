package net.prosavage.savagesupport.messages;

import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.prosavage.savagesupport.messages.parser.parsers.CommandParser;
import net.prosavage.savagesupport.messages.parser.parsers.LinkParser;
import net.prosavage.savagesupport.messages.parser.parsers.QuestionParser;
import net.prosavage.savagesupport.verification.SyncCommand;
import net.prosavage.savagesupport.verification.UnLinkCommand;
import net.prosavage.savagesupport.verification.VerifyCommand;

public class MessageListener extends ListenerAdapter {

    private QuestionParser questionParser = new QuestionParser();
    private LinkParser linkParser = new LinkParser();
    private CommandParser commandParser = new CommandParser();
    private UnLinkCommand unLinkCommand = new UnLinkCommand();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        if (event.getChannel().getName().equals("verification") && !event.getMessage().getContentRaw().startsWith("!verify")) {
            event.getMessage().delete().queue();
        }
        String message = event.getMessage().getContentRaw().toLowerCase()
                // the word "the" is not required in the language.
                .replace(" the", "").replace("the", "");
        MessageEmbed messageEmbed = questionParser.parseQuestion(message);
        if (messageEmbed != null) event.getChannel().sendMessage(messageEmbed).queue();
        if (!event.getGuild().getMember(event.getAuthor()).getRoles().contains(event.getGuild().getRolesByName("Staff", true).get(0))) {
            messageEmbed = linkParser.parseLink(message, event.getAuthor().getName());
        }
        if (messageEmbed != null) {
            event.getMessage().delete().queue();
            event.getChannel().sendMessage(messageEmbed).queue();
        }
        messageEmbed = commandParser.parseCommand(message, event.getAuthor());
        if (messageEmbed != null) {
            event.getChannel().sendMessage(messageEmbed).queue();
            return;
        }
        VerifyCommand.verify(event.getGuild(), event.getChannel(), event.getMessage().getContentRaw().toLowerCase(), event.getAuthor());
        UnLinkCommand.unLinkCommand(event.getGuild(), event.getAuthor(), event.getChannel(), event.getMessage().getContentRaw());
        SyncCommand.syncCommand(event.getGuild(), event.getAuthor(), event.getChannel(), event.getMessage().getContentRaw());



    }


}
