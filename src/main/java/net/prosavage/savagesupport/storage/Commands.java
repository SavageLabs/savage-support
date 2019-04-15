package net.prosavage.savagesupport.storage;

import net.prosavage.savagesupport.action.Action;
import net.prosavage.savagesupport.action.actions.FAQAction;
import net.prosavage.savagesupport.action.actions.HelpAction;
import net.prosavage.savagesupport.action.actions.WikiAction;

import java.util.HashMap;

public class Commands {

    public static HashMap<String, Action> commands = new HashMap<>();


    static {

        commands.put("help", new HelpAction());
        commands.put("faq", new FAQAction());
        commands.put("wiki", new WikiAction());

    }


}
