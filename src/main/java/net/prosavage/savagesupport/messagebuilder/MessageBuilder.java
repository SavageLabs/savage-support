package net.prosavage.savagesupport.messagebuilder;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;

import java.awt.*;
import java.util.Map;

public class MessageBuilder {

    private EmbedBuilder embedBuilder = new EmbedBuilder();

    public MessageBuilder() {
        // Sets defaults.
        embedBuilder.setAuthor("Savage Support", "https://prosavage.net");
        embedBuilder.setColor(Color.getHSBColor((float) 121.38, (float) 59.36, (float) 85.88));
        embedBuilder.setThumbnail("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Antu_flag-red.svg/512px-Antu_flag-red.svg.png");
    }

    public void setTitle(String title) {
        embedBuilder.setTitle(title);
    }

    public void setFields(Map<String, String> fields) {
        fields.forEach((key, value) -> embedBuilder.addField(key, value, false));
    }

    public void setFields(MessageEmbed.Field[] fields) {
        for (MessageEmbed.Field field : fields) embedBuilder.addField(field);
    }

    public void setDescription(String description) {
        embedBuilder.setDescription(description);
    }

    public void setThumbnail(String url) {
        embedBuilder.setThumbnail(url);
    }


    public MessageEmbed build() {
        return embedBuilder.build();
    }


}
