package net.prosavage.savagesupport.messages.parser.parsers;

import net.dv8tion.jda.core.entities.MessageEmbed;
import net.prosavage.savagesupport.embed.embeds.LinkEmbed;
import net.prosavage.savagesupport.messages.parser.MessageParser;

public class LinkParser extends MessageParser {


    public MessageEmbed parseLink(String message, String author) {
        String[] words = message.split(" ");
        for (String link : words) {
            if (link.startsWith("http://") || link.startsWith("https://")) {
                return new LinkEmbed(message.replace("http://", "").replace("https://", ""), link, author).build();
            }
        }
        return null;
    }
}
