package net.prosavage.savagesupport.storage;

import net.dv8tion.jda.core.entities.MessageEmbed;
import net.prosavage.savagesupport.embed.Embed;
import net.prosavage.savagesupport.embed.embeds.TaskListEmbed;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Questions {
    public static Set<String> questionCompounds = new HashSet<>();

    public static HashMap<String, Embed> questionAnswerMap = new HashMap<>();


    static {
        questionCompounds.addAll(Arrays.asList("how", "?", "what", "when", "where", "why"));
        questionAnswerMap.put("claim warzone", new TaskListEmbed("Claiming Warzone", new MessageEmbed.Field[]
                {
                        new MessageEmbed.Field("Step 1", "Make sure you are OP, have the '*' permission, or have admin permission for factions.", false),
                        new MessageEmbed.Field("Step 2", "Go into faction bypass mode by using **/f bypass**, this allows you to be in administrator mode.", false),
                        new MessageEmbed.Field("Step 3", "Use the command **/f claim *<radius>* warzone** to claim.\n*ex.   **/f claim 1 warzone***", false),
                        new MessageEmbed.Field("Extra Info", "You can use the command from **Step 3** to claim for any faction as an administrator.\n**/f claim <radius> <faction name>**\n*ex.   **/f claim 1 savagesupport***\n", false)
                }, "", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Antu_flag-red.svg/512px-Antu_flag-red.svg.png"));
        questionAnswerMap.put("claim safezone", new TaskListEmbed("Claiming Safezone", new MessageEmbed.Field[]
                {
                        new MessageEmbed.Field("Step 1", "Make sure you are OP, have the '*' permission, or have admin permission for factions.", false),
                        new MessageEmbed.Field("Step 2", "Go into faction bypass mode by using **/f bypass**, this allows you to be in administrator mode.", false),
                        new MessageEmbed.Field("Step 3", "Use the command **/f claim *<radius>* safezone** to claim.\n*ex.   **/f claim 1 safezone***", false),
                        new MessageEmbed.Field("Extra Info", "You can use the command from **Step 3** to claim for any faction as an administrator.\n**/f claim <radius> <faction name>**\n*ex.   **/f claim 1 savagesupport***\n", false)
                }, "", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/Antu_flag-green.svg/512px-Antu_flag-green.svg.png"));
        questionAnswerMap.put("permissions", new TaskListEmbed("Doing Permissions", new MessageEmbed.Field[]
                {
                        new MessageEmbed.Field("Step 1", "Make sure you are OP, or have the '*' permission if your permissions manager requires it.", false),
                        new MessageEmbed.Field("Step 2", "[Click me to view permission nodes.](https://github.com/ProSavage/SavageFactions/wiki/SavageFactions-Permissions-List)", false),
                        new MessageEmbed.Field("Tip", "You can use the permission kits to get most of the permissions we suggest players should have.", false)
                }, "", "https://www.talkpoint.com/wp-content/uploads/ane-permissions-icon.png"));
    }
}
