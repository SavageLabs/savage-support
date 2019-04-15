package net.prosavage.savagesupport.embed.embeds;

import net.dv8tion.jda.core.entities.MessageEmbed;
import net.prosavage.savagesupport.embed.Embed;
import net.prosavage.savagesupport.messagebuilder.MessageBuilder;

public class TaskListEmbed implements Embed {

    private final String header;
    private final MessageEmbed.Field[] tasks;
    private final String footer;
    private String thumbnailUrl;

    // TODO: Implement footer in the embed.
    public TaskListEmbed(String header, MessageEmbed.Field[] tasks, String footer, String thumbnailUrl) {
        this.header = header;
        this.tasks = tasks;
        this.footer = footer;
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public MessageEmbed build() {
        MessageBuilder messageBuilder = new MessageBuilder();
        messageBuilder.setTitle(header);
        messageBuilder.setFields(tasks);
        messageBuilder.setThumbnail(thumbnailUrl);
        return messageBuilder.build();
    }
}
