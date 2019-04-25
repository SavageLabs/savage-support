package net.prosavage.savagesupport.verification;

public class UserInfo {

    private String spigotName;
    private String discordId;
    private String spigotId;


    public UserInfo(String spigotName, String discordId, String spigotId) {
        this.spigotName = spigotName;
        this.discordId = discordId;
        this.spigotId = spigotId;
    }

    public String getSpigotId() {
        return spigotId;
    }

    public void setSpigotId(String spigotId) {
        this.spigotId = spigotId;
    }

    public String getDiscordId() {
        return discordId;
    }

    public void setDiscordId(String discordId) {
        this.discordId = discordId;
    }

    public String getSpigotName() {
        return spigotName;
    }

    public void setSpigotName(String spigotName) {
        this.spigotName = spigotName;
    }
}
