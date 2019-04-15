package net.prosavage.savagesupport.embed.embeds;

import net.dv8tion.jda.core.entities.MessageEmbed;
import net.prosavage.savagesupport.embed.Embed;
import net.prosavage.savagesupport.messagebuilder.MessageBuilder;

public class LinkEmbed implements Embed {

    private final String message;
    private final String link;
    private String author;

    public LinkEmbed(String message, String link, String author) {
        this.message = message;
        this.link = link;
        this.author = author;
    }

    @Override
    public MessageEmbed build() {
        System.out.println("Building link");
        MessageBuilder messageBuilder = new MessageBuilder();
        messageBuilder.setTitle("Link Posted");
        messageBuilder.setDescription(author + " said " + message);
        messageBuilder.setFields(new MessageEmbed.Field[]{new MessageEmbed.Field("Be careful when clicking links!", link, false)});
        return messageBuilder.build();
    }
}
