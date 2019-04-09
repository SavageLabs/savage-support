package net.prosavage.savagesupport.storage;

import net.dv8tion.jda.core.entities.MessageEmbed;
import net.prosavage.savagesupport.action.Embed;
import net.prosavage.savagesupport.action.embeds.TaskListEmbed;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Questions {
    public static Set<String> questionCompounds = new HashSet<>();

    public static HashMap<String, Embed> questionAnswerMap = new HashMap<>();


    static {
        questionCompounds.addAll(Arrays.asList("how", "?", "what", "when", "where"));
        questionAnswerMap.put("claim warzone", new TaskListEmbed("Claiming Warzone", new MessageEmbed.Field[]
                {
                        new MessageEmbed.Field("Step 1", "Make sure you are OP, have the '*' permission, or have admin permission for factions.", false),
                        new MessageEmbed.Field("Step 2", "Go into faction bypass mode by using **/f bypass**, this allows you to be in administrator mode.", false),
                        new MessageEmbed.Field("Step 3", "Use the command **/f claim *<radius>* warzone** to claim.\n*ex.   **/f claim 1 warzone***", false),
                        new MessageEmbed.Field("Extra Info", "You can use the command from **Step 3** to claim for any faction as an administrator.\n**/f claim <radius> <faction name>**\n*ex.   **/f claim 1 savagesupport***\n", false)
                }, "", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Antu_flag-red.svg/512px-Antu_flag-red.svg.png"));
    }
}
